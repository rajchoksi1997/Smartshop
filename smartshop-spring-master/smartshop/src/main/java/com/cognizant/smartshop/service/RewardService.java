package com.cognizant.smartshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.smartshop.repository.IRewardRepository;

@Service
public class RewardService {

	@Autowired
	IRewardRepository rewardRepository;
	
	public int getRewardPoints(String userId) {
		return rewardRepository.getRewardPoints(userId);
	}

	public void updateRewardPoints(String userId,int points) {
		rewardRepository.updateRewardPoints(userId,points,points);
	}

}
