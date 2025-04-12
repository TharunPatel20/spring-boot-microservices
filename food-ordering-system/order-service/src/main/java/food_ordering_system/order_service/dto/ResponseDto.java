package food_ordering_system.order_service.dto;

import org.springframework.http.HttpStatus;

public record ResponseDto(HttpStatus status, Object obj) {
}
