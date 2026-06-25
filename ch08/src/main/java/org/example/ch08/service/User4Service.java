package org.example.ch08.service;

import lombok.RequiredArgsConstructor;
import org.example.ch08.dto.User4DTO;
import org.example.ch08.entity.User4;
import org.example.ch08.repository.User4Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class User4Service {
    private final User4Repository repository;

    public User4DTO register(User4DTO dto) {
        return repository
            .save(dto.toEntity())
            .toDTO();
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

    public User4DTO modify(User4DTO dto) {
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
