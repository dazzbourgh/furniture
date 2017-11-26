package zhi.yest.furniture.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import zhi.yest.furniture.dao.OrderDao;
import zhi.yest.furniture.domain.FurnitureOrder;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
public class SalesController {
    @Autowired
    private OrderDao orderDao;

    @GetMapping("/sales")
    @PreAuthorize("hasRole('ROLE_MANAGER')")
    public String sales(Model model) {
        Set<FurnitureOrder> shipped = orderDao.findByShipped(true);
        Set<FurnitureOrder> notShipped = orderDao.findAllNotShipped();
        model.addAttribute("shippedOrders", shipped);
        model.addAttribute("pendingOrders", notShipped);
        model.addAttribute("expectedRevenue", getExpectedRevenue(combineOrders(shipped, notShipped)));
        return "pages/sales";
    }

    private Double getExpectedRevenue(Set<FurnitureOrder> orders) {
        return orders.stream()
                .mapToDouble(order -> order.getProduct().getPrice())
                .sum();
    }

    @SafeVarargs
    private final Set<FurnitureOrder> combineOrders(Set<FurnitureOrder> ...orderSets) {
        return Stream.of(orderSets)
                .flatMap(Set::stream)
                .collect(Collectors.toSet());
    }
}
