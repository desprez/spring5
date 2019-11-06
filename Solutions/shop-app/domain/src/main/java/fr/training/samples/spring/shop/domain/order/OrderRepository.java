package fr.training.samples.spring.shop.domain.order;

import java.util.List;
import java.util.Set;

/**
 * @author Badr NASS
 *
 */
public interface OrderRepository {

    /**
     * @param order
     * @return
     */
    OrderEntity addOrder(OrderEntity order);

    /**
     * @param orders
     */
    void addOrders(List<OrderEntity> orders);

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

}
