package food_ordering_system.order_service.service;

import food_ordering_system.order_service.dto.OrderDto;
import food_ordering_system.order_service.dto.OrderResponse;
import food_ordering_system.order_service.entity.Order;

public interface OrderService {
    public Order orderFood(OrderDto order);
    public OrderResponse getOrderDetails(Long id);
    public Object cancelOrder(Long id);

}
