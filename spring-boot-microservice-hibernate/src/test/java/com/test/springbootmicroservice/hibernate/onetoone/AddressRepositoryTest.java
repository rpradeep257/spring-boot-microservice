package com.test.springbootmicroservice.hibernate.onetoone;

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
public class AddressRepositoryTest {

	@Autowired
	private AddressRepository addressRepository;
	
	
	@Test
	public void testFindByName() {
		
		Address a = new Address();
		a.setAddress("UK");
		
		addressRepository.save(a);
	}

}
