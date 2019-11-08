package fr.training.samples.spring.shop.application.order;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import fr.training.samples.spring.shop.domain.common.exception.BusinessException;
import fr.training.samples.spring.shop.domain.customer.CustomerEntity;
import fr.training.samples.spring.shop.domain.customer.CustomerRepository;
import fr.training.samples.spring.shop.domain.item.ItemEntity;
import fr.training.samples.spring.shop.domain.item.ItemRepository;
import fr.training.samples.spring.shop.domain.order.OrderEntity;
import fr.training.samples.spring.shop.domain.order.OrderRepository;

/**
 * @author Badr NASS
 *
 */
@Service
@Transactional
public class OrderManagementImpl implements OrderManagement {

	/**
	 * orderRepository of type OrderRepository
	 */
	private final transient OrderRepository orderRepository;

	/**
	 * customerRepository of type CustomerRepository
	 */
	private final transient CustomerRepository customerRepository;

	/**
	 * itemRepository of type ItemRepository
	 */
	private final transient ItemRepository itemRepository;

	/**
	 * @param orderRepository
	 * @param customerRepository
	 * @param itemRepository
	 */
	public OrderManagementImpl(final OrderRepository orderRepository, final CustomerRepository customerRepository,
			final ItemRepository itemRepository) {

		super();
		this.orderRepository = orderRepository;
		this.customerRepository = customerRepository;
		this.itemRepository = itemRepository;
	}


	@Override
	public OrderEntity addOrder(final OrderEntity orderEntity) {
		final CustomerEntity customerEntity = customerRepository.findOne(orderEntity.getCustomer().getId());
		final Set<ItemEntity> items = itemRepository
				.getAllItems(orderEntity.getItems().stream().map(ItemEntity::getId).collect(Collectors.toSet()));
		if (CollectionUtils.isEmpty(items))
			throw new BusinessException("The order should contain at least one existing item");
		orderEntity.setCustomer(customerEntity);
		orderEntity.setItems(items);
		return orderRepository.addOrder(orderEntity);
	}

	@Override
	public OrderEntity findOne(final String orderID) {
		return orderRepository.findOne(orderID);
	}

	@Override
	public Set<OrderEntity> getOrdersForCustomer(final String customerID) {
		return orderRepository.getOrdersForCustomer(customerID);
	}

	@Override
	public void addOrders(List<OrderEntity> orders) {
		orderRepository.addOrders(orders);
	}
}
