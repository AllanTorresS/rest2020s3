package com.rest.controllers;


import com.rest.model.Request;
import com.rest.model.RequestStage;
import com.rest.model.UserEntity;
import com.rest.repository.RequestStageRepository;
import com.rest.service.RequestService;
import com.rest.service.UserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("requests")
public class RequestController {


    @Autowired
    private RequestService requestService;

    @Autowired
    private RequestService ddd;

    @Autowired
    private RequestStageRepository requestStageRepository;


    @PostMapping("/")
    public ResponseEntity save(@RequestBody Request request){
        Request entity = this.requestService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(entity);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@RequestBody Request request,@PathVariable Long id){
        request.setId(id);
        Request entityUpdated = this.requestService.update(request);

        return ResponseEntity.ok(entityUpdated);
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id){

        Request entityFind = this.requestService.findById(id);

        return entityFind == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(entityFind);

    }

    @GetMapping("/")
    public ResponseEntity findAllRequest(){

        List<Request> entityFind = this.requestService.listAllUser();

        return ResponseEntity.ok(entityFind);

    }

    @GetMapping("/page")
    public String page(){



        return "email";

    }


    @GetMapping("/{id}/request-stages")
    public ResponseEntity findAllRequesStageByRequestId(@PathVariable Long id){

        List<RequestStage> entityFind = this.requestStageRepository.findAllByRequestId(id);

        return ResponseEntity.ok(entityFind);

    }



}
