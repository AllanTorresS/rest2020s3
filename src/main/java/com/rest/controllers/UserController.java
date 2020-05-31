package com.rest.controllers;


import com.rest.model.Request;
import com.rest.model.UserEntity;
import com.rest.service.RequestService;
import com.rest.service.UserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserEntityService userEntityService;

    @Autowired
    private RequestService requestService;

    @PostMapping("/")
    public ResponseEntity save(@RequestBody UserEntity userEntity){
        UserEntity entity = this.userEntityService.save(userEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(entity);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@RequestBody UserEntity userEntity,@PathVariable Long id){
        userEntity.setId(id);
        UserEntity entityUpdated = this.userEntityService.update(userEntity);

        return ResponseEntity.ok(entityUpdated);
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id){

        UserEntity entityFind = this.userEntityService.findById(id);

        return entityFind == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(entityFind);

    }

    @GetMapping("/")
    public ResponseEntity findAllUsers(){

        List<UserEntity> entityFind = this.userEntityService.listAllUser();

        return ResponseEntity.ok(entityFind);

    }

    @PostMapping("/login")
    public ResponseEntity logar(@RequestBody UserEntity userEntity){

        UserEntity userLogged = this.userEntityService.Login(userEntity.getEmail(),userEntity.getPassword());

        return ResponseEntity.ok(userLogged);

    }

    @GetMapping("/{id}/requests")
    public ResponseEntity findAllRequestsByUser(@PathVariable Long id){

        List<Request> entityFind = this.requestService.findByOwenrId(id);

        return ResponseEntity.ok(entityFind);

    }

}
