package org.example.ch08.service;

import lombok.RequiredArgsConstructor;
import org.example.ch08.dto.User5DTO;
import org.example.ch08.entity.User5;
import org.example.ch08.repository.User5Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class User5Service {
    private final User5Repository repository;

    public User5DTO register(User5DTO dto) {
        return repository
            .save(dto.toEntity())
            .toDTO();
    }

    public User5DTO getUser(int seq) {
        return repository
            .findById(seq)
            .map(User5::toDTO)
            .orElse(null);
    }

    public List<User5DTO> getUserAll() {
        return repository
            .findAll()
            .stream()
            .map(User5::toDTO)
            .toList();
    }

    public User5DTO modify(User5DTO dto) {
        return repository.existsById(dto.getSeq())
            ? repository.save(dto.toEntity()).toDTO()
            : null;
    }

    public boolean remove(int seq) {
        if (!repository.existsById(seq)) return false;

        repository.deleteById(seq);

        return true;
    }
}
