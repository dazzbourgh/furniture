package zhi.yest.furniture.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import zhi.yest.furniture.dao.Dao;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    Dao dao;

    @PostMapping
    public ResponseEntity<Boolean> addOrder(@RequestParam Long id) {
        return ResponseEntity.ok(true);
    }
}
