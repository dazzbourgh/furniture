package zhi.yest.furniture.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import zhi.yest.furniture.service.OrderService;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping
    public ResponseEntity<Boolean> addOrder(@RequestParam Long id) {
        boolean result = null == orderService.createOrder(id);
        return ResponseEntity.ok(result);
    }
}
