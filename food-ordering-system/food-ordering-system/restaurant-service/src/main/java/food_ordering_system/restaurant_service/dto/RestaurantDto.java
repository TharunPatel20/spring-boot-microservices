package food_ordering_system.restaurant_service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RestaurantDto(
        @NotBlank(message = "Name must not be blank")
        @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
        String name,

        @NotBlank(message = "Address must not be blank")
        @Size(min = 5, max = 200, message = "Address must be between 5 and 200 characters")
        String address
) {}
