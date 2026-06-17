package org.example.ch05.controller;

import lombok.RequiredArgsConstructor;
import org.example.ch05.dto.User1DTO;
import org.example.ch05.service.User1Service;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class User1Controller {

    private final User1Service service;

    @GetMapping("/user1/list")
    public String list(Model model) {

        // 조회 서비스 요청
        List<User1DTO> dtoList = service.getAll();

        // 모델 참조: 뷰(html)에서 컨트롤러 데이터 참조
        model.addAttribute("dtoList", dtoList);

        return "/user1/list";
    }

    @GetMapping("/user1/register")
    public String register() {
        return "/user1/register";
    }

    @PostMapping("/user1/register")
    public String register(User1DTO user1DTO) {
        System.out.println(user1DTO);
        service.register(user1DTO);
        return "redirect:/user1/list";
    }

    @GetMapping("/user1/modify")
    public String modify(String userid, Model model) {
        System.out.println("userid:" + userid);
        User1DTO dto = service.getById(userid);
        System.out.println("dto:" + dto);
        model.addAttribute("dto", dto);

        return "/user1/modify";
    }

    @PostMapping("/user1/modify")
    public String modify(User1DTO dto) {
        service.modify(dto);

        return "redirect:/user1/list";
    }

    @GetMapping("/user1/remove")
    public String remove(String userid) {
        service.remove(userid);
        return "redirect:/user1/list";
    }
}
