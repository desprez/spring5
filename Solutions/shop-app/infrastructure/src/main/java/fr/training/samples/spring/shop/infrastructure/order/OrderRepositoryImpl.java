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

package fr.training.samples.spring.shop.infrastructure.order;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;

import fr.training.samples.spring.shop.domain.common.exception.NotFoundException;
import fr.training.samples.spring.shop.domain.order.OrderEntity;
import fr.training.samples.spring.shop.domain.order.OrderRepository;

import org.springframework.stereotype.Repository;

/**
 * @author Badr NASS
 *
 */
@Repository
public class OrderRepositoryImpl implements OrderRepository {

	/**
	 * orderDataJpaRepository of type OrderDataJpaRepository
	 */
	private final transient OrderDataJpaRepository orderDataJpaRepository;

	/**
	 * The EntityManager
	 */
	private final transient EntityManager entityManager;

	/**
	 * @param orderDataJpaRepository
	 */
	public OrderRepositoryImpl(OrderDataJpaRepository orderDataJpaRepository, EntityManager entityManager) {
		super();
		this.orderDataJpaRepository = orderDataJpaRepository;
		this.entityManager = entityManager;
	}

	@Override
	public OrderEntity addOrder(final OrderEntity orderEntity) {
		entityManager.persist(orderEntity);
		return orderEntity;
	}

	@Override
	public void addOrders(final List<OrderEntity> orders) {
		orderDataJpaRepository.saveAll(orders);
	}

	@Override
	public OrderEntity findOne(final String orderID) {
		return orderDataJpaRepository.findById(orderID)
				.orElseThrow(() -> new NotFoundException("Order with id:" + orderID + ", not found"));
	}

	@Override
	public Set<OrderEntity> getOrdersForCustomer(final String id) {
		return orderDataJpaRepository.getOrdersForCustomer(id);
	}
}
