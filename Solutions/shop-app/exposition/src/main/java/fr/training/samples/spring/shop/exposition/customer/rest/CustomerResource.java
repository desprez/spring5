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

package fr.training.samples.spring.shop.exposition.customer.rest;

import java.net.URI;

import javax.management.timer.Timer;
import javax.validation.Valid;

import fr.training.samples.spring.shop.application.customer.CustomerManagement;
import fr.training.samples.spring.shop.config.Constants;
import fr.training.samples.spring.shop.domain.customer.CustomerEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 * @author Badr NASS
 *
 */
@RestController
@RequestMapping("/api")
public class CustomerResource {

	/**
	 * customeEntityMapper of type CustomerMapper
	 */
	private final CustomerMapper customeEntityMapper;

	/**
	 * customerManagement of type CustomerManagement
	 */
	private final CustomerManagement customerManagement;

	/**
	 * logger of type Logger
	 */
	private static final Logger LOG = LoggerFactory.getLogger(CustomerResource.class);

	/**
	 * @param customerID
	 * @return
	 */
	@GetMapping("/customers/{customerID}")
	public CustomerDTO getCustomer(@PathVariable final String customerID) {
		final CustomerEntity customerEntity = customerManagement.findOne(customerID);
		return customeEntityMapper.mapToDto(customerEntity);
	}

	/**
	 * @param customeEntityMapper
	 * @param customerManagement
	 */
	public CustomerResource(CustomerMapper customeEntityMapper,
			CustomerManagement customerManagement) {
		super();
		this.customeEntityMapper = customeEntityMapper;
		this.customerManagement = customerManagement;
	}

	/**
	 * @param customerLightDTO
	 * @return
	 */
	@PostMapping("/customers")
	public ResponseEntity<URI> addCustomer(
			@Valid @RequestBody final CustomerLightDTO customerLightDTO) {
		final CustomerEntity customerEntity = customeEntityMapper
				.mapToEntity(customerLightDTO);
		customerManagement.create(customerEntity);
		final URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(customerEntity.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

	/**
	 * @param customerDTO
	 * @return
	 */
	@PutMapping("/customers")
	public ResponseEntity<URI> updateCustomer(@Valid @RequestBody final CustomerDTO customerDTO) {
		final CustomerEntity customerEntity = customeEntityMapper.mapToEntity(customerDTO);
		customerManagement.update(customerEntity);
		final URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(customerEntity.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

	@Scheduled(fixedRate = Timer.ONE_HOUR)
	private void refreshSpecialCustomerCache(){
		LOG.info("cache refresh called every xxx");
		customerManagement.resetCache();
		customerManagement.findOne(Constants.SPECIAL_CUSTOMER_NUMBER);
	}
}
