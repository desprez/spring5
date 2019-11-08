package fr.training.samples.spring.shop.samples.spring.shop.infrastructure.order;

import java.util.Set;

import fr.training.samples.spring.shop.samples.spring.shop.domain.order.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Badr NASS
 *
 */
public interface OrderDataJpaRepository extends JpaRepository<OrderEntity, String> {

	/**
	 * @param customerId
	 * @return Set<OrderEntity>
	 */
	@Query("select o from OrderEntity o join fetch o.items where o.customer.id = :customerId")
	Set<OrderEntity> getOrdersForCustomer(@Param("customerId") String customerId);
}
