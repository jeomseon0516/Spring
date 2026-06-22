package org.example.ch06.service;

import lombok.RequiredArgsConstructor;
import org.example.ch06.dto.User5DTO;
import org.example.ch06.entity.User5;
import org.example.ch06.repository.User5Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class User5Service {
    private final User5Repository repository;

    public void register(User5DTO dto) {
        repository.save(dto.toEntity());
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

    public void modify(User5DTO dto) {
        if (!repository.existsById(dto.getSeq())) return;

        repository.save(dto.toEntity());
    }

    public void remove(int seq) {
        repository.deleteById(seq);
    }
}
