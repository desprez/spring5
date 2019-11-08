package fr.training.samples.spring.shop.exposition.order.rest;

import java.net.URI;
import java.util.Set;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import fr.training.samples.spring.shop.application.order.OrderManagement;
import fr.training.samples.spring.shop.domain.order.OrderEntity;

/**
 * @author Badr NASS
 *
 */
@RestController
@RequestMapping("/api")
public class OrderResource {

	/**
	 * logger of type Logger
	 */
	private static final Logger LOG = LoggerFactory.getLogger(OrderResource.class);

	/**
	 * orderManagement of type OrderManagement
	 */
	private final OrderManagement orderManagement;

	/**
	 * orderMapper of type OrderMapper
	 */
	private final OrderMapper orderMapper;

	/**
   * @param orderManagement orderManagement
   * @param orderMapper mapper
   */
	public OrderResource(OrderManagement orderManagement, OrderMapper orderMapper) {
		super();
		this.orderManagement = orderManagement;
		this.orderMapper = orderMapper;
	}


  /**
   * @param orderDTO orderDTO
   * @return ResponseEntity of URI
   */
	@PostMapping("/orders")
	public ResponseEntity<URI> addOrder(@Valid @RequestBody final OrderLightDTO orderDTO) {
		final OrderEntity orderEntity = orderMapper.mapToEntity(orderDTO);
		orderManagement.addOrder(orderEntity);
		final URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(orderEntity.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

	/**
   * @param customerID customerID
   * @return List of OrderDTO
   */
	@GetMapping("/orders")
	public Set<OrderDTO> getOrders(@RequestParam final String customerID) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("Start some work from the scheduled task");
		}
		final Set<OrderEntity> orderEntity = orderManagement.getOrdersForCustomer(customerID);
		return orderMapper.mapToDtoSet(orderEntity);
	}

}
