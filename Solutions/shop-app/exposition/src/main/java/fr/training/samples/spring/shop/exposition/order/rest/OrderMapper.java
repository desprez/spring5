package fr.training.samples.spring.shop.exposition.order.rest;

import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import fr.training.samples.spring.shop.common.AbstractMapper;
import fr.training.samples.spring.shop.domain.customer.CustomerEntity;
import fr.training.samples.spring.shop.domain.item.ItemEntity;
import fr.training.samples.spring.shop.domain.order.OrderEntity;
import fr.training.samples.spring.shop.exposition.item.rest.ItemMapper;

/**
 * @author Badr NASS Mapper for the entity CustomeEntity and its DTO CustomeDTO.
 *
 */
@Component
public class OrderMapper extends AbstractMapper<OrderDTO, OrderEntity> {

	/**
	 * itemMapper of type ItemMapper
	 */
	private transient final ItemMapper itemMapper;

	public OrderMapper(ItemMapper itemMapper) {
		super();
		this.itemMapper = itemMapper;
	}

	@Override
	public OrderDTO mapToDto(OrderEntity entity) {
		OrderDTO orderDTO = new OrderDTO();
		orderDTO.setOrderID(entity.getId());
		if (entity.getCustomer() != null) {
			orderDTO.setCustomerID(entity.getCustomer().getId());
		}
		if (!CollectionUtils.isEmpty(entity.getItems())) {
			orderDTO.setItems(itemMapper.mapToDtoSet(entity.getItems()));
		}
		return orderDTO;
	}

	@Override
	public OrderEntity mapToEntity(OrderDTO dto) {
		OrderEntity orderEntity = new OrderEntity();
		CustomerEntity customerEntity = new CustomerEntity();
		customerEntity.setId(dto.getCustomerID());
		orderEntity.setCustomer(customerEntity);
		orderEntity.setId(dto.getOrderID());
		orderEntity.setItems(itemMapper.mapToEntitySet(dto.getItems()));
		return orderEntity;
	}

	public OrderEntity mapToEntity(@Valid OrderLightDTO orderLightDTO) {
		OrderEntity orderEntity = new OrderEntity();
		CustomerEntity customerEntity = new CustomerEntity();
		customerEntity.setId(orderLightDTO.getCustomerID());
		Set<ItemEntity> items = orderLightDTO.getItems().stream().map(ItemEntity::new)
				.collect(Collectors.toSet());
		orderEntity.setCustomer(customerEntity);
		orderEntity.setItems(items);
		return orderEntity;
	}
}