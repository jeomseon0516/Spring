package org.example.ch04.dto;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@ToString
@NoArgsConstructor
@Builder
public class User1DTO {
    private String userid;
    private String name;
    private String hp;
    private int age;
}
