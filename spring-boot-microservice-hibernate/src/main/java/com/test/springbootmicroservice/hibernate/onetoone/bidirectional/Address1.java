package com.test.springbootmicroservice.hibernate.onetoone.bidirectional;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Version;

@Entity
public class Address1 {
	
	@Id
	@GeneratedValue
	private long id;
	@Version
	private int version;
	private String address;
	@OneToOne(mappedBy = "address")
	private Customer1 customer;
	
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
	public Customer1 getCustomer() {
		return customer;
	}
	public void setCustomer(Customer1 customer) {
		this.customer = customer;
	}

}
