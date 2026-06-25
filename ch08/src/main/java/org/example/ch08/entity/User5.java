package org.example.ch08.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.example.ch08.dto.User5DTO;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class User5 {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int seq;
    private String name;
    private String gender;
    private String addr;
    private int age;

    public User5DTO toDTO() {
        return User5DTO.builder()
            .seq(seq)
            .name(name)
            .gender(gender)
            .addr(addr)
            .age(age)
            .build();
    }
}
