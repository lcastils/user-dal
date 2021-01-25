package com.api.user.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "corporate")
public class CorporateEntity {
	
	@Id
	@Column(name = "corporate_id", nullable = false)
	private String id;
	
	@Column(name = "legalname")
	private String legalname; 
	
	@Column(name = "tradename")
	private String tradename; 
	

}
