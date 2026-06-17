package org.example.ch05.dto;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@ToString
@NoArgsConstructor
@Builder
public class User5DTO {
    private int seq;
    private String name;
    private String gender;
    private int age;
    private String addr;
}
