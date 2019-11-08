package fr.training.samples.spring.shop.exposition.customer.rest;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import fr.training.samples.spring.shop.application.customer.CustomerManagement;
import fr.training.samples.spring.shop.domain.customer.CustomerEntity;

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
	 * @param customerDTO
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

}
