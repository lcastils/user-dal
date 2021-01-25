package com.api.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.user.dto.Agreement;
import com.api.user.entity.AgreementEntity;
import com.api.user.repository.AgreementRepository;
import com.api.user.service.AgreementService;
import com.api.user.utils.Converter;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class AgreementServiceImpl implements AgreementService {

	@Autowired
	AgreementRepository agrementRepository;

	@Override
	public List<AgreementEntity> findAllAgrement() {
		return agrementRepository.findAll();
	}

	@Override
	public void saveAgreement(Agreement agreement) {
		AgreementEntity ag =   Converter.getMapper().map(agreement, AgreementEntity.class);
		log.info(ag.toString());
		agrementRepository.save(ag);
	}
	
	@Override
	public void updateAgreement(Agreement agreement) {
		AgreementEntity ag =   Converter.getMapper().map(agreement, AgreementEntity.class);
		ag.getSubAgreementList().forEach(x->x.setSubAgmtVersion(x.getSubAgmtVersion()+1));
		log.info(ag.toString());
		agrementRepository.save(ag);
	}

}
