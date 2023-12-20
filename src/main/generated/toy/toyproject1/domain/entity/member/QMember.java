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

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMember member = new QMember("member1");

    public final ListPath<toy.toyproject1.domain.entity.board.Board, toy.toyproject1.domain.entity.board.QBoard> boards = this.<toy.toyproject1.domain.entity.board.Board, toy.toyproject1.domain.entity.board.QBoard>createList("boards", toy.toyproject1.domain.entity.board.Board.class, toy.toyproject1.domain.entity.board.QBoard.class, PathInits.DIRECT2);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final toy.toyproject1.domain.entity.messenger.QMessenger messenger;

    public final StringPath pw = createString("pw");

    public final StringPath userid = createString("userid");

    public final StringPath username = createString("username");

    public QMember(String variable) {
        this(Member.class, forVariable(variable), INITS);
    }

    public QMember(Path<? extends Member> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMember(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMember(PathMetadata metadata, PathInits inits) {
        this(Member.class, metadata, inits);
    }

    public QMember(Class<? extends Member> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.messenger = inits.isInitialized("messenger") ? new toy.toyproject1.domain.entity.messenger.QMessenger(forProperty("messenger")) : null;
    }

}

