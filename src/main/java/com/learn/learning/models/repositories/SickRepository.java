package com.learn.learning.models.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.learn.learning.models.entities.Sick;

public interface SickRepository extends CrudRepository<Sick, Long> {
    List<Sick> findByName(String name);

    List<Sick> findByNameContainsOrderByNameAsc(String name);

    List<Sick> findByNameStartingWith(String name);
}
