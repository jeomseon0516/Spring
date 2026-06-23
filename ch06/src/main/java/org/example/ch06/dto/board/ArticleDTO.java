package org.example.ch06.dto.board;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArticleDTO {
    private String ano;
    private String title;
    private String content;
    private int writer;
    private int file;
    private String wdate;
}
