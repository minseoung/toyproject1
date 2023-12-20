package toy.toyproject1;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import toy.toyproject1.domain.entity.board.Board;
import toy.toyproject1.domain.entity.member.Member;
import toy.toyproject1.domain.repository.BoardRepository;
import toy.toyproject1.domain.repository.MemberRepository;

@Component
@RequiredArgsConstructor
public class InitDB {

    private final MemberRepository memberRepository;
    private final BoardRepository boardRepository;

    @PostConstruct
    public void init() {
        for (int i = 1; i <= 10; i++) {
            Member member = new Member("user" + i, "user" + i, "1234");
            memberRepository.save(member);
            for (int j = 1; j <= 10; j++) {
                Board board = new Board(member, "member" + i + "의 게시물" + j, member + "의 내용" + j);
                boardRepository.save(board);
            }
        }
    }
}
