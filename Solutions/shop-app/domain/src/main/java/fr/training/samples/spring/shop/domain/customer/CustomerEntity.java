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

package fr.training.samples.spring.shop.domain.customer;

import java.util.Set;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;

import fr.training.samples.spring.shop.domain.common.entity.AbstractBaseEntity;
import fr.training.samples.spring.shop.domain.order.OrderEntity;

/**
 * @author Badr NASS
 *
 */
@Entity
@Table(name = "CUSTOMER")
public class CustomerEntity extends AbstractBaseEntity {

    /**
     * customerVO of type CustomerVO
     */
    @Valid
	@Embedded
    private CustomerVO customerVO;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
	private Set<OrderEntity> orders;

    /**
     * 
     */
    public CustomerEntity() {
        super();
    }

    /**
     * @param customerVO
     */
    public CustomerEntity(final CustomerVO customerVO) {
        this.customerVO = customerVO;
    }

    /**
     * @return
     */
    public CustomerVO getCustomerVO() {
        return customerVO;
    }

    /**
     * @param customerVO
     */
    public void setCustomerVO(final CustomerVO customerVO) {
        this.customerVO = customerVO;
    }


	public Set<OrderEntity> getOrders() {
		return orders;
	}

	public void setOrders(Set<OrderEntity> orders) {
		this.orders = orders;
	}

	@Override
    public String toString() {
        return "CustomerEntity [customerVO=" + customerVO + ", toString()=" + super.toString() + "]";
    }


}