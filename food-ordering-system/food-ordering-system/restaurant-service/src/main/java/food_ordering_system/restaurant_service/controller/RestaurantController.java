package food_ordering_system.restaurant_service.controller;

import food_ordering_system.restaurant_service.dto.RestaurantDto;
import food_ordering_system.restaurant_service.entity.Restaurant;
import food_ordering_system.restaurant_service.service.RestaurantServiceImpl;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    private final RestaurantServiceImpl restaurantService;

    public RestaurantController(RestaurantServiceImpl restaurantService) {
        this.restaurantService = restaurantService;
    }

    @PostMapping
    public Restaurant addRestaurant(@Valid @RequestBody RestaurantDto dto) {
        Restaurant newRestaurant = new Restaurant(dto.name(), dto.address());
        return restaurantService.addRestaurant(newRestaurant);
    }

    @GetMapping("/{id}")
    public Optional<Restaurant> getRestaurantById(@PathVariable Long id) {
        return restaurantService.getResRestaurantById(id);
    }

    @GetMapping
    public List<Restaurant> getAllRestaurants() {
        return restaurantService.getAllRestaurant();
    }

    @PutMapping("/{id}")
    public Restaurant updateRestaurantInfo(@PathVariable Long id, @Valid @RequestBody RestaurantDto dto) {
        return restaurantService.updateRestaurant(id, new Restaurant(dto.name(), dto.address()));
    }

    @DeleteMapping("/{id}")
    public void deleteRestaurant(@PathVariable Long id) {
        restaurantService.deleteRestaurantById(id);
    }
}
