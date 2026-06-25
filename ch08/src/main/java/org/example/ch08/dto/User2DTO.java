package org.example.ch08.dto;

import lombok.*;
import org.example.ch08.entity.User2;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User2DTO {
    private String userid;
    private String name;
    private String birth;
    private String hp;
    private String addr;
    private int age;

    public User2 toEntity() {
        return User2.builder()
            .userid(userid)
            .name(name)
            .birth(birth)
            .hp(hp)
            .addr(addr)
            .age(age)
            .build();
    }
}
