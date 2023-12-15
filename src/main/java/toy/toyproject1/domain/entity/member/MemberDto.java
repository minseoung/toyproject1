package toy.toyproject1.domain.entity.member;

import lombok.Data;

@Data
public class MemberDto {
    private Long memberId;
    private String username;
    private Long boardId;
    private String title;

    public MemberDto(Long memberId, String username, Long boardId, String title) {
        this.memberId = memberId;
        this.username = username;
        this.boardId = boardId;
        this.title = title;
    }
}
