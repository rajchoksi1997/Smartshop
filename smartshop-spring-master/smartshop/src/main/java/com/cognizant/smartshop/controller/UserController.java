package com.cognizant.smartshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.smartshop.model.User;
import com.cognizant.smartshop.service.AppUserDetailService;
import com.cognizant.smartshop.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService userService;
	
	
	@Autowired
	AppUserDetailService appUserDetailService;
	
	@GetMapping("/resetpassword/{userId}")
	public String[] getSecurityQuestionAndAnswer(@PathVariable String userId)
	{
		return userService.getSecurityQuestionAndAnswer(userId);
	}
	
	@PostMapping("/resetpassword/{userId}/{newPassword}")
	public boolean setNewPassword(@PathVariable String userId,@PathVariable String newPassword) {
		return userService.setNewPassword(newPassword,userId);
	}
	
	
	@GetMapping()
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@GetMapping("/{userId}")
	public boolean getByUserId(@PathVariable String userId){
		return userService.getByUserId(userId)!=null?true:false;
	}
	
	@GetMapping("/managers")
	public List<User> getAllManagers() {
		return userService.getAllManagers();
	}
	
	@GetMapping("/managers/pending")
	public List<User> getAllPending() {
		return userService.getAllPending();
	}
	
	@GetMapping("/managers/approved")
	public List<User> getAllApproved() {
		return userService.getAllApproved();
	}
	
	@GetMapping("/approved/{userId}")
	public boolean[] isApproved(@PathVariable String userId){
		return userService.isApproved(userId);
	}
	 
	@PostMapping("/{isUser}")
	public boolean addUser(@RequestBody User user, @PathVariable("isUser")boolean isUser){
		//userService.addUser(user);
		return appUserDetailService.signUp(user, isUser);
		
	}
	
	@PutMapping("/managers/{userId}")
	public void changeStatus(@PathVariable("userId") String userId) {
		userService.changeStatus(userId);
	}
	
	
	
	
}
