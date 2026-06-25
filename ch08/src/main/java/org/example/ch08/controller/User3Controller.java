package org.example.ch08.controller;

import lombok.RequiredArgsConstructor;
import org.example.ch08.dto.User3DTO;
import org.example.ch08.service.User3Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user3")
@RequiredArgsConstructor
public class User3Controller {
    private final User3Service service;

    @PostMapping
    public ResponseEntity<User3DTO> register(@RequestBody User3DTO dto) {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(service.register(dto));
    }

    @GetMapping
    public ResponseEntity<List<User3DTO>> list() {
        return ResponseEntity.ok(service.getUserAll());
    }

    @GetMapping("{userid}")
    public ResponseEntity<User3DTO> findById(@PathVariable String userid) {
        return ResponseEntity.ok(service.getUser(userid));
    }

    @PutMapping
    public ResponseEntity<User3DTO> modify(@RequestBody User3DTO dto) {
        return ResponseEntity.ok(service.modify(dto));
    }

    @DeleteMapping("{userid}")
    public ResponseEntity<Map<String, Boolean>> remove(@PathVariable String userid) {
        return ResponseEntity.ok(Map.of("result", service.remove(userid)));
    }
}
