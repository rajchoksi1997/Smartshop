package com.cognizant.mockito.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import com.cognizant.smartshop.model.Role;
import com.cognizant.smartshop.model.User;
import com.cognizant.smartshop.repository.IUserRepository;
import com.cognizant.smartshop.service.UserService;

public class TestUser {

	@Mock
	private IUserRepository userRepository;

	@InjectMocks
	private UserService userService;

	User user = new User();
	List<User> users = new ArrayList<>();
	Set<User> userList = new HashSet<User>();
	
	Role role = new Role();
	Set<Role> userType = new HashSet<Role>();

	@Rule
	public MockitoRule rule = MockitoJUnit.rule();

	@Test
	public void getAllUserTest() {
		user.setUserId("U001");
		user.setAge(20);
		user.setContactNumber("96787");
		user.setFirstName("firstName");
		user.setGender("gender");
		user.setLastName("lastName");
		user.setPassword("password");
		user.setSecAnswer("secAnswer");
		user.setSecQuestion("secQuestion");
		user.setStatus('A');
		
		role.setId(1);
		role.setName("ROLE_MANAGER");
		role.setUserList(userList);
		
		user.setUserType(userType);

		users.add(user);

		when(userRepository.findAll()).thenReturn(users);
		assertEquals(users, userService.getAllUsers());
	}
	

}
