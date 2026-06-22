package org.example.ch06.service;

import lombok.RequiredArgsConstructor;
import org.example.ch06.dto.User4DTO;
import org.example.ch06.entity.User4;
import org.example.ch06.repository.User4Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class User4Service {
    private final User4Repository repository;

    public void register(User4DTO dto) {
        repository.save(dto.toEntity());
    }

    public User4DTO getUser(String userid) {
        return repository
            .findById(userid)
            .map(User4::toDTO)
            .orElse(null);
    }

    public List<User4DTO> getUserAll() {
        return repository
            .findAll()
            .stream()
            .map(User4::toDTO)
            .toList();
    }

    public void modify(User4DTO dto) {
        if (!repository.existsById(dto.getUserid())) return;

        repository.save(dto.toEntity());
    }

    public void remove(String userid) {
        repository.deleteById(userid);
    }
}
