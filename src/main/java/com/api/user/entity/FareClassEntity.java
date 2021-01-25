package com.api.user.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "fare_class")
public class FareClassEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "fare_class_id", nullable = false)
	private Long id;
	
	@Column(name = "name")
	private String name; 
	
	@OneToMany(mappedBy = "fareClass")
    private Set<FareClassBenefitEntity> fareclassDiscounts = new HashSet<>();

}
