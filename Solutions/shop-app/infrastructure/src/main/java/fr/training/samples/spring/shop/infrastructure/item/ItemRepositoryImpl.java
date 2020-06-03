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

package fr.training.samples.spring.shop.infrastructure.item;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;

import fr.training.samples.spring.shop.domain.common.exception.NotFoundException;
import fr.training.samples.spring.shop.domain.item.ItemEntity;
import fr.training.samples.spring.shop.domain.item.ItemRepository;

import org.springframework.stereotype.Repository;

/**
 * @author Badr NASS
 *
 */
@Repository
public class ItemRepositoryImpl implements ItemRepository {

	/**
	 * itemDataJpaRepository of type ItemDataJpaRepository
	 */
	private final transient ItemDataJpaRepository itemDataJpaRepository;


	/**
	 * the EntityManager
	 */
	private final transient EntityManager entityManager;


	public ItemRepositoryImpl(ItemDataJpaRepository itemDataJpaRepository, EntityManager entityManager) {
		super();
		this.itemDataJpaRepository = itemDataJpaRepository;
		this.entityManager = entityManager;
	}

	@Override
	public ItemEntity addItem(final ItemEntity item) {
		entityManager.persist(item);
		return item;
	}


	@Override
	public ItemEntity findOne(final String itemId) {
		return itemDataJpaRepository.findById(itemId)
				.orElseThrow(() -> new NotFoundException("Item with id:" + itemId + ", not found"));
	}

	@Override
	public List<ItemEntity> getAllItems() {
		return itemDataJpaRepository.findAll();
	}

	@Override
	public Set<ItemEntity> getAllItems(final Set<String> itemsId) {
		return itemDataJpaRepository.findByIdIn(itemsId);
	}

}
