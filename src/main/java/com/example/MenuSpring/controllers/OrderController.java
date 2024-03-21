package com.example.MenuSpring.controllers;

import com.example.MenuSpring.entities.Menu;
import com.example.MenuSpring.entities.Order;
import com.example.MenuSpring.repositories.MenuRepository;
import com.example.MenuSpring.repositories.OrderRepository;
import com.example.MenuSpring.services.MenuService;
import com.example.MenuSpring.services.OrderService;
import org.aspectj.weaver.ast.Or;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.*;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    private final Logger log= LoggerFactory.getLogger(OrderController.class);
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private MenuRepository menuRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    @GetMapping("/all")
    public List<Order> findAllOrders(){
        OrderService os= new OrderService();
        return os.findAll(orderRepository);
    }
    @PostMapping
    public ResponseEntity<Order> addOrder(@RequestBody ArrayList<Long> order){
        MenuService ms= new MenuService();
        OrderService os= new OrderService();
        List<Menu> menus= ms.findToday(menuRepository);
        ArrayList<Menu> validMenus= new ArrayList<>();
        for(Menu m: menus){
            for(Long id: order){
                if(Objects.equals(m.getId(), id)){
                    validMenus.add(m);
                    return os.add(orderRepository, new Order(null, validMenus));
                }else {
                    log.warn("Trying to add a dish which is not in today's menu");
                    log.info("Today's menu is:");
                    for(Menu menu: menus){
                        log.info(menu.getId()+"->"+menu.getName());
                    }
                    return ResponseEntity.notFound().build();
                }
            }
        }
       return null;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Order> findById(@PathVariable Long id){
        OrderService os= new OrderService();
        List<Order> order= os.findById(orderRepository,id);
        if(!order.isEmpty()){
            return ResponseEntity.ok(order.get(0));
        }else {
            return ResponseEntity.notFound().build();
        }
    }
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND
        ).body("Trying to add a non existent dish");
    }

}
