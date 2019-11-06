package fr.training.samples.spring.shop.infrastructure.order;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import fr.training.samples.spring.shop.domain.common.exception.NotFoundException;
import fr.training.samples.spring.shop.domain.order.OrderEntity;
import fr.training.samples.spring.shop.domain.order.OrderRepository;

/**
 * @author Badr NASS
 *
 */
@Repository
public class OrderRepositoryImpl implements OrderRepository {

	/**
	 * orderDataJpaRepository of type OrderDataJpaRepository
	 */
	private final transient OrderDataJpaRepository orderDataJpaRepository;

	/**
	 * The EntityManager
	 */
	private final transient EntityManager entityManager;

	/**
	 * @param orderDataJpaRepository
	 */
	public OrderRepositoryImpl(OrderDataJpaRepository orderDataJpaRepository, EntityManager entityManager) {
		super();
		this.orderDataJpaRepository = orderDataJpaRepository;
		this.entityManager = entityManager;
	}

	@Override
	public OrderEntity addOrder(final OrderEntity orderEntity) {
		entityManager.persist(orderEntity);
		return orderEntity;
	}

	@Override
	public void addOrders(final List<OrderEntity> orders) {
		orderDataJpaRepository.saveAll(orders);
	}

	@Override
	public OrderEntity findOne(final String orderID) {
		return orderDataJpaRepository.findById(orderID)
				.orElseThrow(() -> new NotFoundException("Order with id:" + orderID + ", not found"));
	}

	@Override
	public Set<OrderEntity> getOrdersForCustomer(final String id) {
		return orderDataJpaRepository.getOrdersForCustomer(id);
	}
}
