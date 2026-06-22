package org.example.ch06.dto;

import lombok.*;
import org.example.ch06.entity.User2;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Getter
@Setter
public class User2DTO {
    private String userid;
    private String name;
    private String birth;
    private String addr;

    public User2 toEntity() {
        return User2.builder()
            .userid(userid)
            .name(name)
            .birth(birth)
            .addr(addr)
            .build();
    }
}
