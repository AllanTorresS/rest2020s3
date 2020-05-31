package com.rest.repository;


import com.rest.enumeration.Role;
import com.rest.model.UserEntity;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserRespositoryTest {

    @Autowired
    private UserRepository userRepository;

@Test
    public void saveTest(){
        UserEntity user = new UserEntity();
        user.setName("allan teste");
        user.setEmail("allaff44ddnffic@hotmail.com");
        user.setPassword("123");
        user.setRole(Role.ADMINISTRADOR);

        UserEntity userEntityCreated =  userRepository.save(user);

        assertThat(userEntityCreated.getId()).isNotNull();
    }

    @Test
    public void getByIdTest(){
        Optional<UserEntity> userRecovery =  this.userRepository.findById(1l);

        assertThat(userRecovery.orElse(null)).isNotNull();
    }

    @Test
    public void updateTest(){
        UserEntity user = new UserEntity();
        user.setId(1L);
        user.setName("allan atualizado");
        user.setEmail("allanfddic@hotmail.com");
        user.setPassword("123");
        user.setRole(Role.ADMINISTRADOR);
        UserEntity userEntityUpdated =  userRepository.save(user);

        assertThat(userEntityUpdated.getName()).isEqualTo("allan atualizado");
    }

    @Test
    public void ListTest(){
        List<UserEntity> userEntityList=  userRepository.findAll();

        assertThat(userEntityList.size()).isGreaterThan(0);
    }



}
