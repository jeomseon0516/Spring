package org.example.ch08.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.example.ch08.dto.User4DTO;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class User4 {
    @Id
    private String userid;
    private String name;
    private String gender;
    private String hp;
    private String addr;
    private int age;

    public User4DTO toDTO() {
        return User4DTO.builder()
            .userid(userid)
            .name(name)
            .gender(gender)
            .hp(hp)
            .addr(addr)
            .age(age)
            .build();
    }
}
