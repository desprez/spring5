package fr.training.samples.spring.shop.repository.customer;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.training.samples.spring.shop.domain.customer.CustomerEntity;

public interface CustomerRepositoryDataJPA extends JpaRepository<CustomerEntity, String> {

}
