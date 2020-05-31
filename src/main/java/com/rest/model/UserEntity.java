package com.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.rest.enumeration.RequestState;
import com.rest.enumeration.Role;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Entity
public class UserEntity implements Serializable {


    private static final long serialVersionUID = -3602897782717566082L;
    @Id
    @SequenceGenerator(name="user_genarator", sequenceName="user_seq_id",  allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="user_genarator")
    private Long id;

    @Column(length = 75, nullable = false)
    private String name;

    @Column(length = 75, nullable = false, unique = true)
    private String email;

    /**
     * @Setter(onMethod =  @__({@JsonProperty})  ) indica que durante a 'DESEREALIZAÇÃO'
     * ou seja quando o front envia o json a propriedade Password vai ser setada.
     *
     * @Getter(onMethod =  @__({@JsonIgnore})  ) indica que quando for enviado o json do
     * usuario o password não vai ser enviado. AFINAL O PASSWORD É INFORMAÇÃO sensivel
     */
    @Setter(onMethod =  @__({@JsonProperty})  )
    @Getter(onMethod =  @__({@JsonIgnore})  )
    @Column(length = 100, nullable = false)
    private String password;

    @CreatedDate
    private Date createdDate;

    @LastModifiedDate
    private Date dateModified;

    @Column(length = 12, nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private Role role;


    /**
     * @Getter(onMethod =  @__({@JsonIgnore})  ), usado para remover referencia ciclica
     * assim durante a resposta ou seja a 'SERIALIZAÇAO' ele não vai converter  a lista requests em
     * JSON e que vai gerar um loppping infinito
     * */
    @Getter(onMethod =  @__({@JsonIgnore})  )
    @OneToMany(mappedBy = "userEntity")
    private List<Request> requests;

    @Getter(onMethod =  @__({@JsonIgnore})  )
    @OneToMany(mappedBy = "userEntity")
    private List<RequestStage> requestStages;
}
