package fr.training.samples.spring.shop.application.order;

import java.util.List;
import java.util.Set;

import fr.training.samples.spring.shop.domain.order.OrderEntity;

/**
 * @author Badr NASS
 *
 */
public interface OrderManagement {

    /**
     * @param order
     * @return
     */
    OrderEntity addOrder(OrderEntity order);

    /**
     * @param orderID
     * @return
     */
    OrderEntity findOne(String orderID);

    /**
     * @param customerID
     * @return
     */
	Set<OrderEntity> getOrdersForCustomer(String customerID);
	
	void addOrders(List<OrderEntity> orders);

}
