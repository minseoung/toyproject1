package toy.toyproject1.domain.entity.board;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BoardDisplayDto {

    private Long boardId;
    private Long memberId;
    private String title;
    private String writer;
    private LocalDateTime writtenDate;

    public BoardDisplayDto(Long boardId, Long memberId, String title, String writer, LocalDateTime writtenDate) {
        this.boardId = boardId;
        this.memberId = memberId;
        this.title = title;
        this.writer = writer;
        this.writtenDate = writtenDate;
    }
}
