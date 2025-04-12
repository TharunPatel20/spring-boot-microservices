package food_ordering_system.restaurant_service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record FoodDto(
        @NotBlank(message = "Food name must not be blank")
        String name,

        @NotBlank(message = "Food description must not be blank")
        String description,

        @Positive(message = "Price must be greater than 0")
        double price
) {}
