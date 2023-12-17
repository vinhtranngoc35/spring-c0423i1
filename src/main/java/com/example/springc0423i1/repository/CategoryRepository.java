package com.example.springc0423i1.repository;

import com.example.springc0423i1.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}