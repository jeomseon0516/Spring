package org.example.ch06.service;

import lombok.RequiredArgsConstructor;
import org.example.ch06.dto.User3DTO;
import org.example.ch06.entity.User3;
import org.example.ch06.repository.User3Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class User3Service {
    private final User3Repository repository;

    public void register(User3DTO dto) {
        repository.save(dto.toEntity());
    }

    public User3DTO getUser(String userid) {
        return repository
            .findById(userid)
            .map(User3::toDTO)
            .orElse(null);
    }

    public List<User3DTO> getUserAll() {
        return repository
            .findAll()
            .stream()
            .map(User3::toDTO)
            .toList();
    }

    public void modify(User3DTO dto) {
        if (!repository.existsById(dto.getUserid())) return;

        repository.save(dto.toEntity());
    }

    public void remove(String userid) {
        repository.deleteById(userid);
    }
}
