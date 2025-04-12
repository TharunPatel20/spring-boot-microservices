package food_ordering_system.restaurant_service.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage())
        );
        return ResponseEntity.badRequest().body(errors);
    }


    @ExceptionHandler(Exception.class)
    public String handleGeneralException(Exception ex) {
        return "exception occurred..!, trying to figure out what went wrong \n" + ex.getMessage();
    }

    @ExceptionHandler(RestaurantNotFoundException.class)
    public String handleRestaurantNotFound(RestaurantNotFoundException ex) {
        return ex.getMessage(); // or return a proper error response DTO
    }
    @ExceptionHandler(FoodNotFoundException.class)
    public String handleFoodNotFound(FoodNotFoundException ex) {
        return ex.getMessage(); // or return a proper error response DTO
    }

}
