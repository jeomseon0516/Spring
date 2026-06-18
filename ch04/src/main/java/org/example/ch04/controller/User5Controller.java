package org.example.ch04.controller;

import lombok.RequiredArgsConstructor;
import org.example.ch04.dto.User5DTO;
import org.example.ch04.service.User5Service;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class User5Controller {

    private final User5Service service;

    @GetMapping("/user5/list")
    public String list(Model model) {

        // 조회 서비스 요청
        List<User5DTO> dtoList = service.getAll();

        // 모델 참조: 뷰(html)에서 컨트롤러 데이터 참조
        model.addAttribute("dtoList", dtoList);

        return "/user5/list";
    }

    @GetMapping("/user5/register")
    public String register() {
        return "/user5/register";
    }

    @PostMapping("/user5/register")
    public String register(User5DTO user5DTO) {
        System.out.println(user5DTO);
        service.register(user5DTO);
        return "redirect:/user5/list";
    }

    @GetMapping("/user5/modify")
    public String modify(int seq, Model model) {
        System.out.println("seq:" + seq);
        User5DTO dto = service.getById(seq);
        System.out.println("dto:" + dto);
        model.addAttribute("dto", dto);

        return "/user5/modify";
    }

    @PostMapping("/user5/modify")
    public String modify(User5DTO dto) {
        service.modify(dto);

        return "redirect:/user5/list";
    }

    @GetMapping("/user5/remove")
    public String remove(int seq) {
        service.remove(seq);
        return "redirect:/user5/list";
    }
}
