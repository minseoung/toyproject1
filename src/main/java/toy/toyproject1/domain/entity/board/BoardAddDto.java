package toy.toyproject1.domain.entity.board;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import toy.toyproject1.domain.entity.member.Member;

@Data
public class BoardAddDto {
    @NotBlank(message = "*필수* 제목을 입력하세요!")
    private String title;
    @NotBlank(message = "*필수* 게시글 내용을 입력하세요!")
    private String content;
}
