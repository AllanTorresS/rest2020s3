package com.rest.service;

import com.rest.enumeration.RequestState;
import com.rest.exceptions.NotFoundException;
import com.rest.model.Request;
import com.rest.model.RequestStage;
import com.rest.repository.RequestRepository;
import com.rest.repository.RequestStageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class RequestStageService {

    @Autowired
    private RequestStageRepository requestStageRepository;

    @Autowired
    private RequestRepository requestRepository;

    @Transactional
    public RequestStage save(RequestStage requestStage){

        RequestStage requestStageEntity = this.requestStageRepository.save(requestStage);
        return requestStageEntity;
    }


    public RequestStage findById(Long requestStageId){
        Optional<RequestStage> requestStageEntity = this.requestStageRepository.findById(requestStageId);
        return requestStageEntity.orElseThrow(()-> new NotFoundException("não foi encontrado o usuario com esse id"));
    }

    public List<Request> listAllUser(){
        List<Request> requestEntity = this.requestRepository.findAll();
        return requestEntity;
    }

    public List<RequestStage> findAllStagesByOwenrId(Long ownerId){
        List<RequestStage> requestStageListEntity = this.requestStageRepository.findAllByRequestId(ownerId);
        return requestStageListEntity;
    }


}
