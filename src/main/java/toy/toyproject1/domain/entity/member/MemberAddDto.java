package toy.toyproject1.domain.entity.member;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberAddDto {
    @NotBlank(message = "*필수* 이름을 입력하세요!")
    private String username;
    @NotBlank(message = "*필수* 아이디를 입력하세요!")
    private String userid;
    @NotBlank(message = "*필수* 비밀번호를 입력하세요!")
    private String pw;

    public MemberAddDto(String username, String userid, String pw) {
        this.username = username;
        this.userid = userid;
        this.pw = pw;
    }
}
