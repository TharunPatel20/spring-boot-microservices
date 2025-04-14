package food_ordering_system.order_service.dto;

import java.util.List;

public record Restaurant(
        Long id,
        String name,
        String address,
        List<Food> menu
) {}
