package headers.models;

import headers.controllers.OrderLineController_H;

import java.util.Date;

/**
 * Author:  Aleix Marine Tena
 * Date:    22/11/16
 */
public interface Order_H {

	/**
	 * Gets the identifier of the Order
	 *
	 * @return identifier of the Order
	 */
	int getId();

	/**
	 * Gets the price of the Order
	 *
	 * @return price of the Order
	 */
	double getPrice();

	/**
	 * Sets the price of the Order
	 *
	 * @param price price of the Order
	 */
	void setPrice(double price);

	/**
	 * Gets the date of the Order
	 *
	 * @return date of the Order
	 */
	Date getOrderDate();

	/**
	 * Gets the list of OrderLine
	 *
	 * @return list of OrderLine
	 */
	OrderLineController_H getOrderLineList();

	/**
	 * Gets the list of OrderLine
	 *
	 * @return list of OrderLine
	 */
	String toString();
}
