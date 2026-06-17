package org.example.ch05.dto;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@ToString
@NoArgsConstructor
@Builder
public class User3DTO {
    private String userid;
    private String name;
    private String birth;
    private String hp;
    private String addr;
}
