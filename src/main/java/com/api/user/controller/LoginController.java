package com.api.user.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.api.user.dto.UserRQ;
import com.api.user.dto.UserRS;
import com.api.user.service.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	@PostMapping(value = "/login")
    public ResponseEntity<UserRS> login(@RequestBody UserRQ user) {
        UserRS userRs = userService.updateUser(user);
        if (Objects.nonNull(userRs)) {
            return new ResponseEntity<>(userRs, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
