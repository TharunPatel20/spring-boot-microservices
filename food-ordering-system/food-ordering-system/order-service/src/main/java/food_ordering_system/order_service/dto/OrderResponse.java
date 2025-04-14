package food_ordering_system.order_service.dto;

import java.util.List;

public record OrderResponse (
     Long orderId,
     Restaurant restaurant,
     List<Food> foods,
     double totalPrice
){}

