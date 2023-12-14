package toy.toyproject1.domain.entity.board;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import toy.toyproject1.domain.entity.AuditingTime;
import toy.toyproject1.domain.entity.member.Member;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board extends AuditingTime {

    @Id @GeneratedValue
    @Column(name = "board_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    private String title;

    @Column(length = 500)
    private String content;

    public Board(Member member, String title, String content) {
        addMember(member);
        this.title = title;
        this.content = content;
    }

    public void addMember(Member member) {
        this.member = member;
        member.getBoards().add(this);
    }

    public void edit(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
