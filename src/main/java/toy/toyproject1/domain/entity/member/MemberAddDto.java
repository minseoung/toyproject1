package toy.toyproject1.domain.entity.member;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberAddDto {
    @NotBlank
    private String username;
    @NotBlank
    private String userid;
    @NotBlank
    private String pw;

    public MemberAddDto(String username, String userid, String pw) {
        this.username = username;
        this.userid = userid;
        this.pw = pw;
    }
}
