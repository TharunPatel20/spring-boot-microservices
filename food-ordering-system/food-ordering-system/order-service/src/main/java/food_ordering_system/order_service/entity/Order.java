package food_ordering_system.order_service.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue
    private Long id;

    // Use Long to store the restaurant's ID instead of storing the whole Restaurant object
    private Long restaurantId; // Store only the restaurant ID as Long

    @ElementCollection
    @CollectionTable(name = "order_foods", joinColumns = @JoinColumn(name = "order_id"))
    @Column(name = "food_id")
    private List<Long> foodIds; // Store food IDs instead of the entire Food entity

    private double totalPrice;

    public Order() {}

    // Updated constructor, using Long for restaurantId instead of Restaurant object
    public Order(Long restaurantId, List<Long> foodIds, double totalPrice) {
        this.restaurantId = restaurantId;
        this.foodIds = foodIds;
        this.totalPrice = totalPrice;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public List<Long> getFoodIds() {
        return foodIds;
    }

    public void setFoodIds(List<Long> foodIds) {
        this.foodIds = foodIds;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
