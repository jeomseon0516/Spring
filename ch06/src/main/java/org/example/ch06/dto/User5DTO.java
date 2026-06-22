package org.example.ch06.dto;

import lombok.*;
import org.example.ch06.entity.User5;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User5DTO {
    private int seq;
    private String name;
    private String gender;
    private int age;
    private String addr;

    public User5 toEntity() {
        return User5.builder()
            .seq(seq)
            .name(name)
            .gender(gender)
            .age(age)
            .addr(addr)
            .build();
    }
}
