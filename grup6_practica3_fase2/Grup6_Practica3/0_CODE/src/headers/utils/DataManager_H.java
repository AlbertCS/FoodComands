package headers.utils;

import grup06_practica3.exceptions.*;
import headers.controllers.ClientController_H;
import headers.controllers.ProductController_H;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface DataManager_H {

	/**
	 * Imports products form file
	 *
	 * @param filename name of the file
	 * @return list of products
	 * @throws FileNotFoundException    thrown if the file does not exist
	 * @throws ProductFullListException thrown if the list is full
	 */
	ProductController_H loadProductsFromFile(String filename) throws FileNotFoundException, ProductFullListException;

	/**
	 * Imports clients from file
	 *
	 * @param filename name of the file
	 * @return list of clients
	 * @throws FileNotFoundException   thrown if the file does not exist
	 * @throws ClientFullListException thrown if the list is full
	 */
	ClientController_H loadClientFromFile(String filename) throws FileNotFoundException, ClientFullListException;

	/**
	 * Imports orders from file
	 *
	 * @param clients
	 *            list of clients
	 * @param products
	 *            list of products
	 * @param filename
	 *            name of the file
	 * @throws FileNotFoundException
	 *             thrown if the file does not exist
	 * @throws OrderFullListException
	 *             thrown if the list is full
	 * @throws OrderLineFullListException
	 *             thrown if the list is full
	 * @throws ProductNotFoundException Thrown when the product is no found in the lists
	 * @throws NumberFormatException Thrwon when number format exception occurs
	 * @throws ClientNotFoundException Thrown when the client is not found in the list
	 */
	void loadOrdersFromFile(ClientController_H clients, String filename, ProductController_H products) throws FileNotFoundException, OrderFullListException, OrderLineFullListException, NumberFormatException, ProductNotFoundException, ClientNotFoundException;

	/**
	 * Exports products to file
	 *
	 * @param products list of products
	 * @param filename name of the file
	 * @throws IOException thrown if the file cannot be opened
	 */
	void writeProductsToFile(ProductController_H products, String filename) throws IOException;

	/**
	 * Exports clients to file
	 *
	 * @param clients  list of clients
	 * @param filename name of the file
	 * @throws IOException thrown if the file cannot be opened
	 */
	void writeClientToFile(ClientController_H clients, String filename) throws IOException;

	/**
	 * Exports list of orders to file
	 *
	 * @param clients list of clients
	 * @param filename name of the file
	 * @throws IOException thrown if the file cannot be opened
	 * @throws OrderNotFoundException thrown when the order is not found in the list
	 * @throws OrderLineNotFoundException thrown when the order line is not found in the list
	 */
	void writeOrdersToFile(ClientController_H clients, String filename) throws IOException, OrderNotFoundException, OrderLineNotFoundException;
}
