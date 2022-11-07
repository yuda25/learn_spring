package com.learn.learning.controllers;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.learning.dto.ResponseData;
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
    public ResponseEntity<ResponseData<Human>> create(@Valid @RequestBody Human human, Errors errors) {
        
        ResponseData<Human> responseData = new ResponseData<>();

        if(errors.hasErrors()){
            for(ObjectError error : errors.getAllErrors()){
                responseData.getMessage().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        responseData.setStatus(true);
        responseData.setPayload(humanService.save(human));
        return ResponseEntity.ok(responseData);
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
    public ResponseEntity<ResponseData<Human>> update(@Valid @RequestBody Human human, Errors errors) {

        ResponseData<Human> responseData = new ResponseData<>();

        if(errors.hasErrors()) {
            for(ObjectError error : errors.getAllErrors()) {
                responseData.getMessage().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        responseData.setStatus(true);
        responseData.setPayload(humanService.save(human));
        return ResponseEntity.ok(responseData);
    }

    @DeleteMapping(value = "delete/{id}")
    public void delete(@PathVariable("id") long id) {
        humanService.remove(id);
    }
}
