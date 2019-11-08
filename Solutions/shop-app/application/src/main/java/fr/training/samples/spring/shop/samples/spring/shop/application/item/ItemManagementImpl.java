package fr.training.samples.spring.shop.samples.spring.shop.application.item;

import fr.training.samples.spring.shop.samples.spring.shop.domain.item.ItemEntity;
import fr.training.samples.spring.shop.samples.spring.shop.domain.item.ItemRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
