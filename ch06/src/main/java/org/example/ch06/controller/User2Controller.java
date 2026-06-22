package org.example.ch06.controller;

import lombok.RequiredArgsConstructor;
import org.example.ch06.dto.User2DTO;
import org.example.ch06.service.User2Service;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user2")
public class User2Controller {
    private final User2Service service;

    @GetMapping("/list")
    public String list(Model model) {
        List<User2DTO> dtoList = service.getUserAll();
        model.addAttribute("dtoList", dtoList);
        return "/user2/list";
    }

    @GetMapping("/register")
    public String register() {
        return "/user2/register";
    }

    @PostMapping("/register")
    public String register(User2DTO dto) {
        service.register(dto);

        return "redirect:/user2/list?register=success";
    }

    @GetMapping("/modify")
    public String modify(Model model, String userid) {
        User2DTO dto = service.getUser(userid);
        model.addAttribute("dto", dto);

        return "/user2/modify";
    }

    @PostMapping("/modify")
    public String modify(User2DTO dto) {
        service.modify(dto);

        return "redirect:/user2/list?modify=success";
    }

    @GetMapping("/remove")
    public String remove(String userid) {
        service.remove(userid);
        return "redirect:/user2/list?remove=success";
    }
}
