package com.learn.learning.models.repositories;

import org.springframework.data.repository.CrudRepository;

import com.learn.learning.models.entities.Status;

public interface StatusRepository extends CrudRepository<Status, Long> {
    
}
