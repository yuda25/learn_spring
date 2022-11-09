package com.learn.learning.controllers;


import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.learn.learning.dto.SickDto;
import com.learn.learning.models.entities.Sick;
import com.learn.learning.services.SickService;

@RestController
@RequestMapping("sick")
public class SickConroller {
    @Autowired
    private SickService sickService;

    @Autowired ModelMapper modelMapper;

    @PostMapping(value = "add-sick")
    public ResponseEntity<ResponseData<Sick>> create(@Valid @RequestBody SickDto sickDto, Errors errors){
        ResponseData<Sick> responseData = new ResponseData<>();
        if(errors.hasErrors()){
            for(ObjectError error : errors.getAllErrors()){
                responseData.getMessage().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        // mapp manual
        // Sick sick = new Sick();
        // sick.setName(sickDto.getName());

        Sick sick = modelMapper.map(sickDto, Sick.class);

        responseData.setStatus(true);
        responseData.setPayload(sickService.save(sick));
        return ResponseEntity.ok(responseData);
    }

    @GetMapping(value = "get-all")
    public Iterable<Sick> findAll(){
        return sickService.findAll();
    }

    @GetMapping(value = "get-one/{id}")
    public Sick findOne(@PathVariable("id") Long id){
        return sickService.findOne(id);
    }

    @PutMapping(value = "update")
    public ResponseEntity<ResponseData<Sick>> update(@Valid @RequestBody SickDto sickDto, Errors errors){
        ResponseData<Sick> responseData = new ResponseData<>();
        if(errors.hasErrors()){
            for(ObjectError error : errors.getAllErrors()){
                responseData.getMessage().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        // mapp manual
        // Sick sick = new Sick();
        // sick.setName(sickDto.getName());

        Sick sick = modelMapper.map(sickDto, Sick.class);

        responseData.setStatus(true);
        responseData.setPayload(sickService.save(sick));
        return ResponseEntity.ok(responseData);
    }

    @DeleteMapping(value = "delete/{id}")
    public void delete(@PathVariable("id") long id){
        sickService.removeOne(id);
    }
}
