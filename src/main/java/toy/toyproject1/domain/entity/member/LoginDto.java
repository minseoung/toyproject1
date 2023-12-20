package toy.toyproject1.domain.entity.member;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoginDto {
    @NotBlank(message = "아이디를 입력하세요.")
    private String userid;
    @NotBlank(message = "비밀번호를 입력하세요.")
    private String pw;
}
