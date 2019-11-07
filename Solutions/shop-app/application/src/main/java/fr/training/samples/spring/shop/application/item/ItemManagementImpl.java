package fr.training.samples.spring.shop.application.item;

import java.util.List;

import fr.training.samples.spring.shop.config.LoggingShopAspect;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.training.samples.spring.shop.domain.item.ItemEntity;
import fr.training.samples.spring.shop.domain.item.ItemRepository;

/**
 * @author Badr NASS
 *
 */
@Service
@Transactional
public class ItemManagementImpl implements ItemManagement {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingShopAspect.class);

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
        LOGGER.info("Hi toto");
        return itemRepository.getAllItems();
    }

}