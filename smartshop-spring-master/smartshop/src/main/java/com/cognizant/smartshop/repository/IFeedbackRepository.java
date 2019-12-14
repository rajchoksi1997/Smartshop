package com.cognizant.smartshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.smartshop.model.UserFeedback;

@Repository
public interface IFeedbackRepository extends JpaRepository<UserFeedback, Integer>{

	@Query(value="SELECT question FROM feedback",nativeQuery=true)
	public List<String> getAllQuestions();

	
}
