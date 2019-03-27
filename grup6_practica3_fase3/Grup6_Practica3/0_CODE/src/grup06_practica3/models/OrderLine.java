package grup06_practica3.models;

import headers.models.OrderLine_H;
import headers.models.Product_H;

/**
 * Author:  Aleix Marine Tena
 * Date:    21/11/16
 */
public class OrderLine implements OrderLine_H {

	/**
	 * Identifier of the orderLine
	 */
	private final int id;

	/**
	 * Product
	 */
	private final Product_H product;

	/**
	 * Quantity of the product
	 */
	private int quantity;

	/**
	 * Default constructor for the OrderLine class
	 *
	 * @param id       identifier of the orderLine
	 * @param product  product
	 * @param quantity quantity of the product
	 */
	public OrderLine(int id, Product_H product, int quantity) {
		this.id = id;
		this.product = product;
		this.quantity = quantity;
	}

	/**
	 * Gets the identifier of the OrderLine
	 *
	 * @return identifier of the OrderLine
	 */
	@Override
	public int getId() {
		return id;
	}

	/**
	 * Gets the quantity of the product
	 *
	 * @return quantity of the product
	 */
	@Override
	public int getQuantity() {
		return quantity;
	}

	/**
	 * Sets the quantity of the product
	 *
	 * @param quantity quantity of the product
	 */
	@Override
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * Gets the product
	 *
	 * @return product
	 */
	@Override
	public Product_H getProduct() {
		return product;
	}

	/**
	 * toString method
	 *
	 * @return text from orderline
	 */
	@Override
	public String toString() {
		String msg;
		msg = "\nProduct: " + this.product.getName() + " Quantity: " + this.quantity;
		return msg;
	}
}
