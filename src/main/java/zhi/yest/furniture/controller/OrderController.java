package zhi.yest.furniture.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import zhi.yest.furniture.domain.FurnitureOrder;
import zhi.yest.furniture.service.OrderService;

import javax.transaction.Transactional;

@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/order")
    public ResponseEntity<Boolean> addOrder(@RequestParam Long id) {
        boolean result = null == orderService.createOrder(id);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/pay/{id}")
    @Transactional
    public String pay(@PathVariable Long id) {
        FurnitureOrder order = orderService.get(id);
        order.setPayed(true);
        boolean result = null == orderService.save(order);
        return "redirect:/orders";
    }

    @GetMapping("/orders")
    public String myOrders(Model model) {
        model.addAttribute("orders", orderService.getOrders());
        return "pages/orders";
    }

    @PostMapping("/order/ship")
    public ResponseEntity<Boolean> ship(@RequestBody String body) {
        Long id = Long.parseLong(body.split("=")[1]);
        boolean result = null == orderService.ship(id);
        return ResponseEntity.ok(result);
    }
}
