package com.rest.repository;


import com.rest.enumeration.RequestState;
import com.rest.model.Request;
import com.rest.model.RequestStage;
import com.rest.model.UserEntity;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RequestStageRespositoryTest {

    @Autowired
    private RequestStageRepository requestStageRepository;


    @Test
    public void saveTest(){
        UserEntity owner = new UserEntity();
        owner.setId(1L);

        Request request = new Request();
        request.setId(1L);

        RequestStage requestStage = new RequestStage();
        requestStage.setDescription("mais um estágio da venda");
        requestStage.setRealizationDate(new Date());
        requestStage.setRequest(request);
        requestStage.setUserEntity(owner);
        requestStage.setRequestState(RequestState.EM_PROGRESSO);

        RequestStage requestStageEntityCreated =  requestStageRepository.save(requestStage);

        assertThat(requestStageEntityCreated.getId()).isNotNull();
    }

    @Test
    public void getByIdTest(){
        Optional<RequestStage> requestRecovery =  this.requestStageRepository.findById(3L);

        assertThat(requestRecovery.orElse(null)).isNotNull();
    }

    @Test
    public void updateTest(){
        UserEntity owner = new UserEntity();
        owner.setId(1L);

        Request request = new Request();
        request.setId(1L);

        RequestStage requestStage = new RequestStage();
        requestStage.setDescription("update");
        requestStage.setRequest(request);
        requestStage.setUserEntity(owner);
        requestStage.setRealizationDate(new Date());
        requestStage.setRequestState(RequestState.EM_PROGRESSO);

        RequestStage requestEntityUpdated =  requestStageRepository.save(requestStage);

        assertThat(requestEntityUpdated.getDescription()).isEqualTo("update");
    }

    @Test
    public void ListTest(){
        List<RequestStage> requestEntityList=  requestStageRepository.findAll();

        assertThat(requestEntityList.size()).isGreaterThan(0);
    }

}
