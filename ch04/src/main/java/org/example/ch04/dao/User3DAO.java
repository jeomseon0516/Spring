package org.example.ch04.dao;

import org.apache.ibatis.annotations.Mapper;
import org.example.ch04.dto.User3DTO;
import org.springframework.stereotype.Repository;

import java.util.List;

// @Mapper는 MyBatis API 호출 컴포넌트 선언
@Mapper
@Repository
public interface User3DAO {

    // 기본 CRUD 메서드
    void insert(User3DTO user3DTO);
    User3DTO select(String userid);
    List<User3DTO> selectAll();
    void update(User3DTO user3DTO);
    void delete(String userid);
}
