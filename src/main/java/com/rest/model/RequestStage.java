package com.rest.model;

import com.rest.enumeration.RequestState;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class RequestStage implements Serializable {

    private static final long serialVersionUID = -6873265838358334702L;
    @Id
    @SequenceGenerator(name="request_stage_genarator", sequenceName="request_stage_seq_id",  allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="request_stage_genarator")
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date realizationDate;

    @Column(columnDefinition ="text", nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "request_id")
    private Request request;

    @Column(length = 12, nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private RequestState requestState;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private UserEntity userEntity;
}
