package toy.toyproject1.domain.entity.member;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMember is a Querydsl query type for Member
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMember extends EntityPathBase<Member> {

    private static final long serialVersionUID = 1218459077L;

    public static final QMember member = new QMember("member1");

    public final ListPath<toy.toyproject1.domain.entity.board.Board, toy.toyproject1.domain.entity.board.QBoard> boards = this.<toy.toyproject1.domain.entity.board.Board, toy.toyproject1.domain.entity.board.QBoard>createList("boards", toy.toyproject1.domain.entity.board.Board.class, toy.toyproject1.domain.entity.board.QBoard.class, PathInits.DIRECT2);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath pw = createString("pw");

    public final StringPath userid = createString("userid");

    public final StringPath username = createString("username");

    public QMember(String variable) {
        super(Member.class, forVariable(variable));
    }

    public QMember(Path<? extends Member> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMember(PathMetadata metadata) {
        super(Member.class, metadata);
    }

}

