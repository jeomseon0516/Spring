package org.example.ch09.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.example.ch09.dto.UserDTO;
import org.example.ch09.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService service;

    @PostMapping
    public ResponseEntity<UserDTO> register(@RequestBody UserDTO dto) {
        log.info(dto);

        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(service.register(dto));
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> list() {
        return ResponseEntity.ok(service.getUserAll());
    }
}
