package toy.toyproject1.domain.repository;

import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import toy.toyproject1.domain.entity.board.Board;
import toy.toyproject1.domain.entity.member.LoginDto;
import toy.toyproject1.domain.entity.member.Member;
import toy.toyproject1.domain.entity.member.MemberDto;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Slf4j
class MemberRepositoryTest {

        @Autowired MemberRepository memberRepository;
        @Autowired BoardRepository boardRepository;
        @Autowired EntityManager em;

    @Test
    @DisplayName("회원가입이 잘 되는지 확인")
    void save() {
        //given
        Member member = new Member("tset1", "test1", "1234");
        //when
        Member savedMember = memberRepository.save(member);

        em.flush();
        em.clear();

        Member findMember = memberRepository.findById(member.getId()).get();


        //then
        assertThat(savedMember.getId()).isEqualTo(findMember.getId());
    }

    @Test
    @DisplayName("로그인 성공시 잘 동작하는가 확인")
    void loginSuccess() {
        //given
        Member member = new Member("tset1", "test1", "1234");
        Member savedMember = memberRepository.save(member);

        em.flush();
        em.clear();

        LoginDto loginDto = new LoginDto();
        loginDto.setUserid("test1");
        loginDto.setPw("1234");

        //when
        Member findMember = memberRepository.findByUserid(loginDto.getUserid());
        if (findMember == null || !(findMember.getPw().equals(loginDto.getPw()))) {
            throw  new RuntimeException("아이디 또는 비밀번호가 잘못되었습니다.");
        }
        log.info("로그인 성공");
    }

    @Test
    @DisplayName("로그인이 실패시 오류를 던지는가 잘 동작하는지 확인")
    void loginFail() {
        //given
        Member member = new Member("tset1", "test1", "1234");
        Member savedMember = memberRepository.save(member);

        em.flush();
        em.clear();

        LoginDto loginDto = new LoginDto();
        loginDto.setUserid("test2");
        loginDto.setPw("1234");

        //when
        Member findMember = memberRepository.findByUserid(loginDto.getUserid());

        //then

        assertThatThrownBy(() -> {
            if (findMember == null || !(findMember.getPw().equals(loginDto.getPw()))) {
                throw  new RuntimeException("아이디 또는 비밀번호가 잘못되었습니다.");
            }
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("멤버 상세정보를 보여줄때 쓰이는 Dto조회가 잘 이루어지는가 확인")
    void member() {
        //given
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

        //when
        List<MemberDto> memberDtos = memberRepository.findDtoById(member1.getId());

        //then
        for (MemberDto memberDto : memberDtos) {
            System.out.println("memberDto = " + memberDto);
        }
    }
}