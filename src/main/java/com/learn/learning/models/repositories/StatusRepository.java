package com.learn.learning.models.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.learning.models.entities.Status;

public interface StatusRepository extends JpaRepository<Status, Long> {
    Page<Status> findByNameContains(String name, Pageable pageable);
}
