package org.example.ch09.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GuestController {

    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER', 'MEMBER', 'GUEST')")
    @GetMapping("/guest/index")
    public String index() {

        return "/guest/index";
    }
}
