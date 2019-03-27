package headers.models;

import headers.controllers.OrderController_H;

/**
 * Author:  Bernat Bosca Candel
 * Date:    20/11/16
 */
public interface Client_H {

	/**
	 * Gets the identifier of the client
	 *
	 * @return identifier of the client
	 */
	int getId();

	/**
	 * Gets the name of the client
	 *
	 * @return name of the client
	 */
	String getName();

	/**
	 * Gets the address of the client
	 *
	 * @return address of the client
	 */
	String getAddress();

	/**
	 * Gets the phone number of the client
	 *
	 * @return phone number of the client
	 */
	String getPhoneNumber();

	/**
	 * Gets the username of the client
	 *
	 * @return username of the client
	 */
	String getUsername();

	/**
	 * Gets the password of the client
	 *
	 * @return password of the client
	 */
	String getPassword();

	/**
	 * Gets if the client is celiac
	 *
	 * @return true if the client is celiac
	 */
	boolean isCeliac();

	/**
	 * Gets if the client is lactose intolerant
	 *
	 * @return true if the client is lactose intolerant
	 */
	boolean isLactose();

	/**
	 * Gets if the client is dried fruits allergic
	 *
	 * @return true if the client is dried fruits allergic
	 */
	boolean isDriedFruits();

	/**
	 * Gets if the client is preferential
	 *
	 * @return true if the client is preferential
	 */
	boolean isPreferential();

	/**
	 * Sets if the client is preferential
	 *
	 * @param preferential true if the client is preferential
	 */
	void setPreferential(boolean preferential);

	/**
	 * Gets the list of Client
	 *
	 * @return list of Client
	 */
	OrderController_H getOrderList();

	/**
	 * Overrides toString method
	 *
	 * @return string of the object
	 */
	String toString();
}
