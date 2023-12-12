package toy.toyproject1.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import toy.toyproject1.domain.entity.member.Member;
import toy.toyproject1.domain.repository.MemberRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    public Member join(Member member) {
        return memberRepository.save(member);
    }

}
