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

import javax.validation.Valid;

import fr.training.samples.spring.shop.common.AbstractMapper;
import fr.training.samples.spring.shop.domain.customer.CustomerEntity;
import fr.training.samples.spring.shop.domain.customer.CustomerVO;

import org.springframework.stereotype.Component;

/**
 * Mapper for the entity CustomeEntity and its DTO CustomeDTO.
 */
/**
 * @author Badr NASS
 *
 */

@Component
public class CustomerMapper extends AbstractMapper<CustomerDTO, CustomerEntity> {

	@Override
	public CustomerDTO mapToDto(CustomerEntity entity) {
		CustomerDTO customerDTO = new CustomerDTO();
		customerDTO.setCustomerID(entity.getId());
		if (entity.getCustomerVO() != null) {
			customerDTO.setName(entity.getCustomerVO().getName());
			customerDTO.setPassword(entity.getCustomerVO().getPassword());
		}
		return customerDTO;
	}

	@Override
	public CustomerEntity mapToEntity(CustomerDTO dto) {
		CustomerEntity customerEntity = new CustomerEntity();
		CustomerVO customerVO = new CustomerVO(dto.getName(), dto.getPassword());
		customerEntity.setCustomerVO(customerVO);
		customerEntity.setId(dto.getCustomerID());
		return customerEntity;
	}

	public CustomerEntity mapToEntity(@Valid CustomerLightDTO customerLightDTO) {
		CustomerEntity customerEntity = new CustomerEntity();
		CustomerVO customerVO = new CustomerVO(customerLightDTO.getName(), customerLightDTO.getPassword());
		customerEntity.setCustomerVO(customerVO);
		return customerEntity;
	}
}