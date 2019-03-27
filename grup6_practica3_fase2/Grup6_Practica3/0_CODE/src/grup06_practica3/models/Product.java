package grup06_practica3.models;

import headers.models.Product_H;

/**
 * Author:  Albert Canellas Sole
 * Date:    20/11/16
 */
public abstract class Product implements Product_H {

	/**
	 * Unique identifier of the product
	 */
	private final int code;

	/**
	 * Name of the product
	 */
	private final String name;

	/**
	 * Price of the product
	 */
	private final double price;

	/**
	 * Discount of the product if the client is vip
	 */
	private final double discount;

	/**
	 * Default constructor for the Product class
	 *
	 * @param code     unique identifier of the product
	 * @param name     name of the product
	 * @param price    price of the product
	 * @param discount discount of the product if the client is vip
	 */
	public Product(int code, String name, double price, double discount) {
		this.code = code;
		this.name = name;
		this.price = price;
		this.discount = discount;
	}

	/**
	 * Gets the unique identifier of the product
	 *
	 * @return unique identifier of the product
	 */
	@Override
	public int getCode() {
		return code;
	}

	/**
	 * Gets the name of the product
	 *
	 * @return name of the product
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * Gets the price of the product
	 *
	 * @return price of the product
	 */
	@Override
	public double getPrice() {
		return price;
	}

	/**
	 * Gets the discount of the product if the client is vip
	 *
	 * @return discount of the product if the client is vip
	 */
	@Override
	public double getDiscount() {
		return discount;
	}

	/**
	 * Overrides toString method
	 *
	 * @return string of the object
	 */
	@Override
	public String toString() {
		return "Product [code=" + code + ", name=" + name + ", price=" + price + ", discount=" + discount
				+ ", getCode()=" + getCode() + ", getName()=" + getName() + ", getPrice()=" + getPrice()
				+ ", getDiscount()=" + getDiscount() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
}
