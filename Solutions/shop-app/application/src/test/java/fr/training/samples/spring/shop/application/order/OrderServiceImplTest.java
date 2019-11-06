package fr.training.samples.spring.shop.application.order;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.training.samples.spring.shop.application.order.OrderManagement;
import fr.training.samples.spring.shop.domain.customer.CustomerEntity;
import fr.training.samples.spring.shop.domain.customer.CustomerRepository;
import fr.training.samples.spring.shop.domain.customer.CustomerVO;
import fr.training.samples.spring.shop.domain.item.ItemEntity;
import fr.training.samples.spring.shop.domain.item.ItemRepository;
import fr.training.samples.spring.shop.domain.item.ItemVO;
import fr.training.samples.spring.shop.domain.order.OrderEntity;
import fr.training.samples.spring.shop.domain.order.OrderRepository;

/**
 * @author Badr NASS
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class OrderServiceImplTest {

	/**
	 * orderManagement of type OrderManagement
	 */
	@Autowired
	private transient OrderManagement orderManagement;

	/**
	 * orderRepository of type OrderRepository
	 */
	@MockBean
	private transient OrderRepository orderRepository;

	/**
	 * customerRepository of type CustomerRepository
	 */
	@MockBean
	private transient CustomerRepository customerRepository;

	/**
	 * itemRepository of type ItemRepository
	 */
	@MockBean
	private transient ItemRepository itemRepository;

	/**
	 * 
	 */
	@Test
	public void testAddOrder() {
		final OrderEntity orderEntity = this.createOrder("NASS", "123456", "DESC99", 99);
		Set<ItemEntity> itemEntities = orderEntity.getItems();
		Set<String> itemIds = itemEntities.stream().map(ItemEntity::getId).collect(Collectors.toSet());
		when(itemRepository.getAllItems(itemIds)).thenReturn(itemEntities);
		when(orderRepository.addOrder(orderEntity)).thenReturn(orderEntity);
		final OrderEntity orderResult = orderManagement.addOrder(orderEntity);
		assertNotNull(orderResult);
	}

	/**
	 *
	 */
	@Test
	public void testGetOrdersForCustomer() {
		final OrderEntity orderEntity1 = this.createOrder("NASS", "123456", "DESC99", 99);
		final OrderEntity orderEntity2 = this.createOrder("NASS", "123456", "DESC99", 99);
		final Set<OrderEntity> orders = Stream.of(orderEntity1, orderEntity2).collect(Collectors.toSet());
		when(orderRepository.getOrdersForCustomer("123e4567-e89b-42d3-a456-556642440000")).thenReturn(orders);
		final Set<OrderEntity> ordersResult = orderManagement
				.getOrdersForCustomer("123e4567-e89b-42d3-a456-556642440000");
		assertNotNull(ordersResult);
		assertEquals(2, ordersResult.size());
	}

	/**
	 * @param customerName
	 * @param customerPass
	 * @param itemDesc
	 * @param price
	 * @return
	 */
	private OrderEntity createOrder(final String customerName, final String customerPass, final String itemDesc,
			final int price) {
		final CustomerEntity customer = new CustomerEntity(new CustomerVO("nass", "123456"));
		final ItemEntity itemEntity = new ItemEntity(new ItemVO("DESC99", 99));
		final OrderEntity orderEntity = new OrderEntity();
		orderEntity.setCustomer(customer);
		orderEntity.setItems(Stream.of(itemEntity).collect(Collectors.toSet()));
		return orderEntity;
	}

}
