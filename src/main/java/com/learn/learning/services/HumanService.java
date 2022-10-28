package com.learn.learning.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.learning.models.entities.Human;
import com.learn.learning.models.repositories.HumanRepository;

@Service
@Transactional
public class HumanService {
    
    @Autowired
    private HumanRepository humanRepository;

    public Human save(Human human) {
        return humanRepository.save(human);
    }

    public Human findOne(Long id) {
        return humanRepository.findById(id).get();
    }

    public Iterable<Human> findAll() {
        return humanRepository.findAll();
    }

    public void remove(Long id) {
        humanRepository.deleteById(id);
    }
}
