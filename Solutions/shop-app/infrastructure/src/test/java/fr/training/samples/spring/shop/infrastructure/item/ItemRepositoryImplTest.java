package fr.training.samples.spring.shop.infrastructure.item;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.training.samples.spring.shop.domain.item.ItemEntity;
import fr.training.samples.spring.shop.domain.item.ItemRepository;
import fr.training.samples.spring.shop.domain.item.ItemVO;

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
