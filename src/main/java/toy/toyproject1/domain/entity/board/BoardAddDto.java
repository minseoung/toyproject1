package toy.toyproject1.domain.entity.board;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import toy.toyproject1.domain.entity.member.Member;

@Data
public class BoardAddDto {
    @NotBlank
    private String title;
    @NotBlank
    private String content;
}
