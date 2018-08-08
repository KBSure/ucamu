package com.project.ucamu.repository;

import com.project.ucamu.base.JpaQueryDslPredicateRepository;
import com.project.ucamu.domain.Board;
import com.project.ucamu.repository.custom.BoardRepositoryCustom;

public interface BoardRepository extends JpaQueryDslPredicateRepository<Board, Long>, BoardRepositoryCustom {

}
