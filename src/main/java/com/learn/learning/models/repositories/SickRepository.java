package com.learn.learning.models.repositories;

import org.springframework.data.repository.CrudRepository;

import com.learn.learning.models.entities.Sick;

public interface SickRepository extends CrudRepository<Sick, Long> {
    
}
