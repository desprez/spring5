package fr.training.samples.spring.shop.repository.customer;

import org.springframework.stereotype.Repository;

import fr.training.samples.spring.shop.domain.common.exception.NotFoundException;
import fr.training.samples.spring.shop.domain.customer.CustomerEntity;
import fr.training.samples.spring.shop.domain.customer.CustomerRepository;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

	private CustomerRepositoryDataJPA customerRepositoryDataJPA;

	public CustomerRepositoryImpl(CustomerRepositoryDataJPA customerRepositoryDataJPA) {
		super();
		this.customerRepositoryDataJPA = customerRepositoryDataJPA;
	}

	@Override
	public CustomerEntity findOne(String id) {
		return customerRepositoryDataJPA.findById(id)
				.orElseThrow(() -> new NotFoundException("Cutomer with id not found: " + id));
	}

	@Override
	public CustomerEntity create(CustomerEntity customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerEntity update(CustomerEntity customerEntity) {
		// TODO Auto-generated method stub
		return null;
	}

}
