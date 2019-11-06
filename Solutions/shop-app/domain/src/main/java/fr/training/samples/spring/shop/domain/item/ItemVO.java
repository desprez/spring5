package fr.training.samples.spring.shop.domain.item;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 * @author Badr NASS
 *
 */
@Embeddable
public class ItemVO implements Serializable {

    /**
     * serialVersionUID of type long
     */
    private static final long serialVersionUID = 1L;

    /**
     * description of type String
     */
	@Column
    private String description;

    /**
     * price of type int
     */
	@Column
    private int price;

    /**
	 * 
	 */
    public ItemVO() {
        super();
    }

    /**
     * @param description
     * @param price
     */
    public ItemVO(@NotNull final String description, final int price) {
        this.description = description;
        this.price = price;
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
        final ItemVO other = (ItemVO) obj;
        if (description == null) {
            if (other.description != null) {
                return false;
            }
        } else if (!description.equals(other.description)) {
            return false;
        }
        if (price != other.price) {
            return false;
        }
        return true;
    }

    /**
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return
     */
    public int getPrice() {
        return price;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (description == null ? 0 : description.hashCode());
        result = prime * result + price;
        return result;
    }

    /**
     * @param description
     */
    public void setDescription(@NotNull final String description) {
        this.description = description;
    }

    /**
     * @param price
     */
    public void setPrice(final int price) {
        this.price = price;
    }

}
