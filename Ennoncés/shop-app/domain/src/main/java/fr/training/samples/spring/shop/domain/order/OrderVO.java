package fr.training.samples.spring.shop.domain.order;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Embeddable;

/**
 * @author Badr NASS
 *
 */
@Embeddable
public class OrderVO implements Serializable {

    /**
     * serialVersionUID of type long
     */
    private static final long serialVersionUID = 1L;

    /**
     * customerId of type Long
     */
    private Long customerId;

    /**
     * items of type List of Long
     */
    private List<Long> items;

    /**
     * 
     */
    public OrderVO() {

        super();
    }

    /**
     * @param customerId
     * @param items
     */
    public OrderVO(final Long customerId, final List<Long> items) {

        super();
        this.customerId = customerId;
        this.items = items;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(final Object obj) {

        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final OrderVO other = (OrderVO) obj;
        if (customerId == null) {
            if (other.customerId != null) {
                return false;
            }
        } else if (!customerId.equals(other.customerId)) {
            return false;
        }
        if (items == null) {
            if (other.items != null) {
                return false;
            }
        } else if (!items.equals(other.items)) {
            return false;
        }
        return true;
    }

    /**
     * @return
     */
    public Long getCustomerId() {

        return customerId;
    }

    /**
     * @return
     */
    public List<Long> getItems() {

        return items;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {

        final int prime = 31;
        int result = 1;
        result = prime * result + (customerId == null ? 0 : customerId.hashCode());
        result = prime * result + (items == null ? 0 : items.hashCode());
        return result;
    }

    /**
     * @param customerId
     */
    public void setCustomerId(final Long customerId) {

        this.customerId = customerId;
    }

    /**
     * @param items
     */
    public void setItems(final List<Long> items) {

        this.items = items;
    }

}
