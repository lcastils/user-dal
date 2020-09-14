package com.api.user.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.user.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    public Optional<UserEntity> findByEmailAndIsActive(String email, Boolean isActive);

	public List<UserEntity> findByIsActive(Boolean isActive);
}
