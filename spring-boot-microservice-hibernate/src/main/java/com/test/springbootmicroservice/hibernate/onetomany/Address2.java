package com.test.springbootmicroservice.hibernate.onetomany;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

@Entity
public class Address2 {
	
	@Id
	@GeneratedValue
	private long id;
	@Version
	private int version;
	private String address;
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer2 customer2;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	

}
