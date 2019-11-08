package fr.training.samples.spring.shop.samples.spring.shop.application.item;

import fr.training.samples.spring.shop.samples.spring.shop.domain.item.ItemEntity;

import java.util.List;

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
