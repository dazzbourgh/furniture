package zhi.yest.furniture.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @RequestMapping("/welcome")
    String welcome() {
        return "pages/welcome";
    }
    @RequestMapping("/")
    public String root() {
        return "redirect:pages/welcome";
    }
}
