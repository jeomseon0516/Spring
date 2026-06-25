package org.example.ch08.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.example.ch08.dto.User2DTO;
import org.example.ch08.service.User2Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/user2")
public class User2Controller {
    private final User2Service service;

    @GetMapping
    public ResponseEntity<List<User2DTO>> list() {
        return ResponseEntity.ok(service.getUserAll());
    }

    @GetMapping("{userid}")
    public ResponseEntity<User2DTO> findById(@PathVariable String userid) {
        return ResponseEntity.ok(service.getUser(userid));
    }

    @PostMapping
    public ResponseEntity<User2DTO> register(@RequestBody User2DTO dto) {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(service.register(dto));
    }

    @PutMapping
    public ResponseEntity<User2DTO> modify(@RequestBody User2DTO dto) {
        return ResponseEntity.ok(service.modify(dto));
    }

    @DeleteMapping("{userid}")
    public ResponseEntity<Map<String, Boolean>> remove(@PathVariable String userid) {
        return ResponseEntity.ok(Map.of("result", service.remove(userid)));
    }
}
