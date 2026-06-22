package org.example.ch06.service;

import lombok.RequiredArgsConstructor;
import org.example.ch06.dto.User2DTO;
import org.example.ch06.entity.User2;
import org.example.ch06.repository.User2Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class User2Service {
    private final User2Repository repository;

    public void register(User2DTO dto){
        repository.save(dto.toEntity());
    }

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

    public void modify(User2DTO dto) {
        if (!repository.existsById(dto.getUserid())) return;

        repository.save(dto.toEntity());
    }

    public void remove(String userid) {
        repository.deleteById(userid);
    }
}
