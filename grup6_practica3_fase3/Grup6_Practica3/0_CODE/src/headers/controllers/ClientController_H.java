package headers.controllers;

import grup06_practica3.exceptions.ClientFullListException;
import grup06_practica3.exceptions.ClientNotFoundException;
import grup06_practica3.exceptions.OrderLineFullListException;
import grup06_practica3.exceptions.OrderNotFoundException;
import headers.models.Client_H;

/**
 * Author:  Bernat Bosca Candel
 * Date:    23/11/16
 */
public interface ClientController_H {

	/**
	 * Gets the list of clients
	 *
	 * @return list of clients
	 */
	Client_H[] getClientList();

	/**
	 * Gets the size of the Client list
	 *
	 * @return size of the Client list
	 */
	int getSize();

	/**
	 * Adds a new Client
	 *
	 * @param client client
	 * @throws ClientFullListException thrown if list is full
	 */
	void addClient(Client_H client) throws ClientFullListException;

	/**
	 * Gets the client identified by the id
	 *
	 * @param id identifier of the client
	 * @return client identified by the id
	 * @throws ClientNotFoundException thrown if the client does not exist
	 */
	Client_H getClient(int id) throws ClientNotFoundException;

	/**
	 * Gets the client by the position
	 * 
	 * @param pos position of the client we want
	 * @return client in the specified position
	 * @throws ClientNotFoundException thrown when the client is not in the list
	 */
	Client_H getClientByPos(int pos) throws ClientNotFoundException;
	
	/**
	 * This method call the view to add a client to the list
	 * 
	 * @param appMode application mode
	 */
	void addClientAction(String appMode);
	
	/**
	 * This method call the view to display the clients
	 * 
	 * @param appMode application mode
	 */
	void displayClientsAction(String appMode);
	
	/**
	 * Display the orders that corresponds with the id that the user want to know the orders of the client
	 * 
	 * @param appMode application mode
	 * @throws ClientNotFoundException  thrown when the
	 */
	void displayClientsOrdersAction(String appMode) throws ClientNotFoundException;
	
	/**
	 * Add a order to a client that corresponds with the id that the user want to add a new order
	 * 
	 * @param appMode Application mode
	 * @param products products list
	 * @throws ClientNotFoundException thrown when the client is not found in the list
	 * @throws OrderLineFullListException thrown when the orderLine list is full
	 */
	void addOrderAction(String appMode, ProductController_H products) throws ClientNotFoundException, OrderLineFullListException;
	
	/**
	 * Copy a order to a client that corresponds with the id that the user want to copy any order
	 * 
	 * @param appMode application mode
	 * @throws ClientNotFoundException thrown when client not found in the group
	 * @throws OrderNotFoundException thrown when the order is not in the list
	 */
	void copyOrderAction(String appMode) throws ClientNotFoundException, OrderNotFoundException;
}
