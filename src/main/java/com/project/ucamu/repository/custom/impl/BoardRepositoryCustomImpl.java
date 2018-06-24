package com.project.ucamu.repository.custom.impl;

import com.project.ucamu.domain.Board;
import com.project.ucamu.domain.QBoard;
import com.project.ucamu.repository.custom.BoardRepositoryCustom;
import com.querydsl.jpa.JPQLQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class BoardRepositoryCustomImpl extends QuerydslRepositorySupport implements BoardRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    public BoardRepositoryCustomImpl() {
        this(Board.class);
    }

    public BoardRepositoryCustomImpl(Class<?> domainClass) {
        super(domainClass);
    }

    private enum SearchType{
        TITLE, WHO, WHEN, WHERE, WHAT, HOW, WHY, CONTENT, USER
    }

    @Override
    public List<Board> findBoardList(String categoryName, Pageable pageable, String searchType, String searchStr) {
        QBoard qBoard = QBoard.board;
        JPQLQuery<Board> query = from(qBoard);

        query = whereSearch(query, qBoard, searchType, searchStr);
        query = whereCategory(query, qBoard, categoryName);

        return getQuerydsl().applyPagination(pageable, query).fetch();
    }

    private JPQLQuery<Board> whereCategory(JPQLQuery<Board> query, QBoard qBoard, String categoryName){
        if(categoryName == null){
            return query;
        }else{
            return query;
        }
    }

    private JPQLQuery<Board> whereSearch(JPQLQuery<Board> query, QBoard qBoard, String searchType, String searchStr){
        if(searchType == null){ //최초 list
            return query;
        }

        String searchTypeUpper = searchType.toUpperCase();
        if(searchStr != null) {
            switch (SearchType.valueOf(searchTypeUpper)) {
                case TITLE:
                    return query.where(qBoard.title.like("%" + searchStr + "%"));
                case WHO:
                    return query.where(qBoard.content.who.like("%" + searchStr + "%"));
                case WHEN:
                    return query.where(qBoard.content.when.like("%" + searchStr + "%"));
                case WHERE:
                    return query.where(qBoard.content.where.like("%" + searchStr + "%"));
                case WHAT:
                    return query.where(qBoard.content.what.like("%" + searchStr + "%"));
                case HOW:
                    return query.where(qBoard.content.how.like("%" + searchStr + "%"));
                case WHY:
                    return query.where(qBoard.content.why.like("%" + searchStr + "%"));
//            case CONTENT: //where의 파라미터로 6개 predicate 다 넣는가?
                case USER:
                    return query.where(qBoard.user.nickname.equalsIgnoreCase(searchStr));
            }
        }
        return query;
    }
}
