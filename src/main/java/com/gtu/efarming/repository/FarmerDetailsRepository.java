package com.gtu.efarming.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gtu.efarming.User.FarmerDetails;

@Repository
public interface FarmerDetailsRepository extends JpaRepository<FarmerDetails, Object> {
	
	@Query(" select f from  FarmerDetails f where f.user.type = :type and f.user.status = :status ")
	List<FarmerDetails> findByTypeAndStatus(@Param("type") String type,@Param("status")boolean status);

}
