package grup06_practica3.controllers;

import grup06_practica3.exceptions.OrderLineFullListException;
import grup06_practica3.exceptions.OrderLineNotFoundException;
import grup06_practica3.models.OrderLine;
import headers.controllers.OrderLineController_H;
import headers.models.OrderLine_H;
import headers.models.Product_H;

/**
 * Author:	Aleix Marine Tena
 * Date:    21/11/16
 */
public class OrderLineController implements OrderLineController_H {

	/**
	 * List of OrderLine
	 */
	private final OrderLine_H[] orderLineList;

	/**
	 * Size of the list
	 */
	private int size;

	/**
	 * Unique identifier of orderLines
	 */
	private int nextId;

	/**
	 * Default constructor for the OrderLineController class
	 */
	public OrderLineController() {
		this.size = 0;
		this.orderLineList = new OrderLine_H[1000];

		this.nextId = 0;
	}

	/**
	 * Gets the list of OrderLine
	 *
	 * @return list of OrderLine
	 */
	@Override
	public OrderLine_H[] getOrderLineList() {
		return orderLineList;
	}

	/**
	 * Gets the size of the OrderLine list
	 *
	 * @return size of the OrderLine list
	 */
	@Override
	public int getSize() {
		return size;
	}

	/**
	 * Adds a new OrderLine
	 *
	 * @param product  product
	 * @param quantity quantity of the product
	 * @throws OrderLineFullListException thrown if list is full
	 */
	@Override
	public void addOrderLine(Product_H product, int quantity) throws OrderLineFullListException {
		if (size < orderLineList.length) {
			orderLineList[size] = new OrderLine(nextId, product, quantity);
			size++;
			nextId++;
		} else {
			throw new OrderLineFullListException();
		}
	}

	/**
	 * Gets the orderLine identified by the id
	 *
	 * @param id identifier of the orderLine
	 * @return orderLine identified by the id
	 * @throws OrderLineNotFoundException thrown if the orderLine does not exist
	 */
	@Override
	public OrderLine_H getOrderLine(int id) throws OrderLineNotFoundException {
		return findOrderLineById(id);
	}

	/**
	 * Removes a order line from the list
	 *
	 * @param id identifier of the order line
	 * @throws OrderLineNotFoundException thrown if the order line does not exist
	 */
	@Override
	public void removeOrderLine(int id) throws OrderLineNotFoundException {

		int i = 0;
		boolean found = false;

		// Find position of the product
		while ((i < size) && !found) {
			if (orderLineList[i].getId() == id) {
				found = true;
			} else {
				i++;
			}
		}

		if (found) {
			// Move orders
			// for (int j = i; j < size - 1; j++) {
			//    orderLineList[j] = orderLineList[j + 1];
			// }
			// ArrayCopy(src, srcPos, dst, dstPos, length)
			if (i < size - 1) {
				System.arraycopy(orderLineList, i + 1, orderLineList, i, size - 1 - i);
			} else {
				orderLineList[i] = null;
			}
			size--;
		} else {
			throw new OrderLineNotFoundException();
		}
	}

	/**
	 * Gets the orderLine identified by the id
	 *
	 * @param id identifier of the orderLine
	 * @return orderLine identified by the id
	 * @throws OrderLineNotFoundException thrown if the orderLine does not exist
	 */
	private OrderLine_H findOrderLineById(int id) throws OrderLineNotFoundException {
		for (int i = 0; i < size; i++) {
			if (orderLineList[i].getId() == id) {
				return orderLineList[i];
			}
		}
		throw new OrderLineNotFoundException();
	}
	/**
	 * do a toString method
	 */
	@Override
	public String toString()
	{
		String msg="";
		for (int i=0;i<this.size;i++)
		{
			msg=msg+this.getOrderLineList()[i].toString();
		}
		return msg;
	}
}
