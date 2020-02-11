package com.test.springbootmicroservice.hibernate.onetomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Version;

@Entity
public class Customer2 {

	@Id
	@GeneratedValue
	private long id;
	@Version
	private int version;
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "customer2")
	private List<Address2> addresses = new ArrayList<>();
	
	
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
	public List<Address2> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<Address2> addresses) {
		this.addresses = addresses;
	}
	
}
