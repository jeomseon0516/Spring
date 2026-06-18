package org.example.ch04.dao;

import org.apache.ibatis.annotations.Mapper;
import org.example.ch04.dto.User1DTO;
import org.springframework.stereotype.Repository;

import java.util.List;

// @Mapper는 MyBatis API 호출 컴포넌트 선언
@Mapper
@Repository
public interface User1DAO {

    // 기본 CRUD 메서드
    void insert(User1DTO user1DTO);
    User1DTO select(String userid);
    List<User1DTO> selectAll();
    void update(User1DTO user1DTO);
    void delete(String userid);
}
