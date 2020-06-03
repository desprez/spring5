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
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fr.training.samples.spring.shop.domain.item.ItemEntity;
import fr.training.samples.spring.shop.domain.item.ItemRepository;
import fr.training.samples.spring.shop.domain.item.ItemVO;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * @author Badr NASS
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class ItemRepositoryImplTest {

    /**
     * itemRepository of type ItemRepository
     */
    @Autowired
    private transient ItemRepository itemRepository;

    /**
     * 
     */
    @Test
    public void testAddItem() {
        final ItemEntity itemEntity = new ItemEntity(new ItemVO("DESC99", 99));
        itemRepository.addItem(itemEntity);
        assertNotNull(itemEntity.getId());
    }

    /**
	 *  
	 */
    @Test
    public void testGetAllItems() {
		final List<ItemEntity> itemEntities = itemRepository.getAllItems();
        assertNotNull(itemEntities);
        assertTrue(itemEntities.size() == 5);
    }

    /**
     * 
     */
    @Test
    public void testGetAllItemsWithList() {
		final Set<String> items = Stream.of("123e4567-e89b-42d3-a456-556642440001",
				"123e4567-e89b-42d3-a456-556642440002", "123e4567-e89b-42d3-a456-556642440003")
				.collect(Collectors.toSet());
        final Set<ItemEntity> itemEntities = itemRepository.getAllItems(items);
        assertNotNull(itemEntities);
        assertTrue(itemEntities.size() == 3);
	}

}
