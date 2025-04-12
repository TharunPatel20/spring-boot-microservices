package food_ordering_system.order_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name="orders")
public class Order {
    @Id
    private Long id;
    private Restaurant restaurant;
    private List<Food> foods;
    private double totalPrice;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public List<Food> getFoods() {
        return foods;
    }

    public Order(Restaurant restaurant, List<Food> foods, double totalPrice) {
        this.restaurant = restaurant;
        this.foods = foods;
        this.totalPrice = totalPrice;
    }

    public void setFoods(List<Food> foods) {
        this.foods = foods;
    }
    public Order(){}

}
