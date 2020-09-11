package com.api.user.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRQ implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id; 
    private String name;
    private String email;
    private String password;
    private String token;
    private List<Phone> phones;
    private LocalDateTime creationDate;
    private LocalDateTime lastLogin;
    private LocalDateTime updateDate;
    private Boolean isActive;

}
