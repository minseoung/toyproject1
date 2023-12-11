package toy.toyproject1.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import toy.toyproject1.domain.entity.member.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
