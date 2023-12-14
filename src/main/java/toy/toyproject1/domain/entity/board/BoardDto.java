package toy.toyproject1.domain.entity.board;

import lombok.Data;

@Data
public class BoardDto {
    private Long boardId;
    private Long memberId;
    private String title;
    private String content;
    private String writer;

    public BoardDto(Long boardId, Long memberId, String title, String content, String writer) {
        this.boardId = boardId;
        this.memberId = memberId;
        this.title = title;
        this.content = content;
        this.writer = writer;
    }
}
