package com.project.ucamu.repository;

import com.project.ucamu.base.JpaQueryDslPredicateRepository;
import com.project.ucamu.domain.UserSituation;
import com.project.ucamu.domain.enums.SituationState;

public interface UserSituationRepository extends JpaQueryDslPredicateRepository<UserSituation, Integer> {
    UserSituation findUserSituationByState(SituationState situationState);
}
