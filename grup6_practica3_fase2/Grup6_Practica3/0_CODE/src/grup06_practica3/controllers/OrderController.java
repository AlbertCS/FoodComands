package grup06_practica3.controllers;

import grup06_practica3.exceptions.OrderFullListException;
import grup06_practica3.exceptions.OrderLineFullListException;
import grup06_practica3.exceptions.OrderNotFoundException;
import grup06_practica3.models.Order;
import grup06_practica3.utils.Settings;
import grup06_practica3.views.OrderView;
import headers.controllers.OrderController_H;
import headers.controllers.ProductController_H;
import headers.models.Client_H;
import headers.models.OrderLine_H;
import headers.models.Order_H;
import headers.views.OrderView_H;

/**
 * Author:	Aleix Marine Tena
 * Date:    21/11/16
 */
public class OrderController implements OrderController_H {

	/**
	 * List of OrderLine
	 */
	private final Order_H[] orderList;

	/**
	 * Size of the list
	 */
	private int size;

	/**
	 * Unique identifier of orders
	 */
	private int nextId;

	private OrderView_H view;
	
	/**
	 * Default constructor of the OrderController class
	 */
	public OrderController() {
		this.size = 0;
		this.orderList = new Order_H[1000];

		this.nextId = 0;
		view = new OrderView(this);
	}

	/**
	 * Gets the list of Order
	 *
	 * @return list of Order
	 */
	@Override
	public Order_H[] getOrderList() {
		return orderList;
	}

	/**
	 * Gets the size of the Order list
	 *
	 * @return size of the Order list
	 */
	@Override
	public int getSize() {
		return size;
	}

	/**
	 * Adds a new Order
	 *
	 * @param orderLine orderLine to add in the list
	 * @return new Order
	 * @throws OrderFullListException     thrown if list is full
	 * @throws OrderLineFullListException thrown if list is full
	 */
	@Override
	public Order_H addOrder(OrderLine_H orderLine) throws OrderFullListException, OrderLineFullListException {
		if (size < orderList.length) {
			orderList[size] = new Order(nextId);
			orderList[size].getOrderLineList().addOrderLine(orderLine.getProduct(), orderLine.getQuantity());
			size++;
			nextId++;

			return orderList[size - 1];
		} else {
			throw new OrderFullListException();
		}
	}

	/**
	 * Gets the order identified by the id
	 *
	 * @param id identifier of the order
	 * @return order identified by the id
	 * @throws OrderNotFoundException thrown if the order does not exist
	 */
	@Override
	public Order_H getOrder(int id) throws OrderNotFoundException {
		return findOrderById(id);
	}

	/**
	 * Removes a order from the list
	 *
	 * @param id identifier of the order
	 * @throws OrderNotFoundException thrown if the order does not exist
	 */
	@Override
	public void removeOrder(int id) throws OrderNotFoundException {

		int i = 0;
		boolean found = false;

		// Find position of the product
		while ((i < size) && !found) {
			if (orderList[i].getId() == id) {
				found = true;
			} else {
				i++;
			}
		}

		if (found) {
			// Move orders
			// for (int j = i; j < size - 1; j++) {
			//    orderList[j] = orderList[j + 1];
			// }
			// ArrayCopy(src, srcPos, dst, dstPos, length)
			if (i < size - 1) {
				System.arraycopy(orderList, i + 1, orderList, i, size - 1 - i);
			} else {
				orderList[i] = null;
			}
			size--;
		} else {
			throw new OrderNotFoundException();
		}
	}

	/**
	 * Gets the order identified by the id
	 *
	 * @param id identifier of the order
	 * @return order identified by the id
	 * @throws OrderNotFoundException thrown if the order does not exist
	 */
	private Order_H findOrderById(int id) throws OrderNotFoundException {
		for (int i = 0; i < size; i++) {
			if (orderList[i].getId() == id) {
				return orderList[i];
			}
		}
		throw new OrderNotFoundException();
	}
	
	/**
	 * @param appMode application mode
	 */
	public void displayOrdersAction(String appMode){

		if (appMode.equals(Settings.TEXT_MODE)) {
			view.showOrdersText();
		} else {
			view.showOrdersGui();
		}
	}
	
	/**
	 * @throws OrderLineFullListException thrown when the orderline list is full
	 * 
	 */
	public void addOrderAction(String appMode, ProductController_H products, Client_H client) throws OrderLineFullListException{
		if (appMode.equals(Settings.TEXT_MODE)) {
			view.createOrderText(client, products);
		} else {
			view.createOrderGui(client, products);
		}
	}

	@Override
	public void copyOrderAction(String appMode, Client_H client) throws OrderNotFoundException {
		if (appMode.equals(Settings.TEXT_MODE)) {
			view.copyOrderText(client);
		} else {
			view.copyOrderGui(client);
		}
		
	}

}