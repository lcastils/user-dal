package com.api.user.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class Pos implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String name; 
}