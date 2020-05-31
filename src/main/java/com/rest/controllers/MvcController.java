package com.rest.controllers;


import com.rest.model.Request;
import com.rest.model.RequestStage;
import com.rest.repository.RequestStageRepository;
import com.rest.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MvcController {


    @GetMapping("/page")
    public String page(){



        return "email";

    }





}
