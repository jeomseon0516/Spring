package org.example.ch06.controller;

import lombok.RequiredArgsConstructor;
import org.example.ch06.dto.User3DTO;
import org.example.ch06.service.User3Service;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user3")
public class User3Controller {
    private final User3Service service;

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("dtoList", service.getUserAll());

        return "/user3/list";
    }

    @GetMapping("/register")
    public String register() {
        return "/user3/register";
    }

    @PostMapping("/register")
    public String register(User3DTO dto) {
        service.register(dto);

        return "redirect:/user3/list?register=success";
    }

    @GetMapping("/modify")
    public String modify(Model model, String userid) {
        model.addAttribute("dto", service.getUser(userid));

        return "/user3/modify";
    }

    @PostMapping("/modify")
    public String modify(User3DTO dto) {
        service.modify(dto);

        return "redirect:/user3/list?modify=success";
    }

    @GetMapping("/remove")
    public String remove(String userid) {
        service.remove(userid);
        return "redirect:/user3/list?remove=success";
    }
}
