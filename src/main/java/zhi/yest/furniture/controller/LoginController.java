package zhi.yest.furniture.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller("login")
public class LoginController {
    @GetMapping
    public String login() {
        return "login";
    }

    @PostMapping
    public String postLogin() {
        // TODO Enable form login with Spring Security (trigger error for now)
        return "pages/welcome";
    }

    @GetMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }
}
