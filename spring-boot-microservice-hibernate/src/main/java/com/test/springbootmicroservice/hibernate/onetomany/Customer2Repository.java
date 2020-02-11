package com.test.springbootmicroservice.hibernate.onetomany;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Customer2Repository extends JpaRepository<Customer2, Long> {
	
	Customer2 findByName(String name);
}