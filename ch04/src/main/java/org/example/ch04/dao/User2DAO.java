package org.example.ch04.dao;

import org.apache.ibatis.annotations.Mapper;
import org.example.ch04.dto.User2DTO;
import org.springframework.stereotype.Repository;

import java.util.List;

// @Mapper는 MyBatis API 호출 컴포넌트 선언
@Mapper
@Repository
public interface User2DAO {

    // 기본 CRUD 메서드
    void insert(User2DTO user2DTO);
    User2DTO select(String userid);
    List<User2DTO> selectAll();
    void update(User2DTO user2DTO);
    void delete(String userid);
}
