package com.api.user.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class Phone implements Serializable{

    private static final long serialVersionUID = 1L;
    private Long number;
    private Long citycode;
    private Long countrycode;

}
