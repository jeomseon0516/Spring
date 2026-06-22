package org.example.ch06.service;

import lombok.RequiredArgsConstructor;
import org.example.ch06.dto.User1DTO;
import org.example.ch06.entity.User1;
import org.example.ch06.repository.User1Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class User1Service {

    // @RequiredArgsConstructor 어노테이션으로 생성자 주입
    private final User1Repository repository;

    public void register(User1DTO dto) {
        // DTO를 Entity 변환
        User1 entity = dto.toEntity();

        // JPA save() 메서드 호출, Entity가 데이터베이스에 INSERT
        repository.save(entity);
    }

    public User1DTO getUser(String userid) {
        return repository.findById(userid)
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

    public void modify(User1DTO dto) {
        if (!repository.existsById(dto.getUserid())) return;/* 엔티티 존재 여부 확인 */

        repository.save(dto.toEntity());
    }

    public void remove(String userid) {
        // JPA 삭제 메서드 호출, DELETE FROM User1 WHERE userid='아이디' 수행
        repository.deleteById(userid);
    }
}
