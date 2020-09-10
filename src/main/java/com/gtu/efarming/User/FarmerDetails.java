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
@Table(name="farmerdetails")

public class FarmerDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	 @OneToOne
	 @JoinColumn(name = "user_id")
	 private user user;
	
	@Column(name="relationship")
	private String relationship;
	
	@Column(name="relname")
	private String relname;
	
	
	@Column(name="caste")
	private String caste;
	
	
	@Column(name="ftype")
	private String ftype;
	
	
	@Column(name="vfno")
	private String vfno;
	
	

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

	
	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public String getRelname() {
		return relname;
	}

	public void setRelname(String relname) {
		this.relname = relname;
	}

	
	public String getCaste() {
		return caste;
	}

	public void setCaste(String caste) {
		this.caste = caste;
	}

	
	public String getFtype() {
		return ftype;
	}

	public void setFtype(String ftype) {
		this.ftype = ftype;
	}

		public String getVfno() {
		return vfno;
	}

	public void setVfno(String vfno) {
		this.vfno = vfno;
	}

		
}
