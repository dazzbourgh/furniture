package zhi.yest.furniture.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import zhi.yest.furniture.dao.Dao;
import zhi.yest.furniture.domain.furniture.FurniturePiece;

import java.util.List;

@Controller
@RequestMapping("/catalog")
public class CatalogController {
    @Autowired
    private Dao dao;

    @GetMapping
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_MANAGER') or hasRole('ROLE_WORKER')")
    public String catalog(Model model) {
        List<FurniturePiece> prods = dao.getAll();
        model.addAttribute("prods", prods);
        return "pages/catalog";
    }
}
