package com.cognizant.smartshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.smartshop.model.UserFeedback;
import com.cognizant.smartshop.service.FeedbackService;

@RestController
@RequestMapping(value="/feedback")
public class FeedbackController {
	
	@Autowired
	FeedbackService feedbackService;
	
	@GetMapping()
	public List<String> getAllQuestions() {
		return feedbackService.getAllQuestions();
	}

	@PostMapping()
	public void saveFeedback(@RequestBody UserFeedback userFeedback) {
		feedbackService.saveFeedback(userFeedback);
		
	}
}
