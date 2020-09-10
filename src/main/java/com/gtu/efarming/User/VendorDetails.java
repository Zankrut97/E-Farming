package com.gtu.efarming.User;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="vendordetails")

public class VendorDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	 @OneToOne
	 @JoinColumn(name = "user_id")
	 private user user;

	
	@Column(name="compName")
	private String compName;
	
	@Column(name="compRegNo")
	private String compRegNo;
	
	@Column(name="compAdd")
	private String compAdd;
	
	@Column(name="vendorId")
	private String vendorId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public user getUser() {
		return user;
	}

	public void setUser(user user) {
		this.user = user;
	}

	
	public String getCompName() {
		return compName;
	}

	public void setCompName(String compName) {
		this.compName = compName;
	}

	public String getCompRegNo() {
		return compRegNo;
	}

	public void setCompRegNo(String compRegNo) {
		this.compRegNo = compRegNo;
	}

	public String getCompAdd() {
		return compAdd;
	}

	public void setCompAdd(String compAdd) {
		this.compAdd = compAdd;
	}

	public String getVendorId() {
		return vendorId;
	}

	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}
}