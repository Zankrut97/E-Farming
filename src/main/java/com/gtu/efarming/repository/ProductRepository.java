package com.gtu.efarming.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gtu.efarming.User.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product , Long>{
	
	
	List<Product> findAll();
	
	List<Product> findBySoilType(String soilType);
	
	Product findByProductName(String cropName);
}
