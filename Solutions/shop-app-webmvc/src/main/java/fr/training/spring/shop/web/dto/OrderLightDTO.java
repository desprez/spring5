package fr.training.spring.shop.web.dto;

import java.io.Serializable;
import java.util.Set;

/**
 * @author Badr NASS
 *
 */
public class OrderLightDTO implements Serializable {

    /**
     * serialVersionUID of type long
     */
    private static final long serialVersionUID = 1L;


    /**
     * customerID of type String
     */
    private String customerID;

    /**
	 * items of type Set of ItemDTO
	 */
	private Set<String> items;

    /**
     * 
     */
    public OrderLightDTO() {
    }


	public OrderLightDTO(String cusID) {
		this.customerID = cusID;
	}

	/**
	 * @return
	 */
    public String getCustomerID() {
        return customerID;
    }


	public Set<String> getItems() {
		return items;
	}

	public void setItems(Set<String> items) {
		this.items = items;
	}


	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

}
