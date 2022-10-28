package com.learn.learning.models.repositories;

import org.springframework.data.repository.CrudRepository;

import com.learn.learning.models.entities.Human;

public interface HumanRepository extends CrudRepository<Human, Long>{
    
}
