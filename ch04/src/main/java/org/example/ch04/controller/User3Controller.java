package org.example.ch04.controller;

import lombok.RequiredArgsConstructor;
import org.example.ch04.dto.User3DTO;
import org.example.ch04.service.User3Service;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class User3Controller {

    private final User3Service service;

    @GetMapping("/user3/list")
    public String list(Model model) {

        // 조회 서비스 요청
        List<User3DTO> dtoList = service.getAll();

        // 모델 참조: 뷰(html)에서 컨트롤러 데이터 참조
        model.addAttribute("dtoList", dtoList);

        return "/user3/list";
    }

    @GetMapping("/user3/register")
    public String register() {
        return "/user3/register";
    }

    @PostMapping("/user3/register")
    public String register(User3DTO user3DTO) {
        System.out.println(user3DTO);
        service.register(user3DTO);
        return "redirect:/user3/list";
    }

    @GetMapping("/user3/modify")
    public String modify(String userid, Model model) {
        System.out.println("userid:" + userid);
        User3DTO dto = service.getById(userid);
        System.out.println("dto:" + dto);
        model.addAttribute("dto", dto);

        return "/user3/modify";
    }

    @PostMapping("/user3/modify")
    public String modify(User3DTO dto) {
        service.modify(dto);

        return "redirect:/user3/list";
    }

    @GetMapping("/user3/remove")
    public String remove(String userid) {
        service.remove(userid);
        return "redirect:/user3/list";
    }
}
