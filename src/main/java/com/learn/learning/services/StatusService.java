package com.learn.learning.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.learn.learning.models.entities.Status;
import com.learn.learning.models.repositories.StatusRepository;

@Service
@Transactional
public class StatusService {
    @Autowired
    private StatusRepository statusRepository;

    public Status save(Status status){
        return statusRepository.save(status);
    }

    public Status findOne(Long id){
        Optional<Status> status = statusRepository.findById(id);
        if(!status.isPresent()){
            return null;
        }
        return status.get();
    }

    public Iterable<Status> findAll(){
        return statusRepository.findAll();
    }

    public void removeOne(Long id){
        statusRepository.deleteById(id);
    }

    public Iterable<Status> findByName(String name, Pageable pageable){
        return statusRepository.findByNameContains(name, pageable);
    }

    public Iterable<Status> saveBach(Iterable<Status> status){
        return statusRepository.saveAll(status);
    }
}
