package toy.toyproject1.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import toy.toyproject1.domain.entity.board.Board;
import toy.toyproject1.domain.entity.board.BoardEditDto;
import toy.toyproject1.domain.entity.member.Member;
import toy.toyproject1.domain.repository.BoardRepository;
import toy.toyproject1.domain.repository.MemberRepository;

import java.util.Optional;

@Transactional
@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;

    public void post(Long memberId, String title, String content) {
        Member findMember = memberRepository.findById(memberId).get();
        boardRepository.save(new Board(findMember, title, content));
    }

    public void edit(Long boardId, BoardEditDto boardEditDto) {
        Board board = boardRepository.findById(boardId).get();
        board.edit(boardEditDto.getTitle(), boardEditDto.getContent());
    }
}
