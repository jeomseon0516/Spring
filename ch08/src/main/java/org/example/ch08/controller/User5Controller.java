package org.example.ch08.controller;

import lombok.RequiredArgsConstructor;
import org.example.ch08.dto.User5DTO;
import org.example.ch08.service.User5Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user5")
@RequiredArgsConstructor
public class User5Controller {
    private final User5Service service;

    @PostMapping
    public ResponseEntity<User5DTO> register(@RequestBody User5DTO dto) {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(service.register(dto));
    }

    @GetMapping
    public ResponseEntity<List<User5DTO>> list() {
        return ResponseEntity.ok(service.getUserAll());
    }

    @GetMapping("{seq}")
    public ResponseEntity<User5DTO> findById(@PathVariable int seq) {
        return ResponseEntity.ok(service.getUser(seq));
    }

    @PutMapping
    public ResponseEntity<User5DTO> modify(@RequestBody User5DTO dto) {
        return ResponseEntity.ok(service.modify(dto));
    }

    @DeleteMapping("{seq}")
    public ResponseEntity<Map<String, Boolean>> remove(@PathVariable int seq) {
        return ResponseEntity.ok(Map.of("result", service.remove(seq)));
    }
}
