package food_ordering_system.restaurant_service.service;

import food_ordering_system.restaurant_service.dto.RestaurantDto;
import food_ordering_system.restaurant_service.entity.Food;
import food_ordering_system.restaurant_service.entity.Restaurant;
import food_ordering_system.restaurant_service.exceptions.RestaurantNotFoundException;

import java.util.List;
import java.util.Optional;

public interface RestaurantService {
    Optional<Restaurant> getResRestaurantById(Long id);
    List<Restaurant> getAllRestaurant();
    Restaurant addRestaurant(Restaurant restaurant);
    Restaurant updateRestaurant(Long id, Restaurant restaurant) throws RestaurantNotFoundException;
    void deleteRestaurantById(Long id);

}
