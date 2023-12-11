package toy.toyproject1.domain.entity.board;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BoardDisplayDto {

    private String title;
    private String writer;
    private LocalDateTime writtenDate;

    public BoardDisplayDto(String title, String writer, LocalDateTime writtenDate) {
        this.title = title;
        this.writer = writer;
        this.writtenDate = writtenDate;
    }
}
