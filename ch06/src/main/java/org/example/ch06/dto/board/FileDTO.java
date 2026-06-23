package org.example.ch06.dto.board;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class FileDTO {
    private int fno;
    private int ano; // 해당 파일이 첨부도니 글번호
    private String ofname;
    private String sfname;
}
