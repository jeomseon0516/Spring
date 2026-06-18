package org.example.ch04.dto;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@ToString
@NoArgsConstructor
@Builder
public class User2DTO {
    private String userid;
    private String name;
    private String birth;
    private String addr;
}
