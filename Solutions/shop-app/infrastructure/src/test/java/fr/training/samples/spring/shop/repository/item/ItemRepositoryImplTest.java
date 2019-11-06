package fr.training.samples.spring.shop.repository.item;

import fr.training.samples.spring.shop.domain.item.ItemEntity;
import fr.training.samples.spring.shop.domain.item.ItemRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@DataJpaTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ItemRepositoryImplTest {

    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void addItem() {
    }

    @Test
    public void findOne() {
    }

    @Test
    public void getAllItems() {
        List<ItemEntity> itemEntities = itemRepository.getAllItems();
        assertNotNull(itemEntities);
        assertTrue(itemEntities.size() > 0);
    }

    @Test
    public void testGetAllItems() {
    }
}