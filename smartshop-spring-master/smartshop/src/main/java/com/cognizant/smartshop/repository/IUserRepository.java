package com.cognizant.smartshop.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.smartshop.model.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Long>{

	@Query(value="SELECT u.user_id, u.first_name, u.last_name, u.age, "
			+" u.gender, u.contact_number, u.password, "
			+" u.status, u.sec_question, u.sec_answer FROM user u WHERE u.user_id in (SELECT ur.ur_us_id FROM user_role ur WHERE ur.ur_ro_id=2);"
			, nativeQuery=true)
	public List<User> getAllManagers();
	
	@Query(value="SELECT u.user_id, u.first_name, u.last_name, u.age, "
			+" u.gender, u.contact_number, u.password, "
			+" u.status, u.sec_question, u.sec_answer FROM user u WHERE u.status='p' and u.user_id in (SELECT ur.ur_us_id FROM user_role ur WHERE ur.ur_ro_id=2);"
			, nativeQuery=true)
	public List<User> getAllPending();
	
	@Query(value="SELECT u.user_id, u.first_name, u.last_name, u.age, "
			+" u.gender, u.contact_number, u.password, "
			+" u.status, u.sec_question, u.sec_answer FROM user u WHERE u.status='a' and u.user_id in (SELECT ur.ur_us_id FROM user_role ur WHERE ur.ur_ro_id=2);"
			, nativeQuery=true)
	public List<User> getAllApproved();
	
	@Query(value="SELECT u.user_id, u.first_name, u.last_name, u.age, "
			+" u.gender, u.contact_number, u.password, "
			+" u.status, u.sec_question, u.sec_answer FROM user u WHERE u.user_id=?;"
			, nativeQuery=true)
	public User getByUserId(String userId);

	
	@Modifying
	@Transactional
	@Query(value="INSERT INTO user_role(ur_us_id,ur_ro_id) VALUES(?,?)",nativeQuery=true)
	public void addUserRole(String userId, int i);

	
	@Query(value="SELECT u.sec_question, u.sec_answer FROM user u WHERE u.user_id=?",nativeQuery=true)
	public String getSecurityQuestionAndAnswer(String userId);

	
	@Modifying
	@Transactional
	@Query(value="UPDATE user SET password=? WHERE user_id=?",nativeQuery=true)
	public void setNewPassword(String newPassword, String userId);

}

