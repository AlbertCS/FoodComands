package grup06_practica3.controllers;

import grup06_practica3.exceptions.*;
import grup06_practica3.utils.DataManager;
import grup06_practica3.utils.Settings;
import grup06_practica3.views.ApplicationView;
import headers.controllers.ApplicationController_H;
import headers.controllers.ClientController_H;
import headers.controllers.ProductController_H;
import headers.views.ApplicationView_H;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Author:  Marc Cabre Guinovart
 */
public class ApplicationController implements ApplicationController_H {

	/**
	 * Handler to manage files
	 */
	private final DataManager fileManager;

	/**
	 * Instance of the application view
	 */
	private final ApplicationView_H view;

	/**
	 * List of products
	 */
	private ProductController_H productList;

	/**
	 * List of clients
	 */
	private ClientController_H clientList;
	
	/**
	 * Application Mode
	 */
	private String appMode = Settings.TEXT_MODE;

	/**
	 * Default constructor for the ApplicationController class
	 */
	public ApplicationController() {
		this.fileManager = new DataManager();

		this.productList = new ProductController();
		this.clientList = new ClientController();

		this.view = new ApplicationView(this);
	}

	/**
	 * Runs the application in the specified mode
	 *
	 * @param applicationMode application mode
	 */
	@Override
	public void run(String applicationMode) {
		appMode = applicationMode;
		if (appMode.equals(Settings.TEXT_MODE)) {
			view.runTextMenu();
		} else {
			view.runGuiMenu();
		}
	}

	/**
	 * Adds a new product
	 *
	 * @throws ProductFullListException thrown if list is full
	 */
	@Override
	public void addProductAction() throws ProductFullListException {
		productList.addProductAction(appMode);
	}

	/**
	 * Load products from file
	 *
	 * @param filename name of the file
	 * @throws FileNotFoundException    thrown if the file does not exist
	 * @throws ProductFullListException thrown if the list is full
	 */
	@Override
	public void loadProductsFromFile(String filename) throws FileNotFoundException, ProductFullListException {
		this.productList = fileManager.loadProductsFromFile(filename);
	}

	/**
	 * Removes a product identified by code
	 *
	 * @throws ProductNotFoundException thrown if the product does not exist
	 */
	@Override
	public void removeProductAction() throws ProductNotFoundException {
		productList.removeProductAction(appMode);
	}

	/**
	 * Gets a product identified by code
	 * @throws ProductNotFoundException thrown when the product is not in the list
	 */
	@Override
	public void displayProductAction() throws ProductNotFoundException {
		productList.displayProductAction(appMode);
	}

	/**
	 * Load products from file
	 *
	 * @param clients_filename name of the file for the clients
	 * @param orders_filename name of the file for the products
	 * @throws FileNotFoundException thrown if the file does not exist
	 * @throws ClientNotFoundException Thrown when the client is not in the list
	 * @throws ProductNotFoundException thrown when the product is not in the list
	 * @throws NumberFormatException Number Format exception
	 */
	public void loadClientsFromFile(String clients_filename, String orders_filename) throws FileNotFoundException, ClientFullListException, OrderFullListException, OrderLineFullListException, NumberFormatException, ProductNotFoundException, ClientNotFoundException {
		this.clientList = fileManager.loadClientFromFile(clients_filename);
		fileManager.loadOrdersFromFile(clientList, orders_filename, productList);
	}

	/**
	 * @param clients_filename file path
	 * @param orders_filename file path
	 * @throws IOException Thrown when can not write in files
	 * @throws ClientNotFoundException thrown when client is not in the list
	 * @throws OrderLineNotFoundException thrown whe n the order lien is not in the list
	 * @throws OrderNotFoundException throen when the order is not found 
	 */

	public void saveClientsToFile(String clients_filename, String orders_filename) throws IOException, ClientNotFoundException, OrderNotFoundException, OrderLineNotFoundException {
		fileManager.writeClientToFile(clientList, clients_filename);
		fileManager.writeOrdersToFile(clientList, orders_filename);
	}

	/**
	 * Add Client to the list in memory.
	 */
	public void addClientAction() {
		clientList.addClientAction(appMode);
	}
	
	/**
	 * Display client orders
	 */
	public void displayClientOrderstAction(){
		displayClientOrderstAction();
	}

	@Override
	public void displayClientsAction() {
		clientList.displayClientsAction(appMode);
	}
	
	/**
	 * 
	 * Call Add Orders to execute the user interface
	 * 
	 * @throws ClientNotFoundException thrown when client is not in the list
	 * @throws OrderLineFullListException thrown when the orderLine is full
	 */
	public void addOrderAction() throws ClientNotFoundException, OrderLineFullListException{
		clientList.addOrderAction(appMode, productList);
	}
	
	/**
	 * 
	 * Call copy Orders to execute the user interface
	 * 
	 * @throws ClientNotFoundException thrown when client is not in the list
	 * @throws OrderNotFoundException thrown when the order is not found
	 */
	public void copyOrderAction() throws ClientNotFoundException, OrderNotFoundException{
		clientList.copyOrderAction(appMode);
	}
	
	/**
	 * Shows a message with the specific error.
	 * 
	 * @param error Exception Error
	 */
	public void throwExceptionAction(String error){
		if (appMode.equals(Settings.TEXT_MODE)) {
			view.showExceptionText(error);
		} else {
			view.showExceptionGui(error);
		}
	}
	
}
