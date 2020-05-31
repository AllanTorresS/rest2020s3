package com.rest.repository;


import com.rest.enumeration.RequestState;
import com.rest.enumeration.Role;
import com.rest.model.Request;
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
import static org.assertj.core.api.InstanceOfAssertFactories.LOCAL_DATE;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RequestRespositoryTest {

    @Autowired
    private RequestRepository requestRepository;


    @Test
    public void saveTest(){
        UserEntity owner = new UserEntity();
        owner.setId(1L);

        Request request = new Request();
        request.setDescription("xiaomi");
        request.setSubject("telofone");
        request.setRequestState(RequestState.EM_PROGRESSO);
        request.setCreateDate(java.sql.Date.valueOf(LocalDate.now()));
        request.setUserEntity(owner);

        Request requestEntityCreated =  requestRepository.save(request);

        assertThat(requestEntityCreated.getId()).isNotNull();
    }

    @Test
    public void getByIdTest(){
        Optional<Request> requestRecovery =  this.requestRepository.findById(1l);

        assertThat(requestRecovery.orElse(null)).isNotNull();
    }

    @Test
    public void updateTest(){
        UserEntity owner = new UserEntity();
        owner.setId(1L);

        Request request = new Request();
        request.setDescription("xiaomi atualizado");
        request.setSubject("telofone");
        request.setCreateDate(java.sql.Date.valueOf(LocalDate.now()));
        request.setRequestState(RequestState.FECHADA);
        request.setUserEntity(owner);

        Request requestEntityUpdated =  requestRepository.save(request);

        assertThat(requestEntityUpdated.getDescription()).isEqualTo("xiaomi atualizado");
    }

    @Test
    public void ListTest(){
        List<Request> requestEntityList=  requestRepository.findAll();

        assertThat(requestEntityList.size()).isGreaterThan(0);
    }

    @Test
    public void updateRequest(){
        int numeroDeLinhasAlterados =  requestRepository.updateStatusRequest(1L,RequestState.FECHADA);

        assertThat(numeroDeLinhasAlterados).isEqualTo(1);
    }

}
