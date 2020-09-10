package com.gtu.efarming.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gtu.efarming.User.VendorDetails;

@Repository
public interface VendorDetailsRepository extends JpaRepository<VendorDetails, Object> {

}