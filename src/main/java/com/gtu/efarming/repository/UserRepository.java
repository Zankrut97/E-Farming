package com.gtu.efarming.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gtu.efarming.User.user;

@Repository
public interface UserRepository extends JpaRepository<user , Long>{

	user findOneByNameAndPassword(String name, String password);
	List<user> findByTypeAndStatus(String type,boolean status);
		user findById(long id);
		
}
