package headers.controllers;

import grup06_practica3.exceptions.OrderLineFullListException;
import grup06_practica3.exceptions.OrderLineNotFoundException;
import headers.models.OrderLine_H;
import headers.models.Product_H;

/**
 * Author:  Aleix Marine Tena
 * Date:    21/11/16
 */
public interface OrderLineController_H {

	/**
	 * Gets the list of OrderLine
	 *
	 * @return list of OrderLine
	 */
	OrderLine_H[] getOrderLineList();

	/**
	 * Gets the size of the OrderLine list
	 *
	 * @return size of the OrderLine list
	 */
	int getSize();

	/**
	 * Adds a new OrderLine
	 *
	 * @param product  product
	 * @param quantity quantity of the product
	 * @throws OrderLineFullListException thrown if list is full
	 */
	void addOrderLine(Product_H product, int quantity) throws OrderLineFullListException;

	/**
	 * Gets the orderLine identified by the id
	 *
	 * @param id identifier of the orderLine
	 * @return orderLine identified by the id
	 * @throws OrderLineNotFoundException thrown if the orderLine does not exist
	 */
	OrderLine_H getOrderLine(int id) throws OrderLineNotFoundException;

	/**
	 * Removes a order line from the list
	 *
	 * @param id identifier of the order line
	 * @throws OrderLineNotFoundException thrown if the order line does not exist
	 */
	void removeOrderLine(int id) throws OrderLineNotFoundException;
}
