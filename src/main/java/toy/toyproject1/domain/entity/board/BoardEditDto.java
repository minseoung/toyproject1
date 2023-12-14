package toy.toyproject1.domain.entity.board;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BoardEditDto {
    private Long id;
    private String title;
    private String content;

    public BoardEditDto(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }
}
