package org.example.ch08.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.example.ch08.dto.User1DTO;
import org.example.ch08.service.User1Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Log4j2
@RequiredArgsConstructor
@RestController
@RequestMapping("/user1")
public class User1Controller {

    private final User1Service service;

    /*
        @RestController
         - 요청 메서드를 API로 처리를 위한 Controller 어노테이션
         - 요청 메서드에 @ResponseBody를 생략

        @ResponseBody
         - 메서드 반환값을 응답객체 body 출력
         - 반환값을 JSON 데이터로 출력

        @RequestBody
         - 요청 객체 본문에 포함된 데이터를 JAVA 객체로 변환
         - 사용자가 전송하는 JSON 데이터를 수신처리

        @PathVariable
         - API(URI주소)에 포함된 데이터를 수신처리

        ResponseEntity
         - API를 요청한 사용자에게 응답 데이터를 구성해서 부가적인 정보를 제공하는 클래스
         - 사용자 정의 응답객체를 생성하기 때문에 프런트 개발 활용도 향상
    */
    //@ResponseBody
    @PostMapping
    public ResponseEntity<User1DTO> register(@RequestBody User1DTO dto) {
        log.info(dto);

        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(service.register(dto));
    }

    //@ResponseBody
    @GetMapping
    public ResponseEntity<List<User1DTO>> list() {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(service.getUserAll());
    }

    @GetMapping("{userid}")
    public ResponseEntity<User1DTO> findById(@PathVariable String userid) {
        User1DTO dto = service.getUser(userid);

        return dto != null
            ? ResponseEntity.ok(service.getUser(userid))
            : ResponseEntity.notFound().build();
    }

    //@ResponseBody
    @PutMapping
    public ResponseEntity<User1DTO> modify(@RequestBody User1DTO dto) {
        log.info(dto);

        return ResponseEntity.ok(service.modify(dto));
    }

    //@ResponseBody
    @DeleteMapping("{userid}")
    public ResponseEntity<Map<String, Boolean>> remove(@PathVariable String userid) {
        boolean result = service.remove(userid);
        return ResponseEntity.ok(Map.of("result", result));
    }
}
