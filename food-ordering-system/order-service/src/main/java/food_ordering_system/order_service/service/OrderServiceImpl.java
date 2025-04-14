package food_ordering_system.order_service.service;

import food_ordering_system.order_service.dto.Food;
import food_ordering_system.order_service.dto.OrderDto;
import food_ordering_system.order_service.dto.OrderResponse;
import food_ordering_system.order_service.dto.Restaurant;
import food_ordering_system.order_service.entity.Order;
import food_ordering_system.order_service.exception.OrderNotFoundException;
import food_ordering_system.order_service.exception.RestaurantNotFoundException;
import food_ordering_system.order_service.feign.RestaurantClient;
import food_ordering_system.order_service.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RestaurantClient restaurantClient;

    public Order orderFood(OrderDto dto) {
        // Fetch restaurant details using Feign client
        var restaurant = restaurantClient.getRestaurantById(dto.resId())
                .orElseThrow(() -> new RestaurantNotFoundException("Restaurant with id " + dto.resId() + " not found!"));

        // Fetch food details using the food IDs provided in the order
        List<Food> food = getFoodListWithIds(dto.resId(), dto.FoodIds());

        // Calculate total price for the order
        double totalPrice = calculateTotalPrice(food);

        // Create a new order entity, storing only the restaurant ID
        var newOrder = new Order(dto.resId(), dto.FoodIds(), totalPrice);

        // Save the order to the repository
        return orderRepository.save(newOrder);
    }

    // Helper method to fetch food list by food IDs
    public List<Food> getFoodListWithIds(Long resId, List<Long> foodIds) {
        return foodIds.stream()
                .map(foodId -> restaurantClient.getFoodById(resId, foodId)
                        .orElseThrow(() -> new RuntimeException("Food with id " + foodId + " not found")))
                .collect(Collectors.toList());
    }

    // Helper method to calculate the total price for the order
    public double calculateTotalPrice(List<Food> foods) {
        double totalPrice = 0.0;
        for (Food food : foods) {
            totalPrice += food.price(); // Assuming Food has a getPrice() method
        }
        return totalPrice;
    }

    public OrderResponse getOrderDetails(Long id) {
        // Get order entity from DB
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException("Order with id " + id + " not found"));

        // Fetch restaurant data from Restaurant service
        Restaurant restaurant = restaurantClient.getRestaurantById(order.getRestaurantId())
                .orElseThrow(() -> new RestaurantNotFoundException("Restaurant with id " + order.getRestaurantId() + " not found!"));

        // Fetch food details for each foodId
        List<Food> OrderedFoodItems = order.getFoodIds().stream()
                .map(foodId -> restaurantClient.getFoodById(order.getRestaurantId(), foodId)
                        .orElseThrow(() -> new RuntimeException("Food with id " + foodId + " not found")))
                .collect(Collectors.toList());

        // Return the combined response DTO
        return new OrderResponse(order.getId(), restaurant, OrderedFoodItems, order.getTotalPrice());
    }

    @Override
    public String cancelOrder(Long id) {
        var order = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException("Order with id " + id + " not found"));

        orderRepository.deleteById(id);
        return "deleted";
    }




    public ResponseEntity<?>  getAllOrderDetails() {
        var orders = orderRepository.findAll();
        if (orders.isEmpty()){
            return ResponseEntity.ok().body("no orders yet.!");
        }
        var  foundOrders = orders.stream()
                .map(order -> {
                    OrderResponse response = getOrderDetails(order.getId());

                    // Manually trim menu from restaurant
                    var res = response.restaurant();
                    var trimmedRestaurant = new Restaurant(res.id(), res.name(),res.address(),List.of());
                    return new OrderResponse(
                            response.orderId(),
                            trimmedRestaurant,
                            response.foods(),
                            response.totalPrice()
                    );
                })
                .filter(response -> response.totalPrice() > 0) // example filter
                .toList();

        return ResponseEntity.ok().body(foundOrders);
    }

}

