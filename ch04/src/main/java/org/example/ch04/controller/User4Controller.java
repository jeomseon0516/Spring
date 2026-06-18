package org.example.ch04.controller;

import lombok.RequiredArgsConstructor;
import org.example.ch04.dto.User4DTO;
import org.example.ch04.service.User4Service;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class User4Controller {

    private final User4Service service;

    @GetMapping("/user4/list")
    public String list(Model model) {

        // 조회 서비스 요청
        List<User4DTO> dtoList = service.getAll();

        // 모델 참조: 뷰(html)에서 컨트롤러 데이터 참조
        model.addAttribute("dtoList", dtoList);

        return "/user4/list";
    }

    @GetMapping("/user4/register")
    public String register() {
        return "/user4/register";
    }

    @PostMapping("/user4/register")
    public String register(User4DTO user4DTO) {
        System.out.println(user4DTO);
        service.register(user4DTO);
        return "redirect:/user4/list";
    }

    @GetMapping("/user4/modify")
    public String modify(String userid, Model model) {
        System.out.println("userid:" + userid);
        User4DTO dto = service.getById(userid);
        System.out.println("dto:" + dto);
        model.addAttribute("dto", dto);

        return "/user4/modify";
    }

    @PostMapping("/user4/modify")
    public String modify(User4DTO dto) {
        service.modify(dto);

        return "redirect:/user4/list";
    }

    @GetMapping("/user4/remove")
    public String remove(String userid) {
        service.remove(userid);
        return "redirect:/user4/list";
    }
}
