package food_ordering_system.restaurant_service.repository;

import food_ordering_system.restaurant_service.entity.Food;
import food_ordering_system.restaurant_service.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FoodRepository extends JpaRepository<Food, Long> {
    List<Food> findByRestaurant(Restaurant restaurant);
    Optional<Food> findByIdAndRestaurant(Long id, Restaurant restaurant);
}
