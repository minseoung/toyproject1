package toy.toyproject1.domain.repository;

import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.util.StringUtils;
import toy.toyproject1.domain.entity.board.Board;
import toy.toyproject1.domain.entity.board.BoardDisplayDto;
import toy.toyproject1.domain.entity.board.BoardSearchCondition;
import toy.toyproject1.domain.entity.board.QBoard;
import toy.toyproject1.domain.entity.member.QMember;

import java.util.List;

import static toy.toyproject1.domain.entity.board.QBoard.*;
import static toy.toyproject1.domain.entity.member.QMember.*;

@RequiredArgsConstructor
public class BoardRepositoryImpl implements BoardRepositoryCustom{
    private final EntityManager em;
    private final JPAQueryFactory queryFactory;

    @Override
    public List<BoardDisplayDto> search(BoardSearchCondition condition) {

        return queryFactory
                .select(Projections.constructor(BoardDisplayDto.class,
                        board.id.as("boardId"),
                        board.member.id.as("memberId"),
                        board.title,
                        board.member.username.as("writer"),
                        board.lastModifiedDate.as("writtenDate")
                        ))
                .from(board)
                .join(board.member, member)
                .where(titleEq(condition.getTitleCond()), writerEq(condition.getWriterCond()))
                .fetch();
    }


    private Predicate titleEq(String titleCond) {
        return StringUtils.hasText(titleCond) ? board.title.contains(titleCond) : null;
    }

    private Predicate writerEq(String writerCond) {
        return StringUtils.hasText(writerCond) ? board.member.username.contains(writerCond) : null;
    }
}
