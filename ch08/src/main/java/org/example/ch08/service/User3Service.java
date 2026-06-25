package org.example.ch08.service;

import lombok.RequiredArgsConstructor;
import org.example.ch08.dto.User3DTO;
import org.example.ch08.entity.User3;
import org.example.ch08.repository.User3Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class User3Service {
    private final User3Repository repository;

    public User3DTO register(User3DTO dto) {
        return repository
            .save(dto.toEntity())
            .toDTO();
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

    public User3DTO modify(User3DTO dto) {
        return repository.existsById(dto.getUserid())
            ? repository.save(dto.toEntity()).toDTO()
            : null;
    }

    public boolean remove(String userid) {
        if (!repository.existsById(userid)) return false;

        repository.deleteById(userid);

        return true;
    }
}
