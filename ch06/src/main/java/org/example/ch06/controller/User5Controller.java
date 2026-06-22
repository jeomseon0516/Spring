package org.example.ch06.controller;

import lombok.RequiredArgsConstructor;
import org.example.ch06.dto.User5DTO;
import org.example.ch06.service.User5Service;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user5")
public class User5Controller {
    private final User5Service service;

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("dtoList", service.getUserAll());
        return "user5/list";
    }

    @GetMapping("/register")
    public String register() {
        return "/user5/register";
    }

    @PostMapping("/register")
    public String register(User5DTO dto)  {
        service.register(dto);
        return "redirect:/user5/list?register=success";
    }

    @GetMapping("/modify")
    public String modify(Model model, int seq) {
        model.addAttribute("dto", service.getUser(seq));
        return "/user5/modify";
    }

    @PostMapping("/modify")
    public String modify(User5DTO dto) {
        service.modify(dto);
        return "redirect:/user5/list?modify=success";
    }

    @GetMapping("/remove")
    public String remove(int seq) {
        service.remove(seq);
        return "redirect:/user5/list?remove=success";
    }
}
