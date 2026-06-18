package org.example.ch04.service;

import lombok.RequiredArgsConstructor;
import org.example.ch04.dao.User5DAO;
import org.example.ch04.dto.User5DTO;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class User5Service {

    // 주입 대상 속성에 final 선언해서 RequiredArgsConstructor으로 객체 주입
    private final User5DAO dao;

    // DAO 호출 메서드
    public void register(User5DTO user5DTO) {
        dao.insert(user5DTO);
    }

    public User5DTO getById(int seq) {
        return dao.select(seq);
    }

    public List<User5DTO> getAll() {
        return dao.selectAll();
    }

    public void modify(User5DTO user5DTO) {
        dao.update(user5DTO);
    }

    public void remove(int seq) {
        dao.delete(seq);
    }
}
