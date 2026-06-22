package org.example.ch06.repository;

import lombok.extern.log4j.Log4j2;
import org.example.ch06.dto.User1DTO;
import org.example.ch06.entity.User1;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Log4j2
@SpringBootTest
class User1RepositoryTest {
    @Autowired
    private User1Repository repository;

    @Test
    public void findByUserid() {
        User1 entity = repository.findByUserid("A102");

        log.info(entity);
    }

    @Test
    public void findByName() {
        List<User1> list = repository.findByName("김춘추");

        log.info(list);
    }

    @Test
    public void findByNameNot() {
        List<User1> list = repository.findByNameNot("김춘추");

        log.info(list);
    }

    @Test
    public void findByUseridAndName() {
        User1 list = repository.findByUseridAndName("A102", "김춘추");

        log.info(list);
    }

    @Test
    public void findByUseridOrName() {
        List<User1> list = repository.findByUseridOrName("A102", "김춘추");

        log.info(list);
    }

    @Test
    public void findByHp() {
        List<User1> list = repository.findByHp("010-1234-2224");

        log.info(list);
    }

    @Test
    public void findByAgeGreaterThan() {
        List<User1> list = repository.findByAgeGreaterThan(10);
        log.info(list);
    }

    @Test
    public void findByAgeGreaterThanEqual() {
        List<User1> list = repository.findByAgeGreaterThanEqual(10);
        log.info(list);
    }

    @Test
    public void findByAgeLessThan() {
        List<User1> list = repository.findByAgeLessThan(40);
        log.info(list);
    }

    @Test
    public void findByAgeLessThanEqual() {
        List<User1> list = repository.findByAgeLessThanEqual(40);
        log.info(list);
    }

    @Test
    public void findByAgeBetween() {
        List<User1> list = repository.findByAgeBetween(24, 50);
        log.info(list);
    }

    @Test
    public void findByNameLike() {
        List<User1> list = repository.findByNameLike("남현");
        log.info(list);
    }

    @Test
    public void findByNameContains() {
        List<User1> list = repository.findByNameContains("남현");
        log.info(list);
    }

    @Test
    public void findByNameStartsWith() {
        List<User1> list = repository.findByNameStartsWith("김");
        log.info(list);
    }

    @Test
    public void findByNameEndsWith() {
        List<User1> list = repository.findByNameEndsWith("호");
        log.info(list);
    }

    @Test
    public void findByOrderByName() {
        List<User1> list = repository.findByOrderByName();
        log.info(list);
    }

    @Test
    public void findByOrderByAgeAse() {
        List<User1> list = repository.findByOrderByAgeAsc();
        log.info(list);
    }

    @Test
    public void findByOrderByAgeDesc() {
        List<User1> list = repository.findByOrderByAgeDesc();
        log.info(list);
    }

    @Test
    public void findByAgeGreaterThanOrderByAgeDesc() {
        List<User1> list = repository.findByAgeGreaterThanOrderByAgeDesc(10);
        log.info(list);
    }

    @Test
    public void countByUserid() {
        int count = repository.countByUserid("A102");
        log.info(count);
    }

    @Test
    public void countByName() {
        int count = repository.countByName("김춘추");
        log.info(count);
    }

    @Test
    public void selectUnderAge30() {
        List<User1> list = repository.selectUnderAge30();
        log.info(list);
    }

    @Test
    public void selectByName() {
        List<User1> list = repository.selectByName("김춘추");
        log.info(list);
    }

    @Test
    public void selectByUserid() {
        User1DTO dto = repository.selectByUserid("A102");
        log.info(dto);
    }
}