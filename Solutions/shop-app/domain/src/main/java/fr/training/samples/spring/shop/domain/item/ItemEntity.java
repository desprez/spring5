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

package fr.training.samples.spring.shop.domain.item;

import java.util.Set;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.Valid;

import fr.training.samples.spring.shop.domain.common.entity.AbstractBaseEntity;
import fr.training.samples.spring.shop.domain.order.OrderEntity;

/**
 * @author Badr NASS
 *
 */
@Entity
@Table(name = "ITEM")
public class ItemEntity extends AbstractBaseEntity {

    /**
     * itemVO of type ItemVO
     */
    @Valid
	@Embedded
    private ItemVO itemVO;

    /**
	 * orders of type Set<OrderEntity>
	 */
	@ManyToMany(mappedBy = "items")
	private Set<OrderEntity> orders;

    /**
     * 
     */
    public ItemEntity() {
        super();
    }

    /**
     * @param itemVO
     */
    public ItemEntity(final ItemVO itemVO) {
        this.itemVO = itemVO;
    }


	public ItemEntity(String id) {
		this.id = id;
	}

	/**
	 * @return
	 */
    public ItemVO getItemVO() {
        return itemVO;
    }

    /**
     * @return
     */
	public Set<OrderEntity> getOrders() {
        return orders;
    }

    /**
     * @param itemVO
     */
    public void setItemVO(final ItemVO itemVO) {
        this.itemVO = itemVO;
    }

    /**
     * @param orders
     */
	public void setOrders(final Set<OrderEntity> orders) {
        this.orders = orders;
    }
}
