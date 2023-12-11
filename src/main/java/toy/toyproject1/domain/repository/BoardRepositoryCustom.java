package toy.toyproject1.domain.repository;

import toy.toyproject1.domain.entity.board.Board;
import toy.toyproject1.domain.entity.board.BoardDisplayDto;
import toy.toyproject1.domain.entity.board.BoardSearchCondition;

import java.util.List;

public interface BoardRepositoryCustom {
    List<BoardDisplayDto> search(BoardSearchCondition condition);
}
