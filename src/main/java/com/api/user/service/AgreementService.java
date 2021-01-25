package com.api.user.service;

import java.util.List;

import com.api.user.dto.Agreement;
import com.api.user.entity.AgreementEntity;

public interface AgreementService {
	
	List<AgreementEntity>  findAllAgrement () ; 
	
	void saveAgreement(Agreement agreement) ;

	void updateAgreement(Agreement agreement);

}
