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
import com.learn.learning.dto.StatusDto;
import com.learn.learning.models.entities.Status;
import com.learn.learning.services.StatusService;

@RestController
@RequestMapping("status")
public class StatusController {
    @Autowired
    private StatusService statusService;

    @Autowired 
    private ModelMapper modelMapper;

    @PostMapping(value = "add-status")
    public ResponseEntity<ResponseData<Status>> create(@Valid @RequestBody StatusDto statusDto, Errors errors){
        ResponseData<Status> responseData = new ResponseData<>();
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

        Status status = modelMapper.map(statusDto, Status.class);

        responseData.setStatus(true);
        responseData.setPayload(statusService.save(status));
        return ResponseEntity.ok(responseData);
    }

    @GetMapping(value = "get-all")
    public Iterable<Status> findAll(){
        return statusService.findAll();
    }

    @GetMapping(value = "get-by-id/{id}")
    public Status findOne(@PathVariable("id") Long id){
        return statusService.findOne(id);
    }

    @PutMapping(value = "update")
    public ResponseEntity<ResponseData<Status>> update(@Valid @RequestBody StatusDto statusDto, Errors errors){
        ResponseData<Status> responseData = new ResponseData<>();
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

        Status status = modelMapper.map(statusDto, Status.class);

        responseData.setStatus(true);
        responseData.setPayload(statusService.save(status));
        return ResponseEntity.ok(responseData);
    }

    @DeleteMapping(value = "delete/{id}")
    public void delete(@PathVariable("id") long id) {
        statusService.removeOne(id);
    }
}
