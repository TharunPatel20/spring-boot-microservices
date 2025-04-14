package food_ordering_system.order_service.dto;

public record Food(
        Long id,
        String name,
        double price,
        String description,
        String category
) {}
