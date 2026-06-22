package org.example.ch06.controller;

import lombok.RequiredArgsConstructor;
import org.example.ch06.dto.User4DTO;
import org.example.ch06.service.User4Service;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user4")
public class User4Controller {
    private final User4Service service;

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("dtoList", service.getUserAll());
        return "/user4/list";
    }

    @GetMapping("/register")
    public String register() {
        return "/user4/register";
    }

    @PostMapping("/register")
    public String register(User4DTO dto) {
        service.register(dto);

        return "redirect:/user4/list?register=success";
    }

    @GetMapping("/modify")
    public String modify(Model model, String userid) {
        model.addAttribute("dto", service.getUser(userid));

        return "/user4/modify";
    }

    @PostMapping("/modify")
    public String modify(User4DTO dto) {
        service.modify(dto);
        return "redirect:/user4/list?modify=success";
    }

    @GetMapping("/remove")
    public String remove(String userid) {
        service.remove(userid);
        return "redirect:/user4/list?remove=success";
    }
}
