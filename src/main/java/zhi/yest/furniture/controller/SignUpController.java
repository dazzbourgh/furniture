package zhi.yest.furniture.controller;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import zhi.yest.furniture.dao.UserDao;
import zhi.yest.furniture.domain.User;

import javax.transaction.Transactional;

@Controller
public class SignUpController {
    @Autowired
    private UserDao userDao;

    @GetMapping("/signup")
    public String getSignUpPage(Model model) {
        model.addAttribute("credentials", new Credentials());
        return "signup";
    }

    @PostMapping("/signup")
    @Transactional
    public String signUp(@ModelAttribute Credentials credentials) {
        User user = new User();
        user.setUsername(credentials.getUsername());
        user.setPassword(credentials.getPassword());
        user.setRole(User.Role.USER);
        userDao.save(user);
        return "redirect:/login";
    }

    @Data
    private static class Credentials {
        private String username;
        private String password;
    }
}
