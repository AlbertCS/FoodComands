package headers.controllers;

import grup06_practica3.exceptions.OrderFullListException;
import grup06_practica3.exceptions.OrderLineFullListException;
import grup06_practica3.exceptions.OrderNotFoundException;
import headers.models.Client_H;
import headers.models.OrderLine_H;
import headers.models.Order_H;

/**
 * Author:  Aleix Marine Tena
 * Date:    21/11/16
 */
public interface OrderController_H {

	/**
	 * Gets the list of Order
	 *
	 * @return list of Order
	 */
	Order_H[] getOrderList();

	/**
	 * Gets the size of the Order list
	 *
	 * @return size of the Order list
	 */
	int getSize();

	/**
	 * Adds a new Order
	 *
	 * @param orderLine orderLine to add in the list
	 * @return new Order
	 * @throws OrderFullListException     thrown if list is full
	 * @throws OrderLineFullListException thrown if list is full
	 */
	Order_H addOrder(OrderLine_H orderLine) throws OrderFullListException, OrderLineFullListException;

	/**
	 * Gets the order identified by the id
	 *
	 * @param id identifier of the order
	 * @return order identified by the id
	 * @throws OrderNotFoundException thrown if the order does not exist
	 */
	Order_H getOrder(int id) throws OrderNotFoundException;

	/**
	 * Removes a order from the list
	 *
	 * @param id identifier of the order
	 * @throws OrderNotFoundException thrown if the order does not exist
	 */
	void removeOrder(int id) throws OrderNotFoundException;
	
	/**
	 * 
	 * @param appMode application mode
	 * @param products products in the menu 
	 * @param client client which is creating the order
	 * @throws OrderLineFullListException thrown when orderline is full
	 */
	void addOrderAction(String appMode, ProductController_H products, Client_H client) throws OrderLineFullListException;

	/**
	 * 
	 * @param appMode application mode
	 */
	void displayOrdersAction(String appMode);
	
	/**
	 * 
	 * @param appMode application mode
	 * @param client client who is generatin the order
	 * @throws OrderNotFoundException thrown when order is not found in te oderslist
	 */
	void copyOrderAction(String appMode, Client_H client) throws OrderNotFoundException;
}
