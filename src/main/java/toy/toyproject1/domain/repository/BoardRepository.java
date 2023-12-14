package toy.toyproject1.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import toy.toyproject1.domain.entity.board.Board;
import toy.toyproject1.domain.entity.board.BoardDto;
import toy.toyproject1.domain.entity.board.BoardEditDto;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long>, BoardRepositoryCustom {
    @Query("select new toy.toyproject1.domain.entity.board.BoardEditDto(b.id, b.title, b.content) from Board b where b.id = :boardId")
    BoardEditDto findEditDtoById(@Param("boardId") Long boardId);
    @Query("select new toy.toyproject1.domain.entity.board.BoardDto(b.id, m.id, b.title, b.content, m.username) from Board b join b.member m where b.id = :boardId")
    BoardDto findBoardDtoById(@Param("boardId") Long boardId);
}
