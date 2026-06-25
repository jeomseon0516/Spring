package org.example.ch08.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.example.ch08.dto.User1DTO;
import org.example.ch08.entity.User1;
import org.example.ch08.repository.User1Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Log4j2
@Service
public class User1Service {
    private final User1Repository repository;

    public User1DTO getUser(String userid) {
        return repository
            .findById(userid)
            .map(User1::toDTO)
            .orElse(null);
    }

    public List<User1DTO> getUserAll() {
        return repository
            .findAll()
            .stream()
            .map(User1::toDTO)
            .toList();
    }

    public User1DTO register(User1DTO dto) {
        return repository
            .save(dto.toEntity())
            .toDTO();
    }

    public User1DTO modify(User1DTO dto) {
        if(!repository.existsById(dto.getUserid())) return null;

        return repository.save(dto.toEntity()).toDTO();
    }

    @Transactional
    public boolean remove(String userid) {
        if (!repository.existsById(userid)) return false;

        repository.deleteById(userid);

        return true;
    }
}
