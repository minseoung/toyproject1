package toy.toyproject1.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QAuditingBy is a Querydsl query type for AuditingBy
 */
@Generated("com.querydsl.codegen.DefaultSupertypeSerializer")
public class QAuditingBy extends EntityPathBase<AuditingBy> {

    private static final long serialVersionUID = -1441751257L;

    public static final QAuditingBy auditingBy = new QAuditingBy("auditingBy");

    public final QAuditingTime _super = new QAuditingTime(this);

    public final StringPath createdBy = createString("createdBy");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final StringPath lastModifiedBy = createString("lastModifiedBy");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastModifiedDate = _super.lastModifiedDate;

    public QAuditingBy(String variable) {
        super(AuditingBy.class, forVariable(variable));
    }

    public QAuditingBy(Path<? extends AuditingBy> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAuditingBy(PathMetadata metadata) {
        super(AuditingBy.class, metadata);
    }

}

