package org.example.ch08.dto;

import lombok.*;
import org.example.ch08.entity.User1;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User1DTO {
    private String userid;
    private String name;
    private String hp;
    private int age;

    public User1 toEntity() {
        return User1.builder()
            .userid(userid)
            .name(name)
            .hp(hp)
            .age(age)
            .build();
    }
}
