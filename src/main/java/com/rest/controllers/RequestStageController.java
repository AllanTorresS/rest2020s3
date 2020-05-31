package com.rest.controllers;


import com.rest.model.Request;
import com.rest.model.RequestStage;
import com.rest.service.RequestService;
import com.rest.service.RequestStageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("request-stages")
public class RequestStageController {

    @Autowired
    private RequestStageService requestStageService;


    @PostMapping("/")
    public ResponseEntity save(@RequestBody RequestStage requestStage){
        RequestStage entity = this.requestStageService.save(requestStage);
        return ResponseEntity.status(HttpStatus.CREATED).body(entity);
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id){

        RequestStage entityFind = this.requestStageService.findById(id);

        return entityFind == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(entityFind);

    }

}
