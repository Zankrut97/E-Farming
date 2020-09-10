package com.gtu.efarming.repository;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gtu.efarming.User.FarmerCropRegistration;

@Repository
public interface CropRegisterRepository extends JpaRepository<FarmerCropRegistration , Long> {
	
	@Query(" select f from  FarmerCropRegistration f where f.user.id = :id ")
	List<FarmerCropRegistration> findByUserId(@Param("id") Long id);

	@Query(" select f from FarmerCropRegistration f where :now >= f.startDate and :now <= f.endDate")
	List<FarmerCropRegistration> findAllLiveBids(@Param("now") ZonedDateTime now);
	
	@Query(" select f from  FarmerCropRegistration f where f.user.id = :id and f.endDate <= :now")
	List<FarmerCropRegistration> findByIdAndDate(@Param("id") Long id,@Param("now") ZonedDateTime now);
	
	@Query(" select f from FarmerCropRegistration f where :now <= f.startDate")
	List<FarmerCropRegistration> findAllBids(@Param("now") ZonedDateTime now);
	
	FarmerCropRegistration findById(int id);
	
	@Query(" select f from  FarmerCropRegistration f where f.vendorUser.id = :id ")
	List<FarmerCropRegistration> findByVendorId(@Param("id") Long id);
	
	
}
