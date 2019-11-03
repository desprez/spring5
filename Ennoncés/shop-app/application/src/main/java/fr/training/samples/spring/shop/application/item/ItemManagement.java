package fr.training.samples.spring.shop.application.item;

import java.util.List;

import fr.training.samples.spring.shop.domain.item.ItemEntity;

/**
 * @author Badr NASS
 *
 */
public interface ItemManagement {

    /**
     * @param itemEntity
     * @return
     */
    ItemEntity addItem(ItemEntity itemEntity);

    /**
     * @return
     */
    List<ItemEntity> getAllItems();

}
