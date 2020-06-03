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

import fr.training.samples.spring.shop.domain.order.OrderEntity;

/**
 * @author Badr NASS
 *
 */
public interface OrderManagement {

    /**
     * @param order
     * @return
     */
    OrderEntity addOrder(OrderEntity order);

    /**
     * @param orderID
     * @return
     */
    OrderEntity findOne(String orderID);

    /**
     * @param customerID
     * @return
     */
	Set<OrderEntity> getOrdersForCustomer(String customerID);
	
	void addOrders(List<OrderEntity> orders);

}
