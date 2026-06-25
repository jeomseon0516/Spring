package org.example.ch09.jwt;

import io.jsonwebtoken.Claims;
import lombok.extern.log4j.Log4j2;
import org.example.ch09.entity.User;
import org.example.ch09.security.MyUserDetails;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.Authentication;

import static org.junit.jupiter.api.Assertions.*;

@Log4j2
@SpringBootTest
class JwtProviderTest {

    @Autowired
    private JwtProvider provider;

    @Test
    void createToken() {

        User user = User.builder()
            .userid("jeomseon0516")
            .name("남현호")
            .birth("2026-06-10")
            .age(24)
            .role("ADMIN")
            .build();

        String access = provider.createToken(user, 1);
        String refresh = provider.createToken(user, 5);
        log.info(access);
        log.info(refresh);
        /*
            eyJhbGciOiJIUzI1NiJ9.
            eyJpc3MiOiJhc3RhcnRlYW0wNTE2QGdtYWlsLmNvbSIsImlhdCI6MTc4MjM2OTY3NiwiZXhwIjoxNzgyNDU2MDc2LCJ1c2VybmFtZSI6Implb21zZW9uMDUxNiIsInJvbGUiOiJBRE1JTiJ9.
            NAnz6OGptfUGMdfOkxQddr_nYrdQTfTnPyYaI13orf8
        */
    }


    @Test
    void getClaims() {
        String token = """
                eyJhbGciOiJIUzI1NiJ9.
                eyJpc3MiOiJhc3RhcnRlYW0wNTE2QGdtYWlsLmNvbSIsImlhdCI6MTc4MjM2OTY3NiwiZXhwIjoxNzgyNDU2MDc2LCJ1c2VybmFtZSI6Implb21zZW9uMDUxNiIsInJvbGUiOiJBRE1JTiJ9.
                NAnz6OGptfUGMdfOkxQddr_nYrdQTfTnPyYaI13orf8"""
            .replaceAll("\\R", "")
            .trim();

        Claims claims = provider.getClaims(token);

        String username = (String)claims.get("username");
        String role = (String)claims.get("role");

        log.info("username: " + username);
        log.info("role: " + role);
    }

    @Test
    void getAuthentication() {
        String token = """
                eyJhbGciOiJIUzI1NiJ9.
                eyJpc3MiOiJhc3RhcnRlYW0wNTE2QGdtYWlsLmNvbSIsImlhdCI6MTc4MjM2OTY3NiwiZXhwIjoxNzgyNDU2MDc2LCJ1c2VybmFtZSI6Implb21zZW9uMDUxNiIsInJvbGUiOiJBRE1JTiJ9.
                NAnz6OGptfUGMdfOkxQddr_nYrdQTfTnPyYaI13orf8"""
            .replaceAll("\\R", "")
            .trim();

        Authentication authentication = provider.getAuthentication(token);
        User user = (User) authentication.getPrincipal();

        log.info(user);
    }

    @Test
    void validateToken() {
        String token = """
                eyJhbGciOiJIUzI1NiJ9.
                eyJpc3MiOiJhc3RhcnRlYW0wNTE2QGdtYWlsLmNvbSIsImlhdCI6MTc4MjM2OTY3NiwiZXhwIjoxNzgyNDU2MDc2LCJ1c2VybmFtZSI6Implb21zZW9uMDUxNiIsInJvbGUiOiJBRE1JTiJ9.
                NAnz6OGptfUGMdfOkxQddr_nYrdQTfTnPyYaI13orf8"""
            .replaceAll("\\R", "")
            .trim();

        provider.validateToken(token);
    }
}