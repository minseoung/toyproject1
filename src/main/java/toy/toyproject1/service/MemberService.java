package toy.toyproject1.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import toy.toyproject1.domain.entity.member.LoginDto;
import toy.toyproject1.domain.entity.member.Member;
import toy.toyproject1.domain.entity.member.MemberAddDto;
import toy.toyproject1.domain.repository.MemberRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    public Member join(MemberAddDto memberAddDto) {
        Member member = new Member(memberAddDto.getUsername(), memberAddDto.getUserid(), memberAddDto.getPw());
        return memberRepository.save(member);
    }

    public void login(LoginDto loginDto, BindingResult bindingResult) {
        Member findMember = memberRepository.findByUserid(loginDto.getUserid());
        if (findMember == null || !(findMember.getPw() == loginDto.getPw())) {
            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다.");
        }
    }

}
