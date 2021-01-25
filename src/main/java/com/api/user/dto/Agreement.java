package com.api.user.dto;

import java.io.Serializable;
import java.util.List;

import com.api.user.entity.SubAgreementEntity;

import lombok.Data;

@Data
public class Agreement implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private Pos posLider;
	private AgreementType agreementType;
	private AgreementStatus agreementStatus;
	private Long negId;
	private List<SubAgreementEntity> subAgreementList;

}
