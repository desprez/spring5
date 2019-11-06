package fr.training.samples.spring.shop.domain.order;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.Valid;

import fr.training.samples.spring.shop.domain.common.entity.AbstractBaseEntity;
import fr.training.samples.spring.shop.domain.customer.CustomerEntity;
import fr.training.samples.spring.shop.domain.item.ItemEntity;

/**
 * @author Badr NASS
 *
 */
@Entity
@Table(name = "ORDERS")
public class OrderEntity extends AbstractBaseEntity {

    /**
     * customer of type CustomerEntity
     */
    @Valid
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CUSTOMER_ID", nullable = false)
    private CustomerEntity customer;

    /**
	 * items of type Set<ItemEntity>
	 */
	@ManyToMany
	@JoinTable(name = "ITEM_ORDERS", inverseJoinColumns = @JoinColumn(name = "ITEMS_ID", referencedColumnName = "ID"), joinColumns = @JoinColumn(name = "ORDERS_ID", referencedColumnName = "ID"))
	private Set<ItemEntity> items;


    public OrderEntity() {
        super();
    }

    /**
     * @param customer
     * @param items
     */
	public OrderEntity(final CustomerEntity customer, final Set<ItemEntity> items) {
        super();
        this.customer = customer;
        this.items = items;
    }

    /**
     * @return
     */
    public CustomerEntity getCustomer() {
        return customer;
    }

    /**
     * @return
     */
	public Set<ItemEntity> getItems() {
        return items;
    }

    /**
     * @param customer
     */
    public void setCustomer(final CustomerEntity customer) {
        this.customer = customer;
    }

    /**
     * @param items
     */
	public void setItems(final Set<ItemEntity> items) {
        this.items = items;
    }
}
