package toy.toyproject1.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import toy.toyproject1.domain.entity.member.Member;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByUserid(String userid);
    @Query("select m.username from Member m where m.id = :memberId")
    String findUsernameById(@Param("memberId") Long memberId);
}
