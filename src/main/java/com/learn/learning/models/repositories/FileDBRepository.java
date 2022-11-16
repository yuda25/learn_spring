package com.learn.learning.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.learning.models.entities.FileDB;

public interface FileDBRepository extends JpaRepository<FileDB, Long>{
    
}
