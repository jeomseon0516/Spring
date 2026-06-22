package org.example.ch06.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.example.ch06.dto.User4DTO;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "User4")
public class User4 {
    @Id
    private String userid;
    private String name;
    private String gender;
    private int age;
    private String hp;
    private String addr;

    public User4DTO toDTO() {
        return User4DTO.builder()
            .userid(userid)
            .name(name)
            .gender(gender)
            .age(age)
            .hp(hp)
            .addr(addr)
            .build();
    }
}
