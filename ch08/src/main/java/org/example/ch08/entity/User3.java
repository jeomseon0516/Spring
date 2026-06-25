package org.example.ch08.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.example.ch08.dto.User3DTO;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class User3 {
    @Id
    private String userid;
    private String name;
    private String birth;
    private String hp;
    private String addr;

    public User3DTO toDTO() {
        return User3DTO.builder()
            .userid(userid)
            .name(name)
            .birth(birth)
            .hp(hp)
            .addr(addr)
            .build();
    }
}
