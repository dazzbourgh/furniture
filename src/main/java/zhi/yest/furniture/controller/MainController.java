package zhi.yest.furniture.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String root() {
        return "forward:/main";
    }

    @GetMapping("/main")
    public String main() {
        return "pages/main";
    }
}
