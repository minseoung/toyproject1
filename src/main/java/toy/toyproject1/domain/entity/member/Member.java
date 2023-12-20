package toy.toyproject1.domain.entity.member;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import toy.toyproject1.domain.entity.board.Board;
import toy.toyproject1.domain.entity.messenger.Messenger;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(uniqueConstraints = @UniqueConstraint( name = "constraintName", columnNames = {"userid", "username"}))
@ToString(of = {"id", "username", "userid", "pw"})
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @OneToMany(mappedBy = "member")
    @JsonIgnore
    private List<Board> boards = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "messenger_id")
    private Messenger messenger;

    private String username;
    private String userid;
    private String pw;

    public Member(String username, String userid, String pw) {
        this.username = username;
        this.userid = userid;
        this.pw = pw;
    }

    public Member update(String userid, String pw) {
        this.userid = userid;
        this.pw = pw;
        return this;
    }
}
