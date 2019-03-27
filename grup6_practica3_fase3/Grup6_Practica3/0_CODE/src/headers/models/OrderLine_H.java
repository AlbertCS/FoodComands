package headers.models;

public interface OrderLine_H {

	/**
	 * Gets the identifier of the OrderLine
	 *
	 * @return identifier of the OrderLine
	 */
	int getId();

	/**
	 * Gets the quantity of the product
	 *
	 * @return quantity of the product
	 */
	int getQuantity();

	/**
	 * Sets the quantity of the product
	 *
	 * @param quantity quantity of the product
	 */
	void setQuantity(int quantity);

	/**
	 * Gets the product
	 *
	 * @return product
	 */
	Product_H getProduct();
}