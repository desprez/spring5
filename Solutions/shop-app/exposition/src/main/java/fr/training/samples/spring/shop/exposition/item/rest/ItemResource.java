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

package fr.training.samples.spring.shop.exposition.item.rest;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import fr.training.samples.spring.shop.application.item.ItemManagement;
import fr.training.samples.spring.shop.domain.item.ItemEntity;
import io.micrometer.core.annotation.Timed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 * @author Badr NASS
 *
 */
@RestController
@RequestMapping("/api")
public class ItemResource {

	/**
	 * itemManagement of type ItemManagement
	 */
	private transient ItemManagement itemManagement;

	/**
	 * itemMapper of type ItemMapper
	 */
	private transient final ItemMapper itemMapper;

	/**
	 * logger of type Logger
	 */
	private static final Logger LOG = LoggerFactory.getLogger(ItemResource.class);

	/**
	 * @param itemManagement itemManagement
	 * @param itemMapper     itemMapper
	 */
	public ItemResource(ItemManagement itemManagement, ItemMapper itemMapper) {
		super();
		this.itemManagement = itemManagement;
		this.itemMapper = itemMapper;
	}

	/**
	 * @return
	 */
	@GetMapping("/items")
	@Timed("itemResource.showItems")
	public List<ItemDTO> showItems() {
		final List<ItemEntity> itemEntities = itemManagement.getAllItems();
		LOG.info("Number of items returned: {}", itemEntities.size());
		return itemMapper.mapToDtoList(itemEntities);
	}

	@PostMapping("/items")
	public ResponseEntity<URI> addItem(@Valid @RequestBody final ItemLightDTO itemDTO) {
		final ItemEntity itemEntity = itemMapper.mapToEntity(itemDTO);
		itemManagement.addItem(itemEntity);
		final URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(itemEntity.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

}
