package com.rest.enumeration;

import lombok.Getter;

@Getter
public enum Role {
    ADMINISTRADOR(1L),
    VISITANTE(2L);

    private final Long roleId;

    Role(Long id) {
        this.roleId = id;
    }
}
