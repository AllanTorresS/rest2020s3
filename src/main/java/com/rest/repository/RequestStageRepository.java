package com.rest.repository;

import com.rest.model.Request;
import com.rest.model.RequestStage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RequestStageRepository extends JpaRepository<RequestStage,Long> {


    List<RequestStage> findAllByRequestId(Long userEntityId);

}
