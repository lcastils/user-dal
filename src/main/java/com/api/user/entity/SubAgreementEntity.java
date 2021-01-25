package com.api.user.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sub_agreement")
public class SubAgreementEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sub_agmt_id", nullable = false)
	private Long id;

	@JoinColumn(name = "pos_id", referencedColumnName = "pos_id", nullable = false)
	@ManyToOne
	private PosEntity posId;
	
	@JoinColumn(name = "seg_id", referencedColumnName = "seg_id", nullable = false)
	@ManyToOne
	private SegmentationEntity segementation;
	
	@Column(name = "start_date")
	private LocalDate startDate;
	
	@Column(name = "end_date")
	private LocalDate endtDate;
	
	@Column(name = "tourcode")
	private String tourcode;
	
//	user_bp          varchar(10) comment 'id usuario realiza contrato', 
	
	@JoinColumn(name = "corporate_id", referencedColumnName = "corporate_id", nullable = false)
	@ManyToOne
	private CorporateEntity corporate;
	
	@Column(name = "account_code")
	private String accountCode;
	
	@Column(name = "taxid")
	private String taxid;
	
	@Column(name = "rule_number")
	private String ruleNumber;
	
	@Column(name = "ariba_code")
	private String aribaCode;
	
	@Column(name = "sub_agmt_version")
	private Long subAgmtVersion;
	
	@JoinColumn(name = "sub_agmt_id", referencedColumnName = "sub_agmt_id", nullable = false)
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<BenefitEntity> benefits; 

}
