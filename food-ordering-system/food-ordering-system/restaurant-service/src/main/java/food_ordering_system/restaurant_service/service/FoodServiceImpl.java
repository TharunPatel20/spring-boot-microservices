package food_ordering_system.restaurant_service.service;

import food_ordering_system.restaurant_service.dto.FoodDto;
import food_ordering_system.restaurant_service.entity.Food;
import food_ordering_system.restaurant_service.entity.Restaurant;
import food_ordering_system.restaurant_service.exceptions.FoodNotFoundException;
import food_ordering_system.restaurant_service.exceptions.RestaurantNotFoundException;
import food_ordering_system.restaurant_service.repository.FoodRepository;
import food_ordering_system.restaurant_service.repository.RestaurantRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodServiceImpl implements FoodService {

    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public Food addRestaurantFoodItem(Long restaurantId, Food food) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new RestaurantNotFoundException("Restaurant not found"));

        food.setRestaurant(restaurant);
        return foodRepository.save(food);
    }

    @Override
    public List<Food> getRestaurantFoodList(Long restaurantId) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new RestaurantNotFoundException("Restaurant not found"));

        return foodRepository.findByRestaurant(restaurant);
    }

    @Override
    public Food getRestaurantFoodById(Long restaurantId, Long foodId) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new RestaurantNotFoundException("Restaurant not found"));

        return foodRepository.findByIdAndRestaurant(foodId, restaurant)
                .orElseThrow(() -> new FoodNotFoundException("Food item not found"));
    }

    @Override
    public Food updateRestaurantFoodItem(Long restaurantId, Long foodId, FoodDto dto) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new RestaurantNotFoundException("Restaurant not found"));

        Food food = foodRepository.findByIdAndRestaurant(foodId, restaurant)
                .orElseThrow(() -> new FoodNotFoundException("Food item not found"));

        food.setName(dto.name());
        food.setDescription(dto.description());
        food.setPrice(dto.price());

        return foodRepository.save(food);
    }

    @Override
    public void deleteRestaurantFoodItem(Long restaurantId, Long foodId) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new RestaurantNotFoundException("Restaurant not found"));

        Food food = foodRepository.findByIdAndRestaurant(foodId, restaurant)
                .orElseThrow(() -> new FoodNotFoundException("Food item not found"));

        foodRepository.delete(food);
    }
}
