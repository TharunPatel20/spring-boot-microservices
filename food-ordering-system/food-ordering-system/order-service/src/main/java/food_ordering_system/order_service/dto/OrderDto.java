package food_ordering_system.order_service.dto;

import java.util.List;

public record OrderDto(Long resId, List<Long> FoodIds) {
}
