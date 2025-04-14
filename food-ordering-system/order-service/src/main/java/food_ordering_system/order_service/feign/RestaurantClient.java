package food_ordering_system.order_service.feign;

import food_ordering_system.order_service.dto.Food;
import food_ordering_system.order_service.dto.Restaurant;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "RESTAURANT-SERVICE")
public interface RestaurantClient {

    @GetMapping("/restaurants/{id}")
    public Optional<Restaurant> getRestaurantById(@PathVariable Long id);

    @GetMapping("/restaurants")
    public List<Restaurant> getAllRestaurants();

//    @GetMapping
//    public List<Food> getFoods(@PathVariable Long restaurantId);

    @GetMapping("/restaurants/{restaurantId}/foods/{foodId}")
    Optional<Food> getFoodById(@PathVariable Long restaurantId, @PathVariable Long foodId);
}