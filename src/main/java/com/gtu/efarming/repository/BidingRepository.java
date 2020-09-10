package com.gtu.efarming.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gtu.efarming.User.Biding;

@Repository
public interface BidingRepository extends JpaRepository<Biding , Long>{

		
}
