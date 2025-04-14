package food_ordering_system.order_service.exception;

public class RestaurantNotFoundException extends  RuntimeException {
    public RestaurantNotFoundException(String message){super(message);}
}