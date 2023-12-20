package toy.toyproject1.domain.repository;

import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import toy.toyproject1.domain.entity.board.*;
import toy.toyproject1.domain.entity.member.Member;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
@Transactional
class BoardRepositoryTest {

    @Autowired BoardRepository boardRepository;
    @Autowired MemberRepository memberRepository;
    @Autowired EntityManager em;

    @BeforeEach
    void before() {
        Member member1 = new Member("tset1", "test1", "1234");
        Member member2 = new Member("tset2", "test2", "1234");

        Board board1 = new Board(member1, "member1의 게시물1", "member1Post1");
        Board board2 = new Board(member1, "member1의 게시물2", "member1Post2");
        Board board3 = new Board(member2, "member2의 게시물1", "member2Post1");
        Board board4 = new Board(member2, "member2의 게시물2", "member2Post2");

        Member savedMember1 = memberRepository.save(member1);
        Member savedMember2 = memberRepository.save(member2);
        boardRepository.save(board1);
        boardRepository.save(board2);
        boardRepository.save(board3);
        boardRepository.save(board4);

        em.flush();
        em.clear();
    }

    @Test
    @DisplayName("보드의 리스트를 보여주는것 확인")
    void boards() {
        //given
        BoardSearchCondition searchCondition = new BoardSearchCondition();
        searchCondition.setTitleCond("1");
        searchCondition.setWriterCond("2");

        //when
        List<BoardDisplayDto> boards = boardRepository.search(searchCondition);

        //then
        for (BoardDisplayDto board : boards) {
            System.out.println("board = " + board);
        }
    }

    @Test
    @DisplayName("보드 상세정보 보여주는것 확인")
    void board() {
        //given
        //when
        BoardDto boardDto = boardRepository.findBoardDtoById(1L);
        //then
        System.out.println("boardDto = " + boardDto);
    }

    @Test
    @DisplayName("보드 수정 화면 넘어갈때 수정 Dto로 잘 조회해서 넘기는지 확인")
    void sendEditDto() {
        //given
        //when
        BoardEditDto editDto = boardRepository.findEditDtoById(1L);
        //then
        System.out.println("editDto = " + editDto);
    }

}