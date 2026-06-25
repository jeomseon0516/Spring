package org.example.ch09.service;

import lombok.RequiredArgsConstructor;
import org.example.ch09.dto.UserDTO;
import org.example.ch09.entity.User;
import org.example.ch09.repository.UserRepository;
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
