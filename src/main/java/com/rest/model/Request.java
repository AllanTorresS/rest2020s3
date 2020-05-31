package com.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rest.enumeration.RequestState;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Request implements Serializable {


    private static final long serialVersionUID = 4060367929954797317L;
    @Id
    @SequenceGenerator(name="request_genarator", sequenceName="request_seq_id",  allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="request_genarator")
    private Long id;

    @Column(length = 75, nullable = false)
    private String subject;

    @Column(columnDefinition ="text", nullable = false)
    private String description;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @Column(length = 12, nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private RequestState requestState;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    @Getter(onMethod =  @__({@JsonIgnore})  )
    @OneToMany(mappedBy = "request" )
    private List<RequestStage> requestStages;
}
