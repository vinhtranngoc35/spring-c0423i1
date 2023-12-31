package com.example.springc0423i1.repository;

import com.example.springc0423i1.domain.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    Page<Task> findTasksByDescriptionContainingOrTitleContaining(String description, String title, Pageable pageable);

}