package food_ordering_system.restaurant_service.service;

import food_ordering_system.restaurant_service.dto.FoodDto;
import food_ordering_system.restaurant_service.entity.Food;
import java.util.List;

public interface FoodService {
    Food addRestaurantFoodItem(Long id, Food food);
    List<Food> getRestaurantFoodList(Long id);
    Food getRestaurantFoodById(Long ResId,Long foodId);
    Food updateRestaurantFoodItem(Long ResId, Long foodId, FoodDto dto);
    void deleteRestaurantFoodItem(Long ResId,Long foodId);
}
