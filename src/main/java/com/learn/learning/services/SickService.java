package com.learn.learning.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.learning.models.entities.Sick;
import com.learn.learning.models.repositories.SickRepository;

@Service
@Transactional
public class SickService {
    @Autowired
    private SickRepository sickRepository;

    public Sick save(Sick sick){
        return sickRepository.save(sick);
    }

    public Sick findOne(Long id){
        Optional<Sick> sick = sickRepository.findById(id);
        if(!sick.isPresent()){
            return null;
        }
        return sick.get();
    }

    public Iterable<Sick> findAll(){
        return sickRepository.findAll();
    }

    public void removeOne(Long id){
        sickRepository.deleteById(id);
    }

    public List<Sick> findByName(String name){
        return sickRepository.findByName(name);
    }

    public List<Sick> findByNameContains(String name){
        return sickRepository.findByNameContainsOrderByNameAsc(name);
    }

    public List<Sick> findByStartName(String name){
        return sickRepository.findByNameStartingWith(name);
    }
}
