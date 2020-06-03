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

import java.io.Serializable;
import java.util.Set;

/**
 * @author Badr NASS
 *
 */
class OrderLightDTO implements Serializable {

    /**
     * serialVersionUID of type long
     */
    private static final long serialVersionUID = 1L;


    /**
     * customerID of type String
     */
    private String customerID;

    /**
	 * items of type Set of ItemDTO
	 */
	private Set<String> items;

    /**
     * 
     */
    public OrderLightDTO() {
    }


    /**
     * @return
     */
    public String getCustomerID() {
        return customerID;
    }


	public Set<String> getItems() {
		return items;
	}

	public void setItems(Set<String> items) {
		this.items = items;
	}


	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

}
