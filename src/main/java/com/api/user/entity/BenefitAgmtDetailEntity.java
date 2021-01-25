package com.api.user.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "benefits_agreement_detail")
public class BenefitAgmtDetailEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "benefits_agmt_detail_id", nullable = false)
	private Long id;

	@JoinColumn(name = "benefits_type_id", referencedColumnName = "benefits_type_id", nullable = false)
	@ManyToOne
	private BenefitTypeEntity benefitType;

	@OneToMany(mappedBy = "benfAgmtDetail")
    private Set<FareClassBenefitEntity> fareclassDiscounts = new HashSet<>();
//	private java.util.Set fareclassDiscounts = new java.util.HashSet();

}
