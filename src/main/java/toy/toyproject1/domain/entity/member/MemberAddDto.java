package toy.toyproject1.domain.entity.member;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberAddDto {
    private String username;

    private String userid;
    private String pw;

    public MemberAddDto(String username, String userid, String pw) {
        this.username = username;
        this.userid = userid;
        this.pw = pw;
    }
}
