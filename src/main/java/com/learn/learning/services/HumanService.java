package com.learn.learning.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.learning.models.entities.Human;
import com.learn.learning.models.entities.Sick;
import com.learn.learning.models.repositories.HumanRepository;

@Service
@Transactional
public class HumanService {
    
    @Autowired
    private HumanRepository humanRepository;

    @Autowired
    private SickService sickService;

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

    public void addSick(Sick sick, Long humanId){
        Human human = findOne(humanId);
        if(human == null){
            throw new RuntimeException("human with id:"+humanId+"not found");
        }
        human.getSicks().add(sick);
        save(human);
    }

    public Human findByHumanName(String name){
        return humanRepository.findHumanByName(name);
    }

    public List<Human> findByHumanNameLike(String name){
        return humanRepository.findHumanByNameLike("%"+name+"%");
    }

    public List<Human> findByStatusId(Long statusId){
        return humanRepository.findHumanByStatusId(statusId);
    }

    public List<Human> findBySick(Long sickId){
        Sick sick = sickService.findOne(sickId);
        if(sick == null){
            return new ArrayList<Human>();
        }
        return humanRepository.findHumanBySick(sick);        
    }

}
