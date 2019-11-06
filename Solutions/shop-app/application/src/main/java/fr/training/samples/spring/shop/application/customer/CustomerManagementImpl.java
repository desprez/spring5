package fr.training.samples.spring.shop.application.customer;

import fr.training.samples.spring.shop.domain.customer.CustomerEntity;
import fr.training.samples.spring.shop.domain.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Service
public class CustomerManagementImpl implements CustomerManagement{

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public CustomerEntity create(CustomerEntity customer) {
        return customerRepository.create(customer);
    }

    @Override
    public CustomerEntity findOne(String customerID) {
        return customerRepository.findOne(customerID);
    }

    @Override
    public CustomerEntity update(CustomerEntity customerEntity) {
        return customerRepository.update(customerEntity);
    }
}
