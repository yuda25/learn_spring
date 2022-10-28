package com.learn.learning.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.learning.models.entities.Human;
import com.learn.learning.services.HumanService;

@RestController
@RequestMapping("/human")
public class HumanController {
    private HumanService humanService;

    public HumanController(HumanService humanService) {
        this.humanService = humanService;
    }

    @PostMapping(value = "add-human")
    public Human create(@RequestBody Human human) {
        return humanService.save(human);
    }

    @GetMapping(value = "get-one/{id}")
    public  Human findOne(@PathVariable("id") Long id) {
        return humanService.findOne(id);
    }
    
    @GetMapping(value = "get-all")
    public Iterable<Human> findAll(){
        return humanService.findAll();
    }

    @PutMapping(value = "update")
    public Human update(@RequestBody Human human) {
        return humanService.save(human);
    }

    @DeleteMapping(value = "delete/{id}")
    public void delete(@PathVariable("id") long id) {
        humanService.remove(id);
    }
}
