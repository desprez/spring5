package fr.training.samples.spring.shop.infrastructure.customer;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import fr.training.samples.spring.shop.domain.common.exception.NotFoundException;
import fr.training.samples.spring.shop.domain.customer.CustomerEntity;
import fr.training.samples.spring.shop.domain.customer.CustomerRepository;

/**
 * @author Badr NASS
 *
 */
@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

	/**
	 * customerDataJpaRepository of type CustomerDataJpaRepository
	 */
	private final transient CustomerDataJpaRepository customerDataJpaRepository;

	/**
	 * The EntityManager
	 */
	private final transient EntityManager entityManager;

	/**
	 * @param customerDataJpaRepository
	 */
	public CustomerRepositoryImpl(CustomerDataJpaRepository customerDataJpaRepository, EntityManager entityManager) {
		super();
		this.customerDataJpaRepository = customerDataJpaRepository;
		this.entityManager = entityManager;
	}


	@Override
	public CustomerEntity create(final CustomerEntity customer) {
		entityManager.persist(customer);
		return customer;
	}

	@Override
	public CustomerEntity findOne(final String customerID) {
		return customerDataJpaRepository.findById(customerID)
				.orElseThrow(() -> new NotFoundException("Customer with id:" + customerID + ", not found"));
	}

	@Override
	public CustomerEntity update(CustomerEntity customerEntity) {
		return customerDataJpaRepository.save(customerEntity);
	}

}
