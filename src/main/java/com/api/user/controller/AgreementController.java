package com.api.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.user.dto.Agreement;
import com.api.user.entity.AgreementEntity;
import com.api.user.service.AgreementService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
public class AgreementController {
	
	@Autowired
	private AgreementService agreementService; 
	
	@GetMapping(value = "/agreement/findall", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AgreementEntity>> findAllUsers() {
        log.info("find all users");
        List<AgreementEntity> agrementRS = agreementService.findAllAgrement();
        if (!agrementRS.isEmpty()) {
            return new ResponseEntity<>(agrementRS, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
	
	@PostMapping(value = "/agreement/save", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AgreementEntity>> saveAgreement(@RequestBody Agreement agreement) {
        log.info("save agreement ");
        agreement.setId(null);
        agreementService.saveAgreement(agreement);
        return new ResponseEntity<>(HttpStatus.OK);
    }
	
	@PutMapping(value = "/agreement/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AgreementEntity>> updateAgreement(@RequestBody Agreement agreement) {
        log.info("update agreement ");
        agreementService.updateAgreement(agreement);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
