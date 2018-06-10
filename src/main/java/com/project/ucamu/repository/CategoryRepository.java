package com.project.ucamu.repository;

import com.project.ucamu.base.JpaQueryDslPredicateRepository;
import com.project.ucamu.domain.Category;

public interface CategoryRepository extends JpaQueryDslPredicateRepository<Category, Integer> {
    Category findCategoryByName(String categoryName);
}
