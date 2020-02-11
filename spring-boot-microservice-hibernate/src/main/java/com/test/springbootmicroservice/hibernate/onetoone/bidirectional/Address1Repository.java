package com.test.springbootmicroservice.hibernate.onetoone.bidirectional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Address1Repository extends JpaRepository<Address1, Long> {
	
}