package org.example.ch05.service;

import lombok.RequiredArgsConstructor;
import org.example.ch05.dao.User2DAO;
import org.example.ch05.dto.User2DTO;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class User2Service {

    // 주입 대상 속성에 final 선언해서 RequiredArgsConstructor으로 객체 주입
    private final User2DAO dao;

    // DAO 호출 메서드
    public void register(User2DTO user2DTO) {
        user2DTO.setBirth(user2DTO.getBirth().replace('-', '.'));
        dao.insert(user2DTO);
    }

    public User2DTO getById(String userid) {
        return dao.select(userid);
    }

    public List<User2DTO> getAll() {
        return dao.selectAll();
    }

    public void modify(User2DTO user2DTO) {
        user2DTO.setBirth(user2DTO.getBirth().replace('-', '.'));
        System.out.println(user2DTO);
        dao.update(user2DTO);
    }

    public void remove(String userid) {
        dao.delete(userid);
    }
}
