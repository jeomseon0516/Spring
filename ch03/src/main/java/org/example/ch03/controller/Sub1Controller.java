package org.example.ch03.controller;

// 사용자 요청을 처리하는 컨트롤러 생성

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Sub1Controller {

    @GetMapping("/sub1/hello")
    public String hello() {

        // 반환되는 문자열 뒤에 확장자 .html 붙고 해당 문자열로 디스패쳐에서 forward 됨
        return "/sub1/hello";
    }

    @GetMapping(value = {"/sub1/welcome"})
    public String welcome() {

        return "/sub1/welcome";
    }

    @GetMapping("/sub1/greeting")
    public String greeting() {

        return "/sub1/greeting";
    }
}
