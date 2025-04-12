package food_ordering_system.restaurant_service.service;

import food_ordering_system.restaurant_service.entity.Food;
import food_ordering_system.restaurant_service.entity.Restaurant;
import food_ordering_system.restaurant_service.exceptions.RestaurantNotFoundException;
import food_ordering_system.restaurant_service.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantServiceImpl implements RestaurantService{

    @Autowired
    RestaurantRepository restaurantRepository;

    @Override
    public Optional<Restaurant> getResRestaurantById(Long id) {
        return restaurantRepository.findById(id);
    }

    @Override
    public List<Restaurant> getAllRestaurant() {
        return restaurantRepository.findAll();
    }

    @Override
    public Restaurant addRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @ExceptionHandler
    @Override
    public Restaurant updateRestaurant(Long id,Restaurant restaurant)  {
        var old =  restaurantRepository.findById(id)
                .orElseThrow(() -> new RestaurantNotFoundException("Restaurant with ID " + id + " not found"));

        old.setName(restaurant.getName());
        old.setAddress(restaurant.getAddress());
        return restaurantRepository.saveAndFlush(old);
    }

    @Override
    public void deleteRestaurantById(Long id) {
        restaurantRepository.deleteById(id);
    }
}
