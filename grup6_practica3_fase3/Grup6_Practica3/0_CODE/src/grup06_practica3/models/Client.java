package grup06_practica3.models;

import grup06_practica3.controllers.OrderController;
import headers.controllers.OrderController_H;
import headers.models.Client_H;

/**
 * Author:  Bernat Bosca Candel
 * Date:    20/11/16
 */
public class Client implements Client_H {

	/**
	 * Identifier of the client
	 */
	private final int id;

	/**
	 * Name of the client
	 */
	private final String name;

	/**
	 * Address of the client
	 */
	private final String address;

	/**
	 * Phone number of the client
	 */
	private final String phoneNumber;

	/**
	 * Username of the client
	 */
	private final String username;

	/**
	 * Password of the client
	 */
	private final String password;

	/**
	 * Celiac?
	 */
	private final boolean celiac;

	/**
	 * Lactose intolerance?
	 */
	private final boolean lactose;

	/**
	 * Dried fruits allergy?
	 */
	private final boolean driedFruits;

	/**
	 * List of orders
	 */
	private final OrderController_H orderList;

	/**
	 * Client is vip?
	 */
	private boolean preferential;

	/**
	 * Default constructor for the Client class
	 *
	 * @param id          identifier of the client
	 * @param name        name of the client
	 * @param address     address of the client
	 * @param phoneNumber phone number of the client
	 * @param username    username of the client
	 * @param password    password of the client
	 * @param celiac      is celiac?
	 * @param lactose     is lactose intolerant?
	 * @param driedFruits is dried fruits allergic?
	 */
	public Client(int id, String name, String address, String phoneNumber, String username, String password, boolean celiac, boolean lactose, boolean driedFruits) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.username = username;
		this.password = password;
		this.celiac = celiac;
		this.lactose = lactose;
		this.driedFruits = driedFruits;
		this.preferential = false;
		this.orderList = new OrderController();
	}

	/**
	 * Gets the identifier of the client
	 *
	 * @return identifier of the client
	 */
	@Override
	public int getId() {
		return id;
	}

	/**
	 * Gets the name of the client
	 *
	 * @return name of the client
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * Gets the address of the client
	 *
	 * @return address of the client
	 */
	@Override
	public String getAddress() {
		return address;
	}

	/**
	 * Gets the phone number of the client
	 *
	 * @return phone number of the client
	 */
	@Override
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Gets the username of the client
	 *
	 * @return username of the client
	 */
	@Override
	public String getUsername() {
		return username;
	}

	/**
	 * Gets the password of the client
	 *
	 * @return password of the client
	 */
	@Override
	public String getPassword() {
		return password;
	}

	/**
	 * Gets if the client is celiac
	 *
	 * @return true if the client is celiac
	 */
	@Override
	public boolean isCeliac() {
		return celiac;
	}

	/**
	 * Gets if the client is lactose intolerant
	 *
	 * @return true if the client is lactose intolerant
	 */
	@Override
	public boolean isLactose() {
		return lactose;
	}

	/**
	 * Gets if the client is dried fruits allergic
	 *
	 * @return true if the client is dried fruits allergic
	 */
	@Override
	public boolean isDriedFruits() {
		return driedFruits;
	}

	/**
	 * Gets if the client is preferential
	 *
	 * @return true if the client is preferential
	 */
	@Override
	public boolean isPreferential() {
		return preferential;
	}

	/**
	 * Sets if the client is preferential
	 *
	 * @param preferential true if the client is preferential
	 */
	@Override
	public void setPreferential(boolean preferential) {
		this.preferential = preferential;
	}

	/**
	 * Gets the list of Client
	 *
	 * @return list of Client
	 */
	@Override
	public OrderController_H getOrderList() {
		return orderList;
	}

	/**
	 * Overrides toString method
	 *
	 * @return string of the object
	 */
	@Override
	public String toString() {
		return "Client:\n\tidentifier= " + id + "\n\tname= " + name + "\n\taddress= " + address + "\n\tphoneNumber= " + phoneNumber
				+ "\n\tusername= " + username + "\n\tpassword= " + password + "\n\tceliac= " + celiac + "\n\tlactose= " + lactose
				+ "\n\tdriedFruits= " + driedFruits + "\n\tpreferential= " + preferential;
	}
}
