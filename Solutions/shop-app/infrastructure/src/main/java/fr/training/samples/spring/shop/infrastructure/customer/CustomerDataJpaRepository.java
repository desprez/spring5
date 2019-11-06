package fr.training.samples.spring.shop.infrastructure.customer;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.training.samples.spring.shop.domain.customer.CustomerEntity;

/**
 * @author Badr NASS
 *
 */
public interface CustomerDataJpaRepository extends JpaRepository<CustomerEntity, String> {


}
