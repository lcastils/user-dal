package com.api.user.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "fare_class_benefits")
public class FareClassBenefitEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	 @ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fare_class_id")
    private FareClassEntity fareClass;
 
	 @ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "benefits_agmt_detail_id")
	private BenefitAgmtDetailEntity benfAgmtDetail;
    
    @Column (name = "discount")
    private Double discount; 
    
  
}
