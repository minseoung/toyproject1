package toy.toyproject1.domain.entity.member;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import toy.toyproject1.domain.entity.board.Board;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(uniqueConstraints = @UniqueConstraint( name = "constraintName", columnNames = {"userid", "username"}))
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @OneToMany(mappedBy = "member")
    private List<Board> boards = new ArrayList<>();

    private String username;
    private String userid;
    private String pw;

    public Member(String username, String userid, String pw) {
        this.username = username;
        this.userid = userid;
        this.pw = pw;
    }
}
