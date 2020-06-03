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

package fr.training.samples.spring.shop.application.item;

import java.util.List;

import fr.training.samples.spring.shop.domain.item.ItemEntity;
import fr.training.samples.spring.shop.domain.item.ItemRepository;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Badr NASS
 *
 */
@Service
@Transactional
public class ItemManagementImpl implements ItemManagement {

	/**
	 * itemRepository of type ItemRepository
	 */
	private final transient ItemRepository itemRepository;

	/**
	 * @param itemRepository
	 */
	public ItemManagementImpl(final ItemRepository itemRepository) {
		super();
		this.itemRepository = itemRepository;
	}

	@Override
	@CacheEvict(value = "itemCache", allEntries = true)
	public ItemEntity addItem(final ItemEntity itemEntity) {
		return itemRepository.addItem(itemEntity);
	}

	@Override
	@Cacheable("itemCache")
	public List<ItemEntity> getAllItems() {
		return itemRepository.getAllItems();
	}

}
