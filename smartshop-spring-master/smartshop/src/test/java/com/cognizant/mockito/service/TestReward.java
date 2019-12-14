package com.cognizant.mockito.service;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import static org.mockito.Mockito.when;
import org.junit.Rule;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import com.cognizant.smartshop.repository.IRewardRepository;
import com.cognizant.smartshop.service.RewardService;

public class TestReward {

	@Mock
	private IRewardRepository rewardRepository;

	@InjectMocks
	private RewardService rewardService;

	@Rule
	public MockitoRule rule = MockitoJUnit.rule();

	@Test
	public void getRewardPointsTest() {
		int testVariable = 195;
		when(rewardRepository.getRewardPoints("U001")).thenReturn(testVariable);
		assertEquals(testVariable, rewardService.getRewardPoints("U001"));
	}
	
/*	@Test
	public void updateRewardPointsTest(){
		int testVariable = 200;
		when(rewardRepository.updateRewardPoints("U002", testVariable, testVariable)).thenReturn();
	}*/

}
