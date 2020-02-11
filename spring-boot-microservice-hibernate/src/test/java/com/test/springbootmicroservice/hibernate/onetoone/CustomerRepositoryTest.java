package com.test.springbootmicroservice.hibernate.onetoone;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
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
	private TestEntityManager entityManager;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Before
	public void setup() {
		Customer customer = new Customer();
		customer.setName("john");
		
		this.entityManager.persist(customer);
	}
	
	@Test
	public void testFindByName() {
		
		Customer existingCustomer = customerRepository.findByName("john");
		Assert.assertNotNull(existingCustomer);
		
		existingCustomer = customerRepository.findByName("john wick");
		Assert.assertNull(existingCustomer);
	}

}
