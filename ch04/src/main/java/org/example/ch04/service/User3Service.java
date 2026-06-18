package org.example.ch04.service;

import lombok.RequiredArgsConstructor;
import org.example.ch04.dao.User3DAO;
import org.example.ch04.dto.User3DTO;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class User3Service {

    // 주입 대상 속성에 final 선언해서 RequiredArgsConstructor으로 객체 주입
    private final User3DAO dao;

    // DAO 호출 메서드
    public void register(User3DTO user3DTO) {
        user3DTO.setBirth(user3DTO.getBirth().replace('-', '.'));
        dao.insert(user3DTO);
    }

    public User3DTO getById(String userid) {
        return dao.select(userid);
    }

    public List<User3DTO> getAll() {
        return dao.selectAll();
    }

    public void modify(User3DTO user3DTO) {
        user3DTO.setBirth(user3DTO.getBirth().replace('-', '.'));
        System.out.println(user3DTO);
        dao.update(user3DTO);
    }

    public void remove(String userid) {
        dao.delete(userid);
    }
}
