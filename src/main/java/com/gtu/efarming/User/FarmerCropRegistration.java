package com.gtu.efarming.User;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="farmercropdetail")

public class FarmerCropRegistration {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "farmer_id")
	private user user;
	
	@OneToOne
	@JoinColumn(name = "vendor_id")
	private user vendorUser;
	
	public user getVendorUser() {
		return vendorUser;
	}

	public void setVendorUser(user vendorUser) {
		this.vendorUser = vendorUser;
	}

	@Column(name="cropName")
	private String cropName;
	
	@Column(name="cropType")
	private String cropType;
	
	@Column(name="basePrice")
	private int basePrice;
	
	@Column(name="currentPrice")
	private long currentPrice;
	
	@Column(name="weight")
	private String weight;
	
	public long getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(long currentPrice) {
		this.currentPrice = currentPrice;
	}

	@Column(name="startDate")
	private ZonedDateTime startDate;
	
	
	
	@Column(name="endDate")
	private ZonedDateTime endDate;
	
	
	@Column(name="selectCountry")
	private String selectCountry;
	
	@Column(name="selectState")
	private String selectState;
	
	@Column(name="selectDistrict")
	private String selectDistrict;
	
	@Column(name="description")
	private String description;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCropName() {
		return cropName;
	}

	public void setCropName(String cropName) {
		this.cropName = cropName;
	}

	public String getCropType() {
		return cropType;
	}

	public void setCropType(String cropType) {
		this.cropType = cropType;
	}

	public int getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(int basePrice) {
		this.basePrice = basePrice;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public ZonedDateTime getStartDate() {
			return startDate;
		}

		public void setStartDate(ZonedDateTime startDate) {
			this.startDate = startDate;
		}

		public ZonedDateTime getEndDate() {
			return endDate;
		}

		public void setEndDate(ZonedDateTime endDate) {
			this.endDate = endDate;
		}

	
	public String getSelectCountry() {
		return selectCountry;
	}

	public void setSelectCountry(String selectCountry) {
		this.selectCountry = selectCountry;
	}

	public String getSelectState() {
		return selectState;
	}

	public void setSelectState(String selectState) {
		this.selectState = selectState;
	}

	public String getSelectDistrict() {
		return selectDistrict;
	}

	public void setSelectDistrict(String selectDistrict) {
		this.selectDistrict = selectDistrict;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public user getUser() {
		return user;
	}

	public void setUser(user user) {
		this.user = user;
	}

	
	
}
