package fr.training.samples.spring.shop.exposition.item.rest;

import org.springframework.stereotype.Component;

import fr.training.samples.spring.shop.common.AbstractMapper;
import fr.training.samples.spring.shop.domain.item.ItemEntity;
import fr.training.samples.spring.shop.domain.item.ItemVO;

/**
 * @author Badr NASS Mapper for the entity ItemEntity and its DTO ItemDTO.
 * 
 */
@Component
public class ItemMapper extends AbstractMapper<ItemDTO, ItemEntity> {

	@Override
	public ItemDTO mapToDto(ItemEntity entity) {
		ItemDTO itemDTO = new ItemDTO();
		itemDTO.setItemID(entity.getId());
		if (entity.getItemVO() != null) {
			itemDTO.setDescription(entity.getItemVO().getDescription());
			itemDTO.setPrice(entity.getItemVO().getPrice());
		}
		return itemDTO;
	}

	@Override
	public ItemEntity mapToEntity(ItemDTO dto) {
		ItemEntity itemEntity = new ItemEntity();
		ItemVO itemVO = new ItemVO(dto.getDescription(), dto.getPrice());
		itemEntity.setItemVO(itemVO);
		itemEntity.setId(dto.getItemID());
		return itemEntity;
	}

	public ItemEntity mapToEntity(ItemLightDTO dto) {
		ItemEntity itemEntity = new ItemEntity();
		ItemVO itemVO = new ItemVO(dto.getDescription(), dto.getPrice());
		itemEntity.setItemVO(itemVO);
		return itemEntity;
	}

}