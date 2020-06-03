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

package fr.training.samples.spring.shop.application.customer;

import fr.training.samples.spring.shop.domain.customer.CustomerEntity;

/**
 * @author Badr NASS
 *
 */
public interface CustomerManagement {

    /**
     * @param customer
     * @return
     */
    CustomerEntity create(CustomerEntity customer);

    /**
     * @param customerID
     * @return
     */
	CustomerEntity findOne(String customerID);

	/**
	 * @param customerEntity
	 * @return
	 */
	CustomerEntity update(CustomerEntity customerEntity);

	void resetCache();

}
