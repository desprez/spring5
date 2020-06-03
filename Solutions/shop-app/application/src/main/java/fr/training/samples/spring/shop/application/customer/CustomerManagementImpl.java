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

package fr.training.samples.spring.shop.application.customer;

import fr.training.samples.spring.shop.domain.customer.CustomerEntity;
import fr.training.samples.spring.shop.domain.customer.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

	private static final Logger LOG = LoggerFactory.getLogger(CustomerManagementImpl.class);

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
	@Cacheable(value="customerCache", condition="#customerID.equals(T(fr.training.samples.spring.shop.config.Constants).SPECIAL_CUSTOMER_NUMBER)")
	public CustomerEntity findOne(final String customerID) {
		LOG.info("calling findOne without cache for customerID {}", customerID);
		return customerRepository.findOne(customerID);
	}

	@CacheEvict(value = "customerCache", allEntries = true)
	public void resetCache(){ }

	@Override
	public CustomerEntity update(CustomerEntity customerEntity) {
		return customerRepository.update(customerEntity);
	}
}
