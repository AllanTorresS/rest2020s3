package com.rest.service;

import com.rest.enumeration.RequestState;
import com.rest.exceptions.NotFoundException;
import com.rest.model.Request;
import com.rest.model.UserEntity;
import com.rest.repository.RequestRepository;
import com.rest.repository.UserRepository;
import com.rest.utils.HashUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class RequestService {

    @Autowired
    private RequestRepository requestRepository;

    @Transactional
    public Request save(Request request){
        request.setRequestState(RequestState.ABERTA);
        request.setCreateDate(new Date());
        Request requestEntity = this.requestRepository.save(request);
        return requestEntity;
    }

    @Transactional
    public Request update(Request request){

        Request requestEntity = this.requestRepository.save(request);
        return requestEntity;
    }

    public Request findById(Long requestId){
        Optional<Request> requestEntity = this.requestRepository.findById(requestId);
        return requestEntity.orElseThrow(()-> new NotFoundException("não foi encontrado uma request com esse id"));
    }

    public List<Request> listAllUser(){
        List<Request> requestEntity = this.requestRepository.findAll();
        return requestEntity;
    }

    public List<Request> findByOwenrId(Long owner){
        List<Request> requestEntity = this.requestRepository.findAllByUserEntityId(owner);
        return requestEntity;
    }


}
