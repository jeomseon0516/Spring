package org.example.ch08.dto;

import lombok.*;
import org.example.ch08.entity.User3;
import org.example.ch08.entity.User4;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User4DTO {
    private String userid;
    private String name;
    private String gender;
    private String hp;
    private String addr;
    private int age;

    public User4 toEntity() {
        return User4.builder()
            .userid(userid)
            .name(name)
            .gender(gender)
            .hp(hp)
            .addr(addr)
            .age(age)
            .build();
    }
}
