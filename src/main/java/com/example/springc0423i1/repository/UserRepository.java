package com.example.springc0423i1.repository;

import com.example.springc0423i1.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
