package food_ordering_system.order_service.controller;

import food_ordering_system.order_service.dto.OrderDto;
import food_ordering_system.order_service.dto.OrderResponse;
import food_ordering_system.order_service.dto.ResponseDto;
import food_ordering_system.order_service.entity.Order;
import food_ordering_system.order_service.feign.RestaurantClient;
import food_ordering_system.order_service.service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    OrderServiceImpl service;

    @PostMapping
    public Order orderFood(@RequestBody OrderDto dto){
        return service.orderFood(dto);
    }

    @DeleteMapping("{id}")
    public  ResponseEntity<ResponseDto> deleteOrder(@PathVariable Long id){
        return ResponseEntity.ok().body(new ResponseDto(HttpStatus.ACCEPTED, service.cancelOrder(id)));
    }

    @GetMapping("{id}")
    public ResponseEntity<ResponseDto> getOrderDetails(@PathVariable Long id){
        return ResponseEntity.ok().body(new ResponseDto(HttpStatus.OK,service.getOrderDetails(id)));
    }

    @GetMapping
    public ResponseEntity<ResponseDto> getAllOrderDetails(){
        return ResponseEntity.ok().body(new ResponseDto(HttpStatus.OK,service.getAllOrderDetails()));
    }


    // Restaurant endpoint to get menu

    @Autowired
    RestaurantClient client;
    @GetMapping("/restaurants/{resId}")
    public ResponseEntity<ResponseDto> getRestaurantMenu(@PathVariable Long resId){
        return ResponseEntity.ok().body(new ResponseDto(HttpStatus.OK,client.getRestaurantById(resId)));
    }

//    /orders/restaurants
    @GetMapping("/restaurants")
    public ResponseEntity<ResponseDto> getRestaurantMenu(){
        return ResponseEntity.ok().body(new ResponseDto(HttpStatus.OK,client.getAllRestaurants()));
    }


}
