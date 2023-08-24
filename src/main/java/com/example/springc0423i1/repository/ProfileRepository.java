package com.example.springc0423i1.repository;

import com.example.springc0423i1.domain.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
}
