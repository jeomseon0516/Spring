package org.example.ch08.dto;

import lombok.*;
import org.example.ch08.entity.User5;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User5DTO {
    private int seq;
    private String name;
    private String gender;
    private String addr;
    private int age;

    public User5 toEntity() {
        return User5.builder()
            .seq(seq)
            .name(name)
            .gender(gender)
            .addr(addr)
            .age(age)
            .build();
    }
}
