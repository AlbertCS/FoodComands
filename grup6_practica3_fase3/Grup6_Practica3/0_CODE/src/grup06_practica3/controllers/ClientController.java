package grup06_practica3.controllers;

import grup06_practica3.exceptions.ClientFullListException;
import grup06_practica3.exceptions.ClientNotFoundException;
import grup06_practica3.exceptions.OrderLineFullListException;
import grup06_practica3.exceptions.OrderNotFoundException;
import grup06_practica3.models.Client;
import grup06_practica3.utils.Settings;
import grup06_practica3.views.ClientView;
import headers.controllers.ClientController_H;
import headers.controllers.ProductController_H;
import headers.models.Client_H;
import headers.views.ClientView_H;

/**
 * Author:  Bernat Bosca Candel
 * Date:    23/11/16
 */
public class ClientController implements ClientController_H {

	/**
	 * List of clients
	 */
	private Client_H[] clientList;

	/**
	 * Size of the list
	 */
	private int size;

	/**
	 * Unique identifier of clients
	 */
	private int nextId;

	/**
	 * View of client
	 */
	private ClientView_H clientView = null;
	
	/**
	 * Default constructor for the ClientController class
	 */
	public ClientController() {
		this.size = 0;
		this.clientList = new Client_H[1000];

		this.nextId = 1;
		this.clientView = new ClientView(this);
	}

	/**
	 * Gets the list of clients
	 *
	 * @return list of clients
	 */
	@Override
	public Client_H[] getClientList() {
		return clientList;
	}

	/**
	 * Gets the size of the Client list
	 *
	 * @return size of the Client list
	 */
	@Override
	public int getSize() {
		return size;
	}

	/**
	 * Adds a new Client
	 *
	 * @param client client
	 * @throws ClientFullListException thrown if list is full
	 */
	@Override
	public void addClient(Client_H client) throws ClientFullListException {
		if (size < clientList.length) {
			clientList[size] = new Client(nextId, client.getName(), client.getAddress(), client.getPhoneNumber(), client.getUsername(), client.getPassword(), client.isCeliac(), client.isLactose(), client.isDriedFruits());
			size++;
			nextId++;
		} else {
			throw new ClientFullListException();
		}

	}

	/**
	 * Gets the client identified by the id
	 *
	 * @param id identifier of the client
	 * @return client identified by the id
	 * @throws ClientNotFoundException thrown if the client does not exist
	 */
	@Override
	public Client_H getClient(int id) throws ClientNotFoundException {
		for (int i = 0; i < size; i++) {
			if (clientList[i].getId() == id) {
				return clientList[i];
			}
		}
		throw new ClientNotFoundException();
	}

	/**
	 * Gets the client by the position
	 * 
	 * @param pos position of the client we want
	 * @return client in the specified position
	 * @throws ClientNotFoundException thrown when the client is not in the list
	 */
	@Override
	public Client_H getClientByPos(int pos) throws ClientNotFoundException {
		if (pos < size) {
			return clientList[pos];
		}
		throw new ClientNotFoundException();
	}

	/**
	 * This method call the view to add a client to the list
	 * 
	 * @param appMode application mode
	 */
	@Override
	public void addClientAction(String appMode) {
		if (appMode.equals(Settings.TEXT_MODE)) {
			clientView.addClientText();
		} else {
			clientView.addClientGui();
		}
	}
	
	/**
	 * This method call the view to display the clients
	 * 
	 * @param appMode application mode
	 */
	@Override
	public void displayClientsAction(String appMode){
		if (appMode.equals(Settings.TEXT_MODE)) {
			clientView.displayClientListText();
		} else {
			clientView.displayClientListGui();
		}
	}

	/**
	 * Display the orders that corresponds with the id that the user want to know the orders of the client
	 * 
	 * @param appMode application mode
	 * @throws ClientNotFoundException thrown when the client is not found in the list
	 */
	@Override
	public void displayClientsOrdersAction(String appMode) throws ClientNotFoundException {
		int id = -1;
		if (appMode.equals(Settings.TEXT_MODE)) {
			id = clientView.selectIdClientListText();
			
		} else {
			id = clientView.selectIdClientListGui();
		}
		if(id >=0){
			this.getClient(id).getOrderList().displayOrdersAction(appMode);
		}
	}
	
	/**
	 * Add a order to a client that corresponds with the id that the user want to add a new order
	 * 
	 * @param appMode application mode
	 * @throws ClientNotFoundException thrown whe client is not in the list
	 * @throws OrderLineFullListException  Thrown when the list is full
	 */
	@Override
	public void addOrderAction(String appMode, ProductController_H products) throws ClientNotFoundException, OrderLineFullListException{
		int id = -1;
		if (appMode.equals(Settings.TEXT_MODE)) {
			id = clientView.selectIdClientListText();
			
		} else {
			id = clientView.selectIdClientListGui();
		}
		if(id >=0){
			this.getClient(id).getOrderList().addOrderAction(appMode, products, this.getClient(id));
		}
	}
	
	/**
	 * Copy a order to a client that corresponds with the id that the user want to copy any order
	 * 
	 * @param appMode applicaton mode
	 * @throws ClientNotFoundException Thrown when Client is not in the list
	 * @throws OrderNotFoundException thrown when order is not found in the list
	 */
	@Override
	public void copyOrderAction(String appMode) throws ClientNotFoundException, OrderNotFoundException{
		int id = -1;
		if (appMode.equals(Settings.TEXT_MODE)) {
			id = clientView.selectIdClientListText();
			
		} else {
			id = clientView.selectIdClientListGui();
		}
		if(id >=0){
			this.getClient(id).getOrderList().copyOrderAction(appMode, this.getClient(id));
		}
	}

}
