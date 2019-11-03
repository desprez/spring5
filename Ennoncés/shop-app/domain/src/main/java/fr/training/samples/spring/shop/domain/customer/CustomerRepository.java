package fr.training.samples.spring.shop.domain.customer;

/**
 * @author Badr NASS
 *
 */
public interface CustomerRepository {

    /**
     * @param customer
     * @return
     */
    CustomerEntity create(CustomerEntity customer);

    /**
     * @param id
     * @return
     */
	CustomerEntity findOne(String id);

	/**
	 * @param customer
	 */
	CustomerEntity update(CustomerEntity customerEntity);

}
