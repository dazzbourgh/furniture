package zhi.yest.furniture.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import zhi.yest.furniture.service.OrderService;

@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/order")
    public ResponseEntity<Boolean> addOrder(@RequestParam Long id) {
        boolean result = null == orderService.createOrder(id);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/orders")
    public String myOrders(Model model) {
        model.addAttribute("orders", orderService.getOrders());
        return "pages/orders";
    }
}
