package org.example.ch03.controller;

import org.example.ch03.dto.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Sub2Controller {

    @GetMapping("/sub2/register")
    public String register() {
        return "/sub2/register";
    }

    @PostMapping("/sub2/register")
    public String register(UserDTO userDTO) {
        System.out.println(userDTO);

        return "redirect:/index";
    }

    @GetMapping("/sub2/param")
    public String param(@RequestParam("name") String name, // @RequestParam(파라미터명) 으로 파라미터 수신 가능
                                                int age) { // 일반적으로 생략 가능
        System.out.println("name : " + name);
        System.out.println("age : " + age);

        // 리다이렉트
        return "redirect:/index";
    }
}
