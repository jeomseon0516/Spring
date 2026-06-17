package org.example.ch05.dto;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@ToString
@NoArgsConstructor
@Builder
public class User4DTO {
    private String userid;
    private String name;
    private String gender;
    private int age;
    private String hp;
    private String addr;
}
