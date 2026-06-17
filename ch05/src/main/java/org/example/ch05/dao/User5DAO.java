package org.example.ch05.dao;

import org.apache.ibatis.annotations.Mapper;
import org.example.ch05.dto.User5DTO;
import org.springframework.stereotype.Repository;

import java.util.List;

// @Mapper는 MyBatis API 호출 컴포넌트 선언
@Mapper
@Repository
public interface User5DAO {

    // 기본 CRUD 메서드
    void insert(User5DTO user5DTO);
    User5DTO select(int seq);
    List<User5DTO> selectAll();
    void update(User5DTO user5DTO);
    void delete(int seq);
}
