package com.test.springbootmicroservice.hibernate.onetoone.bidirectional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Customer1Repository extends JpaRepository<Customer1, Long> {
	
	Customer1 findByName(String name);
}