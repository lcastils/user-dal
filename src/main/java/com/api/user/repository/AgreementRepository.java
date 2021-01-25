package com.api.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.user.entity.AgreementEntity;

public interface AgreementRepository extends JpaRepository<AgreementEntity, Long>  {

}
