package com.gtu.efarming.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gtu.efarming.User.CropDemand;

@Repository
public interface CropDemandRepository extends JpaRepository<CropDemand , Long>{
	
	List<CropDemand> findAll();
	
	CropDemand findByProductName(String cropName);

	@Query("select f from CropDemand f where f.Product.soilType = :soilType")
	List<CropDemand> findBySoilType(@Param("soilType") String soilType);
	
}
