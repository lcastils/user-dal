package com.api.user.entity;

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
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "agreement")
public class AgreementEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "agmt_id", nullable = false)
	private Long id;
	
    @JoinColumn(name = "pos_lider_id", referencedColumnName = "pos_id", nullable = false)
    @ManyToOne
	private PosEntity posLider; 
	
    @JoinColumn(name = "agmt_type_id", referencedColumnName = "agmt_type_id", nullable = false)
    @ManyToOne
	private AgreementTypeEntity agreementType;  
    
    @JoinColumn(name = "agmt_status_id", referencedColumnName = "agmt_status_id", nullable = false)
    @ManyToOne
	private AgreementStatusEntity agreementStatus; 
    
    @Column(name = "neg_id")
    private Long negId;
    
    @JoinColumn(name = "agmt_id", referencedColumnName = "agmt_id", nullable = false)
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<SubAgreementEntity> subAgreementList;
    
    

}
