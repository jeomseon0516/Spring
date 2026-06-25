package org.example.ch09.dto;

import lombok.*;
import org.example.ch09.entity.User;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private String userid;
    private String pass;
    private String name;
    private String birth;
    private int age;
    private String role;
    private String rdate;

    // Entity 변환 메서드
    public User toEntity() {
        return User.builder()
            .userid(userid)
            .pass(pass)
            .name(name)
            .birth(birth)
            .age(age)
            .role(role)
            .build();
    }
}
