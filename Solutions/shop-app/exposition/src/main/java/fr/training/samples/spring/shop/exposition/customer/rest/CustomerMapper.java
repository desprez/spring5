package fr.training.samples.spring.shop.exposition.customer.rest;

import javax.validation.Valid;

import org.springframework.stereotype.Component;

import fr.training.samples.spring.shop.common.AbstractMapper;
import fr.training.samples.spring.shop.domain.customer.CustomerEntity;
import fr.training.samples.spring.shop.domain.customer.CustomerVO;

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