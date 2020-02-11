package com.test.springbootmicroservice.hibernate.onetomany;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Address2Repository extends JpaRepository<Address2, Long> {
	
}