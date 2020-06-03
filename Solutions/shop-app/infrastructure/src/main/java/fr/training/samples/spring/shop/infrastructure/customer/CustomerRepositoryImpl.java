/*
 *
 *  *
 *  *  *
 *  *  *  * Copyright 2019-2020 the original author or authors.
 *  *  *  *
 *  *  *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  *  *  * you may not use this file except in compliance with the License.
 *  *  *  * You may obtain a copy of the License at
 *  *  *  *
 *  *  *  *      https://www.apache.org/licenses/LICENSE-2.0
 *  *  *  *
 *  *  *  * Unless required by applicable law or agreed to in writing, software
 *  *  *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  *  *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  *  *  * See the License for the specific language governing permissions and
 *  *  *  * limitations under the License.
 *  *  *
 *  *
 *
 *
 */

package fr.training.samples.spring.shop.infrastructure.customer;

import javax.persistence.EntityManager;

import fr.training.samples.spring.shop.domain.common.exception.NotFoundException;
import fr.training.samples.spring.shop.domain.customer.CustomerEntity;
import fr.training.samples.spring.shop.domain.customer.CustomerRepository;

import org.springframework.stereotype.Repository;

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
