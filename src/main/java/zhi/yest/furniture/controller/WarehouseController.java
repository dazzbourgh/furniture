package zhi.yest.furniture.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import zhi.yest.furniture.dao.OrderDao;

@Controller
public class WarehouseController {
    @Autowired
    private OrderDao orderDao;

    @GetMapping("/warehouse")
    @PreAuthorize("hasRole('ROLE_WORKER')")
    public String warehouse(Model model) {
        model.addAttribute("orders", orderDao.findAllNotShipped());
        return "pages/warehouse";
    }
}
