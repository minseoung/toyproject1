package toy.toyproject1.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import toy.toyproject1.domain.entity.member.Member;
import toy.toyproject1.domain.entity.member.MemberDto;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByUserid(String userid);
    @Query("select m.username from Member m where m.id = :memberId")
    String findUsernameById(@Param("memberId") Long memberId);
    @Query("select new toy.toyproject1.domain.entity.member.MemberDto(m.id, m.username, b.id, b.title) from Member m join Board b on m.id = b.member.id where m.id = :memberId")
    List<MemberDto> findDtoById(@Param("memberId") Long memberId);
}
