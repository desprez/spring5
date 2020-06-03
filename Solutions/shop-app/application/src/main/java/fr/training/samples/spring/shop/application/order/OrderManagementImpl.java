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

package fr.training.samples.spring.shop.application.order;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import fr.training.samples.spring.shop.domain.common.exception.BusinessException;
import fr.training.samples.spring.shop.domain.customer.CustomerEntity;
import fr.training.samples.spring.shop.domain.customer.CustomerRepository;
import fr.training.samples.spring.shop.domain.item.ItemEntity;
import fr.training.samples.spring.shop.domain.item.ItemRepository;
import fr.training.samples.spring.shop.domain.order.OrderEntity;
import fr.training.samples.spring.shop.domain.order.OrderRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

/**
 * @author Badr NASS
 *
 */
@Service
@Transactional
public class OrderManagementImpl implements OrderManagement {

	/**
	 * orderRepository of type OrderRepository
	 */
	private final transient OrderRepository orderRepository;

	/**
	 * customerRepository of type CustomerRepository
	 */
	private final transient CustomerRepository customerRepository;

	/**
	 * itemRepository of type ItemRepository
	 */
	private final transient ItemRepository itemRepository;

	/**
	 * @param orderRepository
	 * @param customerRepository
	 * @param itemRepository
	 */
	public OrderManagementImpl(final OrderRepository orderRepository, final CustomerRepository customerRepository,
			final ItemRepository itemRepository) {

		super();
		this.orderRepository = orderRepository;
		this.customerRepository = customerRepository;
		this.itemRepository = itemRepository;
	}


	@Override
	public OrderEntity addOrder(final OrderEntity orderEntity) {
		final CustomerEntity customerEntity = customerRepository.findOne(orderEntity.getCustomer().getId());
		final Set<ItemEntity> items = itemRepository
				.getAllItems(orderEntity.getItems().stream().map(ItemEntity::getId).collect(Collectors.toSet()));
		if (CollectionUtils.isEmpty(items))
			throw new BusinessException("The order should contain at least one existing item");
		orderEntity.setCustomer(customerEntity);
		orderEntity.setItems(items);
		return orderRepository.addOrder(orderEntity);
	}

	@Override
	public OrderEntity findOne(final String orderID) {
		return orderRepository.findOne(orderID);
	}

	@Override
	public Set<OrderEntity> getOrdersForCustomer(final String customerID) {
		return orderRepository.getOrdersForCustomer(customerID);
	}

	@Override
	public void addOrders(List<OrderEntity> orders) {
		orderRepository.addOrders(orders);
	}
}
