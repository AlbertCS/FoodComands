package grup06_practica3.models;

import grup06_practica3.controllers.OrderLineController;
import headers.controllers.OrderLineController_H;
import headers.models.Order_H;

import java.util.Calendar;
import java.util.Date;

/**
 * Author:  Aleix Marine Tena
 * Date:    21/11/16
 */
public class Order implements Order_H {

	/**
	 * Identifier of the order
	 */
	private final int id;

	/**
	 * Date of the order
	 */
	private final Date orderDate;

	/**
	 * List of OrderLine
	 */
	private final OrderLineController_H orderLineList;

	/**
	 * Price of the order
	 */
	private double price;

	/**
	 * Default constructor for the Order class
	 *
	 * @param id identifier of the order
	 */
	public Order(int id) {
		this.id = id;
		this.price = 0;
		this.orderDate = Calendar.getInstance().getTime();
		this.orderLineList = new OrderLineController();
	}

	/**
	 * @param id order id
	 * @param orderDate order date
	 * @param orderLineList order line list 
	 * @param price Price of the order
	 */
	public Order(int id, Date orderDate, OrderLineController_H orderLineList, double price) {
		this.id = id;
		this.price = price;
		this.orderDate = orderDate;
		this.orderLineList = orderLineList;
	}

	/**
	 * Gets the identifier of the Order
	 *
	 * @return identifier of the Order
	 */
	@Override
	public int getId() {
		return id;
	}

	/**
	 * Gets the price of the Order
	 *
	 * @return price of the Order
	 */
	@Override
	public double getPrice() {
		return price;
	}

	/**
	 * Sets the price of the Order
	 *
	 * @param price price of the Order
	 */
	@Override
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * Gets the date of the Order
	 *
	 * @return date of the Order
	 */
	@Override
	public Date getOrderDate() {
		return orderDate;
	}

	/**
	 * Gets the list of OrderLine
	 *
	 * @return list of OrderLine
	 */
	@Override
	public OrderLineController_H getOrderLineList() {
		return orderLineList;
	}

	/**
	 * Gets the list of OrderLine
	 *
	 * @return list of OrderLine
	 */
	@Override
	public String toString() {
		String msg = "";
		msg = msg + this.orderLineList.toString() + "\nID: " + this.getId() + "\nPrice: " + this.getPrice() + "\nDate of creation: " + this.getOrderDate();
		return msg;
	}
}