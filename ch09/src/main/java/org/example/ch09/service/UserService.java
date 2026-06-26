package org.example.ch09.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.example.ch09.dto.UserDTO;
import org.example.ch09.entity.User;
import org.example.ch09.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Log4j2
@Service
public class UserService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public UserDTO getUser(String userid) {
        return repository
            .findById(userid)
            .map(User::toDTO)
            .orElse(null);
    }

    public List<UserDTO> getUserAll() {
        return repository
            .findAll()
            .stream()
            .map(User::toDTO)
            .toList();
    }

    public UserDTO register(UserDTO dto) {
        String encoded = passwordEncoder.encode(dto.getPass());
        dto.setPass(encoded);

        return repository
            .save(dto.toEntity())
            .toDTO();
    }

    public UserDTO modify(UserDTO dto) {
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
