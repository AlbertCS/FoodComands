package headers.views;

import grup06_practica3.exceptions.OrderLineFullListException;
import grup06_practica3.exceptions.OrderNotFoundException;
import headers.controllers.ProductController_H;
import headers.models.Client_H;

public interface OrderView_H {
	/**
	 * Shows an order using its ID in mode text
	 * @param ID int of ID
	 * @throws OrderNotFoundException throws if there is no such order
	 */
	void showOrderText(int ID) throws OrderNotFoundException;
	/**
	 * Shows an order using its ID in mode grpahical
	 * @param ID int of ID
	 * @throws OrderNotFoundException throws if there is no such order
	 */
	public void showOrderGui(int ID) throws OrderNotFoundException;
	/**
	 * Shows all the orders from a client in a text mode
	 */
	void showOrdersText();
	/**
	 *  Shows all the orders from a client in a graphical mode
	 */
	void showOrdersGui();
	/**
	 * Creates a new order interacting with the user in a tet mode
	 * @param client instance of client
	 * @param menu instance of productcontroller, (the menu)
	 * @throws OrderLineFullListException throws if the list is full
	 */
	void createOrderText(Client_H client, ProductController_H menu) throws OrderLineFullListException; 
	/**
	 * creates a new order interacting with user in a graphical mode
	 * @param client instance of client
	 * @param menu instance of productcontroller, (the menu)
	 * @throws OrderLineFullListException throws if the list is full
	 */
	void createOrderGui(Client_H client, ProductController_H menu) throws OrderLineFullListException; 
	/**
	 * copy an existing order interacting with user is a text mode
	 * @param client instance of client
	 * @throws OrderNotFoundException throws if there is no such order
	 */
	void copyOrderText(Client_H client) throws OrderNotFoundException; 
	/**
	 * copy an existing order interacting with user is a graphical mode
	 * @param client instance of client
	 * @throws OrderNotFoundException throws if there is no such order
	 */
	void copyOrderGui(Client_H client) throws OrderNotFoundException;
}
