package com.cognizant.smartshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.smartshop.service.RewardService;

@RestController
@RequestMapping("/reward")
public class RewardController {
	
	@Autowired
	RewardService rewardService;
	
	
	@GetMapping("/{userId}")
	public int getRewardPoints(@PathVariable String userId)
	{
		return rewardService.getRewardPoints(userId);
	}
	
	@PostMapping("/{userId}/{points}")
	public void getRewardPoints(@PathVariable String userId,@PathVariable int points)
	{
		rewardService.updateRewardPoints(userId,points);
	}

}
