package com.api.user.service.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.api.user.dto.Phone;
import com.api.user.dto.UserRQ;
import com.api.user.dto.UserRS;
import com.api.user.entity.PhonesEntity;
import com.api.user.entity.UserEntity;
import com.api.user.repository.UserRepository;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

	private static final String TEST_TOKEN = "Bearer eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJzb2Z0dGVrSldUIiwic3ViIjoiYmFyYmFyYSIsImF1dGhvcml0aWVzIjpbIlJPTEVfVVNFUiJdLCJpYXQiOjE1OTk5NDc4ODEsImV4cCI6MTU5OTk0ODQ4MX0.aJtZ-QJyWjc9TgqHV1jPGoOWPtjKijMQ98EnOS8cy6GldiItgP-usobsA_YVBVdOGhJr--c0vU68Kg96wVxRlA";

	private UserRQ objRq;

	@InjectMocks
	private UserServiceImpl userService;

	@Mock
	private UserRepository userRepository;

	private UserEntity responseSave;

	@Before
	public void init() {

		objRq = new UserRQ();
		objRq.setEmail("luiscastillo@domain.cl");
		objRq.setName("Luis");
		objRq.setPassword("apxbnA28");
		objRq.setToken(null);

		List<Phone> listPhones = new ArrayList<>();
		Phone objPhone = new Phone();
		objPhone.setCitycode(12L);
		objPhone.setCountrycode(2L);
		objPhone.setNumber(981271233L);
		listPhones.add(objPhone);
		objRq.setPhones(listPhones);
		responseSave = new UserEntity();

		List<PhonesEntity> listEntity = listPhones.stream().map(p -> {
			PhonesEntity phoneEntity = new PhonesEntity();
			phoneEntity.setId(1L);
			phoneEntity.setCitycode(p.getCitycode());
			phoneEntity.setCountrycode(p.getCountrycode());
			phoneEntity.setNumber(p.getNumber());
			return phoneEntity;
		}).collect(Collectors.toList());

		responseSave.setCreationDate(LocalDateTime.now());
		responseSave.setEmail(objRq.getEmail());
		responseSave.setId(1L);
		responseSave.setToken(TEST_TOKEN);
		responseSave.setIsActive(Boolean.TRUE);
		responseSave.setName(objRq.getName());
		responseSave.setPhones(listEntity);

		List<UserEntity> listResponse = new ArrayList<>();
		listResponse.add(responseSave);
		Mockito.when(userRepository.findByIsActive(Boolean.TRUE)).thenReturn(listResponse);
		Mockito.when(userRepository.findByEmailAndIsActive(Mockito.anyString(), Mockito.anyBoolean()))
				.thenReturn(Optional.of(responseSave));
		Mockito.when(userRepository.save(Mockito.any())).thenReturn(responseSave);
	}

	@Test
	public void findAllOK() {
		List<UserRS> response = userService.findAllUsers();
		assertNotNull("find all user ok" , response);
	}
	
	@Test
	public void findAllEmpty() {
		Mockito.when(userRepository.findByIsActive(Boolean.TRUE)).thenReturn(new ArrayList<>());
		List<UserRS> response = userService.findAllUsers();
		assertTrue(response.isEmpty());
	}

	@Test
	public void createUserTest() {
		UserRS response = userService.creatreUser(objRq);
		assertEquals(TEST_TOKEN, response.getToken());
	}

	@Test
	public void updateUserTest() {
		responseSave.setUpdateDate(LocalDateTime.now());
		UserRS response = userService.updateUser(objRq);
		assertNotNull("user update ok ", response.getUpdateDate());
	}

	@Test
	public void deleteUserTest() {
		responseSave.setIsActive(Boolean.FALSE);
		UserRS response = userService.deleteUser(objRq);
		assertFalse("user delete ok ", response.getIsActive());
	}

	@Test
	public void getUserByEmailOK() {
		UserRS response = userService.getUserByEmail(objRq.getEmail());
		assertNotNull("user found ", response);
	}

	@Test
	public void getUserByEmailNotFound() {
		Mockito.when(userRepository.findByEmailAndIsActive(Mockito.anyString(), Mockito.anyBoolean()))
				.thenReturn(Optional.empty());
		UserRS response = userService.getUserByEmail(objRq.getEmail());
		assertNull("user not found ", response);
	}

}
