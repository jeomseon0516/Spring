package org.example.ch07.service;

import lombok.RequiredArgsConstructor;
import org.example.ch07.dto.UserDTO;
import org.example.ch07.entity.User;
import org.example.ch07.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserDTO register(UserDTO dto) {
        User savedUser = userRepository.save(dto.toEntity());
        return savedUser.toDTO();
    }
}
