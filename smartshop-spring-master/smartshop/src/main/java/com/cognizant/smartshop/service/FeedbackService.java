package com.cognizant.smartshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.smartshop.model.UserFeedback;
import com.cognizant.smartshop.repository.IFeedbackRepository;

@Service
public class FeedbackService {

	@Autowired
	private IFeedbackRepository feedbackRepository;

	public List<String> getAllQuestions() {
		return feedbackRepository.getAllQuestions();
	}

	public void saveFeedback(UserFeedback userFeedback) {
		feedbackRepository.save(userFeedback);
	}
	
}
