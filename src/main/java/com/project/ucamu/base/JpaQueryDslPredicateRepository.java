package com.project.ucamu.base;

import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.io.Serializable;
import java.util.List;

public interface JpaQueryDslPredicateRepository<T, ID  extends Serializable>
        extends JpaRepository<T, ID>, QuerydslPredicateExecutor<T> {
    //findAll 왜 override? List<T>로 반환하기 위해?
    @Override
    List<T> findAll(OrderSpecifier<?>... orders);

    @Override
    List<T> findAll(Predicate predicate);

    @Override
    List<T> findAll(Predicate predicate, OrderSpecifier<?>... orders);

    @Override
    List<T> findAll(Predicate predicate, Sort sort);
}
