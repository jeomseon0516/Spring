package org.example.ch07.controller;

import lombok.RequiredArgsConstructor;
import org.example.ch07.dto.UserDTO;
import org.example.ch07.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/user/login")
    public String login() {
        return "/user/login";
    }

    @GetMapping("/user/register")
    public String register() {
        return "/user/register";
    }

    @PostMapping("/user/register")
    public String register(UserDTO dto) {
        System.out.println(dto);
        String encoded = passwordEncoder.encode(dto.getPass());
        dto.setPass(encoded);
        UserDTO savedUser = userService.register(dto);

        return "redirect:/user/login?register=success";
    }
}
