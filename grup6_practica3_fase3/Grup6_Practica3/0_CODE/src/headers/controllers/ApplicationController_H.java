package headers.controllers;

import grup06_practica3.exceptions.*;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Author:  Marc Cabre Guinovart
 */
public interface ApplicationController_H {

	/**
	 * Runs the application in the specified mode
	 *
	 * @param applicationMode application mode
	 */
	void run(String applicationMode);

	/**
	 * Adds a new product
	 *
	 * @throws ProductFullListException thrown if list is full
	 */
	void addProductAction() throws ProductFullListException;

	/**
	 * Load products from file
	 *
	 * @param filename name of the file
	 * @throws FileNotFoundException thrown if the file does not exist
	 * @throws ProductFullListException thrown if the list is full
	 */
	void loadProductsFromFile(String filename) throws FileNotFoundException, ProductFullListException;

	/**
	 * Removes a product identified by code
	 *
	 * @throws ProductNotFoundException thrown if the product does not exist
	 */
	void removeProductAction() throws ProductNotFoundException;

	/**
	 * Gets a product identified by code
	 * @throws ProductNotFoundException thrown if the product does not exist
	 */
	void displayProductAction() throws ProductNotFoundException;

	/**
	 * 
	 * @param clients_filename path of the file
	 * @param orders_filename path of the file
	 * @throws FileNotFoundException thrown if the file does not exist
	 * @throws ClientFullListException  thrown if the list is full
	 * @throws OrderFullListException thrown if the list is full
	 * @throws OrderLineFullListException thrown if the list is full
	 * @throws NumberFormatException thrown when number format error happens
	 * @throws ProductNotFoundException hrown when the product is not found in the list.
	 * @throws ClientNotFoundException Thrown when the client is not found in the list.
	 */
	void loadClientsFromFile(String clients_filename, String orders_filename) throws FileNotFoundException, ClientFullListException, OrderFullListException, OrderLineFullListException, NumberFormatException, ProductNotFoundException, ClientNotFoundException;
	
	/**
	 * 
	 * @param clients_filename file path.
	 * @param orders_filename file path.
	 * @throws FileNotFoundException Thrown when the file is not found in the list.
	 * @throws IOException ClientNotFoundException
	 * @throws ClientNotFoundException Thrown when the client is not in the list.
	 * @throws OrderNotFoundException Thrown when order line is not found in the list.
	 * @throws OrderLineNotFoundException Thrown when the order is not found in the list.
	 */
	void saveClientsToFile(String clients_filename, String orders_filename) throws FileNotFoundException, IOException, ClientNotFoundException, OrderNotFoundException, OrderLineNotFoundException;

	/**
	 * Add Client to the list in memory.
	 */
	void addClientAction();
	
	/**
	 * Display client orders
	 */
	void displayClientOrderstAction();
	
	/**
	 * Display clients 
	 */
	void displayClientsAction();
	
	/**
	 * @throws ClientNotFoundException thrown when the client is not in the list
	 * @throws OrderLineFullListException Thrown when the orderline is full
	 * 
	 */
	void addOrderAction() throws ClientNotFoundException, OrderLineFullListException;
	
	/**
	 * 
	 * @param error Error Message
	 */
	void throwExceptionAction(String error);
	
	/**
	 * 
	 * @throws ClientNotFoundException thrown when the client is not in the list
	 * @throws OrderNotFoundException thrown when the order is not in the list
	 */
	void copyOrderAction() throws ClientNotFoundException, OrderNotFoundException;
	
}
