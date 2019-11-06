package fr.training.samples.spring.shop.repository.item;

import fr.training.samples.spring.shop.domain.item.ItemEntity;
import fr.training.samples.spring.shop.domain.item.ItemRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public class ItemRepositoryImpl implements ItemRepository {

	private ItemRepositoryDataJPA itemRepositoryDataJPA;

	public ItemRepositoryImpl(ItemRepositoryDataJPA itemRepositoryDataJPA) {
		this.itemRepositoryDataJPA = itemRepositoryDataJPA;
	}

	@Override
	public ItemEntity addItem(ItemEntity itemEntity) {
		return null;
	}

	@Override
	public ItemEntity findOne(String itemId) {
		return null;
	}

	@Override
	public List<ItemEntity> getAllItems() {
		return itemRepositoryDataJPA.findAll();
	}

	@Override
	public Set<ItemEntity> getAllItems(Set<String> itemsId) {
		return null;
	}


}
