package com.block.chain.news.domain.user;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = -1700017468L;

    public static final QUser user = new QUser("user");

    public final com.block.chain.news.domain.QBaseTimeEntity _super = new com.block.chain.news.domain.QBaseTimeEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createDate = _super.createDate;

    public final StringPath email = createString("email");

    public final ListPath<com.block.chain.news.domain.follow.Follow, com.block.chain.news.domain.follow.QFollow> follower = this.<com.block.chain.news.domain.follow.Follow, com.block.chain.news.domain.follow.QFollow>createList("follower", com.block.chain.news.domain.follow.Follow.class, com.block.chain.news.domain.follow.QFollow.class, PathInits.DIRECT2);

    public final ListPath<com.block.chain.news.domain.follow.Follow, com.block.chain.news.domain.follow.QFollow> following = this.<com.block.chain.news.domain.follow.Follow, com.block.chain.news.domain.follow.QFollow>createList("following", com.block.chain.news.domain.follow.Follow.class, com.block.chain.news.domain.follow.QFollow.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedDate = _super.modifiedDate;

    public final StringPath name = createString("name");

    public final StringPath picture = createString("picture");

    public final EnumPath<Role> role = createEnum("role", Role.class);

    public final NumberPath<Long> userId = createNumber("userId", Long.class);

    public QUser(String variable) {
        super(User.class, forVariable(variable));
    }

    public QUser(Path<? extends User> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUser(PathMetadata metadata) {
        super(User.class, metadata);
    }

}

