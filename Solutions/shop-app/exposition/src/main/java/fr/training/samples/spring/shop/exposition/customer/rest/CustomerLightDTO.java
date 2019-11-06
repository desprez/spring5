package fr.training.samples.spring.shop.exposition.customer.rest;

import java.io.Serializable;

/**
 * @author Badr NASS
 *
 */
class CustomerLightDTO implements Serializable {

	/**
	 * serialVersionUID of type long
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * name of type String
	 */
	private String name;

	/**
	 * password of type String
	 */
	private String password;

	/**
	 * 
	 */
	public CustomerLightDTO() {
		super();
	}

	/**
	 * @param name
	 * @param password
	 */
	public CustomerLightDTO(final String name, final String password) {
		super();
		this.name = name;
		this.password = password;
	}

	/**
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param name
	 */
	public void setName(final String name) {
		this.name = name;
	}

	/**
	 * @param password
	 */
	public void setPassword(final String password) {
		this.password = password;
	}

}
