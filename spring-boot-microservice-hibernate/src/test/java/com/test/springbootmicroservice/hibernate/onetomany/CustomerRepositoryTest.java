package com.test.springbootmicroservice.hibernate.onetomany;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@EnableTransactionManagement
@ActiveProfiles("test")
public class CustomerRepositoryTest {

	@Autowired
	private Customer2Repository customerRepository;
	
	@Test
	public void testSave() {
		
		Address2 address = new Address2();
		address.setAddress("UK");
		
		Customer2 customer2 = new Customer2();
		customer2.setName("John");
		customer2.getAddresses().add(address);
		
		this.customerRepository.save(customer2);
		this.customerRepository.findByName("test");
		
		
	}

}
