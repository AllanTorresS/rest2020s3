package com.rest.repository;

import com.rest.enumeration.RequestState;
import com.rest.model.Request;
import com.rest.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface RequestRepository extends JpaRepository<Request,Long> {


    List<Request> findAllByUserEntityId(Long userEntityId);

    @Transactional()
    @Modifying
    @Query("update Request  set requestState = ?2 where id = ?1")
    int updateStatusRequest(Long resquestId, RequestState novoStatusDoPedido);// retorna o numero de linhas alteradas

}
