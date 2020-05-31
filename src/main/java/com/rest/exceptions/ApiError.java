package com.rest.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
public class ApiError implements Serializable {
    private int codeError;
    private String mensagen;
    private Date date;

}
