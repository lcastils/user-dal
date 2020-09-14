package com.api.user.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.user.dto.UserRQ;
import com.api.user.dto.UserRS;
import com.api.user.service.UserService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
public class UserController {

    @Autowired
    private UserService userService;
    
    @GetMapping(value = "/user/findall", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserRS>> findAllUsers() {
        log.info("find all users");
        List<UserRS> userRs = userService.findAllUsers();
        if (!userRs.isEmpty()) {
            return new ResponseEntity<>(userRs, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    

    @GetMapping(value = "/user/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserRS> getUserByEmail(@PathVariable("email") String email) {
        log.info(email);
        UserRS userRs = userService.getUserByEmail(email);
        if (Objects.nonNull(userRs)) {
            return new ResponseEntity<>(userRs, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/user")
    public ResponseEntity<UserRS> createUser(@RequestBody UserRQ user) {
        UserRS userRs = userService.creatreUser(user);
        if (Objects.nonNull(userRs)) {
            return new ResponseEntity<>(userRs, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @PutMapping(value = "/user")
    public ResponseEntity<UserRS> updateUser(@RequestBody UserRQ user) {
        UserRS userRs = userService.updateUser(user);
        if (Objects.nonNull(userRs)) {
            return new ResponseEntity<>(userRs, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @DeleteMapping(value = "/user")
    public ResponseEntity<UserRS> deleteUser(@RequestBody UserRQ user) {
        UserRS userRs = userService.deleteUser(user);
        if (Objects.nonNull(userRs)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
