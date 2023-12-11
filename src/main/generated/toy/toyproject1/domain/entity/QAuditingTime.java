package toy.toyproject1.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QAuditingTime is a Querydsl query type for AuditingTime
 */
@Generated("com.querydsl.codegen.DefaultSupertypeSerializer")
public class QAuditingTime extends EntityPathBase<AuditingTime> {

    private static final long serialVersionUID = 1752002973L;

    public static final QAuditingTime auditingTime = new QAuditingTime("auditingTime");

    public final DateTimePath<java.time.LocalDateTime> createdDate = createDateTime("createdDate", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> lastModifiedDate = createDateTime("lastModifiedDate", java.time.LocalDateTime.class);

    public QAuditingTime(String variable) {
        super(AuditingTime.class, forVariable(variable));
    }

    public QAuditingTime(Path<? extends AuditingTime> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAuditingTime(PathMetadata metadata) {
        super(AuditingTime.class, metadata);
    }

}

