package toy.toyproject1.domain.entity.messenger;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QMessenger is a Querydsl query type for Messenger
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMessenger extends EntityPathBase<Messenger> {

    private static final long serialVersionUID = 569069007L;

    public static final QMessenger messenger = new QMessenger("messenger");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath username = createString("username");

    public QMessenger(String variable) {
        super(Messenger.class, forVariable(variable));
    }

    public QMessenger(Path<? extends Messenger> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMessenger(PathMetadata metadata) {
        super(Messenger.class, metadata);
    }

}

