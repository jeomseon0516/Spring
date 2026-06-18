package org.example.ch04.dao;

import org.apache.ibatis.annotations.Mapper;
import org.example.ch04.dto.User4DTO;
import org.springframework.stereotype.Repository;

import java.util.List;

// @Mapper는 MyBatis API 호출 컴포넌트 선언
@Mapper
@Repository
public interface User4DAO {

    // 기본 CRUD 메서드
    void insert(User4DTO user4DTO);
    User4DTO select(String userid);
    List<User4DTO> selectAll();
    void update(User4DTO user4DTO);
    void delete(String userid);
}
