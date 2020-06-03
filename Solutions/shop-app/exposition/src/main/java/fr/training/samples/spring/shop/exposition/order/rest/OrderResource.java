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

package fr.training.samples.spring.shop.exposition.order.rest;

import java.net.URI;
import java.util.Set;

import javax.validation.Valid;

import fr.training.samples.spring.shop.application.order.OrderManagement;
import fr.training.samples.spring.shop.domain.order.OrderEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 * @author Badr NASS
 *
 */
@RestController
@RequestMapping("/api")
public class OrderResource {

	/**
	 * logger of type Logger
	 */
	private static final Logger LOG = LoggerFactory.getLogger(OrderResource.class);

	/**
	 * orderManagement of type OrderManagement
	 */
	private final OrderManagement orderManagement;

	/**
	 * orderMapper of type OrderMapper
	 */
	private final OrderMapper orderMapper;

	/**
   * @param orderManagement orderManagement
   * @param orderMapper mapper
   */
	public OrderResource(OrderManagement orderManagement, OrderMapper orderMapper) {
		super();
		this.orderManagement = orderManagement;
		this.orderMapper = orderMapper;
	}


  /**
   * @param orderDTO orderDTO
   * @return ResponseEntity of URI
   */
	@PostMapping("/orders")
	public ResponseEntity<URI> addOrder(@Valid @RequestBody final OrderLightDTO orderDTO) {
		final OrderEntity orderEntity = orderMapper.mapToEntity(orderDTO);
		orderManagement.addOrder(orderEntity);
		final URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(orderEntity.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

	/**
   * @param customerID customerID
   * @return List of OrderDTO
   */
	@GetMapping("/orders")
	public Set<OrderDTO> getOrders(@RequestParam final String customerID) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("Start some work from the scheduled task");
		}
		final Set<OrderEntity> orderEntity = orderManagement.getOrdersForCustomer(customerID);
		return orderMapper.mapToDtoSet(orderEntity);
	}

}
