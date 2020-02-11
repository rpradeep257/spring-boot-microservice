package com.test.springbootmicroservice.hibernate.onetoone.bidirectional;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Version;

@Entity
public class Customer1 {

	@Id
	@GeneratedValue
	private long id;
	@Version
	private int version;
	private String name;
	
	@OneToOne
	@JoinColumn(name = "address_id")
	private Address1 address;
	
	
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address1 getAddress() {
		return address;
	}
	public void setAddress(Address1 address) {
		this.address = address;
	}
	
}
