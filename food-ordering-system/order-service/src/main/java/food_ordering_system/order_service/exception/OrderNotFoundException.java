package food_ordering_system.order_service.exception;

public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(String message){super(message);}
}
