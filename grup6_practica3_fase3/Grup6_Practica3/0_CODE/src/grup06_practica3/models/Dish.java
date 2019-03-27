package grup06_practica3.models;

import headers.models.Dish_H;

/**
 * Author:  Albert Canellas Sole
 * Date:    20/11/16
 */
public class Dish extends Product implements Dish_H {

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
	 * Default constructor for the Dish class
	 *
	 * @param code        unique identifier of the product
	 * @param name        name of the product
	 * @param price       price of the product
	 * @param discount    discount of the product if the client is vip
	 * @param celiac      is celiac?
	 * @param lactose     is lactose intolerance?
	 * @param driedFruits is dried fruits allergy?
	 */
	public Dish(int code, String name, double price, double discount, boolean celiac, boolean lactose, boolean driedFruits) {
		super(code, name, price, discount);
		this.celiac = celiac;
		this.lactose = lactose;
		this.driedFruits = driedFruits;
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
	 * Gets if the client is allergic to dried fruits
	 *
	 * @return true if the client is allergic to dried fruits
	 */
	@Override
	public boolean isDriedFruits() {
		return driedFruits;
	}

	/**
	 * Overrides toString method
	 *
	 * @return string of the object
	 */
	@Override
	public String toString() {
		return "Plate\n\tName: " + this.getName() + "\n\tPrice: " + this.getPrice() + "\n\tDiscount: " + this.getDiscount() +
				"\n\tCeliac: " + (this.celiac ? "Yes" : "No") + "\n\tLacose: " + (this.lactose ? "Yes" : "No") + "\n\tDriedFruits: " + (this.driedFruits ? "Yes" : "No");
	}
}
