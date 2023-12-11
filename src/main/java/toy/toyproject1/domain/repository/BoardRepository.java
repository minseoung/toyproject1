package toy.toyproject1.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import toy.toyproject1.domain.entity.board.Board;

public interface BoardRepository extends JpaRepository<Board, Long>, BoardRepositoryCustom {
}
