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

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fr.training.samples.spring.shop.domain.customer.CustomerEntity;
import fr.training.samples.spring.shop.domain.customer.CustomerRepository;
import fr.training.samples.spring.shop.domain.customer.CustomerVO;
import fr.training.samples.spring.shop.domain.item.ItemEntity;
import fr.training.samples.spring.shop.domain.item.ItemRepository;
import fr.training.samples.spring.shop.domain.item.ItemVO;
import fr.training.samples.spring.shop.domain.order.OrderEntity;
import fr.training.samples.spring.shop.domain.order.OrderRepository;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

/**
 * @author Badr NASS
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class OrderServiceImplTest {

	/**
	 * orderManagement of type OrderManagement
	 */
	@Autowired
	private transient OrderManagement orderManagement;

	/**
	 * orderRepository of type OrderRepository
	 */
	@MockBean
	private transient OrderRepository orderRepository;

	/**
	 * customerRepository of type CustomerRepository
	 */
	@MockBean
	private transient CustomerRepository customerRepository;

	/**
	 * itemRepository of type ItemRepository
	 */
	@MockBean
	private transient ItemRepository itemRepository;

	/**
	 * 
	 */
	@Test
	public void testAddOrder() {
		final OrderEntity orderEntity = this.createOrder("NASS", "123456", "DESC99", 99);
		Set<ItemEntity> itemEntities = orderEntity.getItems();
		Set<String> itemIds = itemEntities.stream().map(ItemEntity::getId).collect(Collectors.toSet());
		when(itemRepository.getAllItems(itemIds)).thenReturn(itemEntities);
		when(orderRepository.addOrder(orderEntity)).thenReturn(orderEntity);
		final OrderEntity orderResult = orderManagement.addOrder(orderEntity);
		assertNotNull(orderResult);
	}

	/**
	 *
	 */
	@Test
	public void testGetOrdersForCustomer() {
		final OrderEntity orderEntity1 = this.createOrder("NASS", "123456", "DESC99", 99);
		final OrderEntity orderEntity2 = this.createOrder("NASS", "123456", "DESC99", 99);
		final Set<OrderEntity> orders = Stream.of(orderEntity1, orderEntity2).collect(Collectors.toSet());
		when(orderRepository.getOrdersForCustomer("123e4567-e89b-42d3-a456-556642440000")).thenReturn(orders);
		final Set<OrderEntity> ordersResult = orderManagement
				.getOrdersForCustomer("123e4567-e89b-42d3-a456-556642440000");
		assertNotNull(ordersResult);
		assertEquals(2, ordersResult.size());
	}

	/**
	 * @param customerName
	 * @param customerPass
	 * @param itemDesc
	 * @param price
	 * @return
	 */
	private OrderEntity createOrder(final String customerName, final String customerPass, final String itemDesc,
			final int price) {
		final CustomerEntity customer = new CustomerEntity(new CustomerVO("nass", "123456"));
		final ItemEntity itemEntity = new ItemEntity(new ItemVO("DESC99", 99));
		final OrderEntity orderEntity = new OrderEntity();
		orderEntity.setCustomer(customer);
		orderEntity.setItems(Stream.of(itemEntity).collect(Collectors.toSet()));
		return orderEntity;
	}

}
