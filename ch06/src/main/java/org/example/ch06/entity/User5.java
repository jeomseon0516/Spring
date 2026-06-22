package org.example.ch06.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.example.ch06.dto.User5DTO;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "User5")
public class User5 {
    @Id
    private int seq;
    private String name;
    private String gender;
    private int age;
    private String addr;

    public User5DTO toDTO() {
        return User5DTO.builder()
            .seq(seq)
            .name(name)
            .gender(gender)
            .age(age)
            .addr(addr)
            .build();
    }
}
