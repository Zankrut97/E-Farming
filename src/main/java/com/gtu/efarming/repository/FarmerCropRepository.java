package com.gtu.efarming.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gtu.efarming.User.CropRegister;

@Repository
public interface FarmerCropRepository extends JpaRepository<CropRegister,Long> {
	

}
