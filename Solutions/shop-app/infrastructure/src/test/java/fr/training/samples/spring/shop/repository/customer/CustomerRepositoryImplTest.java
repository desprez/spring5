package fr.training.samples.spring.shop.repository.customer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.training.samples.spring.shop.domain.customer.CustomerEntity;
import fr.training.samples.spring.shop.domain.customer.CustomerRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class CustomerRepositoryImplTest {

	@Autowired
	private CustomerRepository customerRepository;

	@Test
	public void testFindOne() {
		CustomerEntity customerEntity = customerRepository.findOne("123e4567-e89b-42d3-a456-556642440000");
		assertNotNull(customerEntity);
		assertEquals("NAME1", customerEntity.getCustomerVO().getName());
		assertEquals("PASS1", customerEntity.getCustomerVO().getPassword());
	}

	@Test
	public void testCreate() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

}
