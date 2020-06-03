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
import java.util.HashSet;
import java.util.Set;

import fr.training.samples.spring.shop.exposition.item.rest.ItemDTO;

/**
 * @author Badr NASS
 *
 */
class OrderDTO implements Serializable {

    /**
     * serialVersionUID of type long
     */
    private static final long serialVersionUID = 1L;

    /**
     * orderID of type String
     */
    private String orderID;

    /**
     * customerID of type String
     */
    private String customerID;

    /**
	 * items of type Set of ItemDTO
	 */
	private Set<ItemDTO> items;

    /**
     * 
     */
    public OrderDTO() {
    }

    /**
     * @param orderID
     * @param customerID
     */
    public OrderDTO(final String orderID, final String customerID) {
        this.orderID = orderID;
        this.customerID = customerID;
		items = new HashSet<>();
    }

    /**
     * @param itemDTO
     */
    public void addItem(final ItemDTO itemDTO) {
        items.add(itemDTO);
    }

    /**
     * @return
     */
    public String getCustomerID() {
        return customerID;
    }

    /**
     * @return
     */
	public Set<ItemDTO> getItems() {
        return items;
    }

    /**
     * @return
     */
    public String getOrderID() {
        return orderID;
    }

    /**
     * @param customerID
     */
    public void setCustomerID(final String customerID) {
        this.customerID = customerID;
    }

    /**
     * @param items
     */
	public void setItems(final Set<ItemDTO> items) {
        this.items = items;
    }

    /**
     * @param orderID
     */
    public void setOrderID(final String orderID) {
        this.orderID = orderID;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("OrderDTO [orderID=");
        builder.append(orderID);
        builder.append(", customerID=");
        builder.append(customerID);
        builder.append(", items=");
        builder.append(items);
        builder.append("]");
        return builder.toString();
    }

}
