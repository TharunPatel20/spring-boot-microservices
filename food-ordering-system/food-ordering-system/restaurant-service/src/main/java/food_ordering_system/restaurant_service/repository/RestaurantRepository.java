package food_ordering_system.restaurant_service.repository;

import food_ordering_system.restaurant_service.entity.Food;
import food_ordering_system.restaurant_service.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}
