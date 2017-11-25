package zhi.yest.furniture.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {
    @GetMapping
    public String login(Model model, Boolean error) {
        model.addAttribute("error", error);
        return "login";
    }

    @PostMapping
    public String postLogin() {
        // TODO Enable form login with Spring Security (trigger error for now)
        return "redirect:/main";
    }
}
