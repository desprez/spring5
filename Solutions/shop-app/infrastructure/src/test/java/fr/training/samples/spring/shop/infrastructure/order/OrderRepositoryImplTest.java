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

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fr.training.samples.spring.shop.domain.customer.CustomerEntity;
import fr.training.samples.spring.shop.domain.customer.CustomerRepository;
import fr.training.samples.spring.shop.domain.item.ItemEntity;
import fr.training.samples.spring.shop.domain.item.ItemRepository;
import fr.training.samples.spring.shop.domain.order.OrderEntity;
import fr.training.samples.spring.shop.domain.order.OrderRepository;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author Badr NASS
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class OrderRepositoryImplTest {

    /**
     * orderRepository of type OrderRepository
     */
    @Autowired
    private transient OrderRepository orderRepository;

    /**
     * itemRepository of type ItemRepository
     */
    @Autowired
    private transient ItemRepository itemRepository;

    /**
     * customerRepository of type CustomerRepository
     */
    @Autowired
    private transient CustomerRepository customerRepository;
    

    /**
     * @param customerId
     * @param itemId
     * @param price
     * @return
     */
    private OrderEntity createOrder(final String customerId, final String itemId, final int price) {
        final CustomerEntity customer = customerRepository.findOne(customerId);
        final ItemEntity itemEntity = itemRepository.findOne(itemId);
        final OrderEntity orderEntity = new OrderEntity();
        orderEntity.setCustomer(customer);
		orderEntity.setItems(new HashSet<ItemEntity>(Arrays.asList(itemEntity)));
		return orderEntity;
    }

    /**
     * 
     */
    @Test
    public void testAddOrder() {
		final OrderEntity orderEntity = this.createOrder("123e4567-e89b-42d3-a456-556642440000",
				"123e4567-e89b-42d3-a456-556642440001", 99);
        orderRepository.addOrder(orderEntity);
        assertNotNull(orderEntity.getId());
    }

    /**
     * 
     */
    @Test
    public void testAddOrders() {
		final OrderEntity orderEntity1 = this.createOrder("123e4567-e89b-42d3-a456-556642440000",
				"123e4567-e89b-42d3-a456-556642440001", 99);
		final OrderEntity orderEntity2 = this.createOrder("123e4567-e89b-42d3-a456-556642440000",
				"123e4567-e89b-42d3-a456-556642440002", 99);
        final List<OrderEntity> orders = Stream.of(orderEntity1, orderEntity2).collect(Collectors.toList());
        orderRepository.addOrders(orders);
        assertNotNull(orderEntity1.getId());
        assertNotNull(orderEntity2.getId());
    }

    /**
     * 
     */
    @Test
    public void testGetOrdersForCustomer() {
		final Set<OrderEntity> orders = orderRepository.getOrdersForCustomer("123e4567-e89b-42d3-a456-556642440000");
		assertNotNull(orders);
        assertEquals(2, orders.size());
    }

}
