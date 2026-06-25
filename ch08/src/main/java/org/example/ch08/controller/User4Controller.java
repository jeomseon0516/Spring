package org.example.ch08.controller;

import lombok.RequiredArgsConstructor;
import org.example.ch08.dto.User4DTO;
import org.example.ch08.service.User4Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user4")
@RequiredArgsConstructor
public class User4Controller {
    private final User4Service service;

    @PostMapping
    public ResponseEntity<User4DTO> register(@RequestBody User4DTO dto) {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(service.register(dto));
    }

    @GetMapping
    public ResponseEntity<List<User4DTO>> list() {
        return ResponseEntity.ok(service.getUserAll());
    }

    @GetMapping("{userid}")
    public ResponseEntity<User4DTO> findById(@PathVariable String userid) {
        return ResponseEntity.ok(service.getUser(userid));
    }

    @PutMapping
    public ResponseEntity<User4DTO> modify(@RequestBody User4DTO dto) {
        return ResponseEntity.ok(service.modify(dto));
    }

    @DeleteMapping("{userid}")
    public ResponseEntity<Map<String, Boolean>> remove(@PathVariable String userid) {
        return ResponseEntity.ok(Map.of("result", service.remove(userid)));
    }
}
