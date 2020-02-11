package com.test.springbootmicroservice.hibernate.onetoone.bidirectional;

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
	private Address1Repository addressRepository;
	
	@Test
	public void testFindByName() {
		
		Address1 a = new Address1();
		a.setAddress("UK");
		
		addressRepository.save(a);
	}

}
