package com.rest.repository;

import com.rest.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {

    @Query(value = "  from  UserEntity u where email = ?2 and password = ?1")
    Optional<UserEntity> findByEmailAndPassword(String password, String email);

}
