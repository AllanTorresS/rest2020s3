package com.rest.enumeration;

import lombok.Getter;

@Getter
public enum RequestState {
    ABERTA(1L),
    EM_PROGRESSO(2L),
    FECHADA(3L);

    private  Long id;

    RequestState(Long id) {
        this.id =id;
    }
}
