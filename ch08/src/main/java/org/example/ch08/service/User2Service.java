package org.example.ch08.service;

import lombok.RequiredArgsConstructor;
import org.example.ch08.dto.User2DTO;
import org.example.ch08.entity.User2;
import org.example.ch08.repository.User2Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class User2Service {
    private final User2Repository repository;

    public User2DTO getUser(String userid) {
        return repository
            .findById(userid)
            .map(User2::toDTO)
            .orElse(null);
    }

    public List<User2DTO> getUserAll() {
        return repository
            .findAll()
            .stream()
            .map(User2::toDTO)
            .toList();
    }

    public User2DTO register(User2DTO dto) {
        return repository
            .save(dto.toEntity())
            .toDTO();
    }

    public User2DTO modify(User2DTO dto) {
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
