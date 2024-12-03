package kz.bitlab.g128security.controller;

import kz.bitlab.g128security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

  @Autowired
  private UserService userService;

  @GetMapping("/login")
  public String loginPage() {
    return "login";
  }

  @GetMapping("/register")
  public String registerPage() {
    return "register";
  }

  @PostMapping("/register")
  public String register(
          @RequestParam String username, @RequestParam String password,
          @RequestParam String rePassword, @RequestParam String fullName) {
    userService.createUser(username, password, rePassword, fullName);
    return "redirect:/";
  }
}
