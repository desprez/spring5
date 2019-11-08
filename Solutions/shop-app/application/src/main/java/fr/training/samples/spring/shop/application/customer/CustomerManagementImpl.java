package fr.training.samples.spring.shop.application.customer;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.training.samples.spring.shop.domain.customer.CustomerEntity;
import fr.training.samples.spring.shop.domain.customer.CustomerRepository;

/**
 * @author Badr NASS
 *
 */
@Service
@Transactional
public class CustomerManagementImpl implements CustomerManagement {

	/**
	 * customerRepository of type CustomerRepository
	 */
	private final transient CustomerRepository customerRepository;

	/**
	 * @param customerRepository
	 */
	public CustomerManagementImpl(final CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}

	@Override
	public CustomerEntity create(final CustomerEntity customerEntity) {
		return customerRepository.create(customerEntity);
	}

	@Override
	public CustomerEntity findOne(final String customerID) {
		return customerRepository.findOne(customerID);
	}

	@Override
	public CustomerEntity update(CustomerEntity customerEntity) {
		return customerRepository.update(customerEntity);
	}
}
