package food_ordering_system.restaurant_service.controller;

import food_ordering_system.restaurant_service.dto.FoodDto;
import food_ordering_system.restaurant_service.entity.Food;
import food_ordering_system.restaurant_service.service.FoodService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants/{restaurantId}/foods")
public class FoodController {

    private final FoodService foodService;


    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @PostMapping
    public Food addFood(@PathVariable Long restaurantId,@Valid @RequestBody Food food) {
        return foodService.addRestaurantFoodItem(restaurantId, food);
    }

    @GetMapping
    public List<Food> getFoods(@PathVariable Long restaurantId) {
        return foodService.getRestaurantFoodList(restaurantId);
    }

    @GetMapping("/{foodId}")
    public Food getFoodById(@PathVariable Long restaurantId, @PathVariable Long foodId) {
        return foodService.getRestaurantFoodById(restaurantId, foodId);
    }

    @PutMapping("/{foodId}")
    public Food updateFood(@PathVariable Long restaurantId, @PathVariable Long foodId, @Valid FoodDto dto) {
        return foodService.updateRestaurantFoodItem(restaurantId, foodId, dto);
    }

    @DeleteMapping("/{foodId}")
    public void deleteFood(@PathVariable Long restaurantId, @PathVariable Long foodId) {
        foodService.deleteRestaurantFoodItem(restaurantId, foodId);
    }
}
