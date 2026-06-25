package org.example.ch08.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.example.ch08.dto.User2DTO;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
public class User2 {
    @Id
    private String userid;
    private String name;
    private String birth;
    private String hp;
    private String addr;
    private int age;

    public User2DTO toDTO() {
        return User2DTO.builder()
            .userid(userid)
            .name(name)
            .birth(birth)
            .hp(hp)
            .addr(addr)
            .age(age)
            .build();
    }
}
