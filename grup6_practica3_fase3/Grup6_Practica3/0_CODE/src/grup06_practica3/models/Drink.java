package grup06_practica3.models;

import headers.models.Drink_H;

/**
 * Author:  Albert Canellas Sole
 * Date:    20/11/16
 */
public class Drink extends Product implements Drink_H {

	/**
	 * Volume of the Drink
	 */
	private final double volume;

	/**
	 * Drink has alcohol?
	 */
	private final boolean hasAlcohol;

	/**
	 * Default constructor for the Drink class
	 *
	 * @param code       unique identifier of the product
	 * @param name       name of the product
	 * @param price      price of the product
	 * @param discount   discount of the product if the client is vip
	 * @param volume     volume of the Drink
	 * @param hasAlcohol drink has alcohol?
	 */
	public Drink(int code, String name, double price, double discount, double volume, boolean hasAlcohol) {
		super(code, name, price, discount);
		this.volume = volume;
		this.hasAlcohol = hasAlcohol;
	}

	/**
	 * Gets the volume of the drink
	 *
	 * @return volume of the drink
	 */
	@Override
	public double getVolume() {
		return volume;
	}

	/**
	 * Gets if the drink has alcohol
	 *
	 * @return true if the drink has alcohol, false otherwise
	 */
	@Override
	public boolean hasAlcohol() {
		return hasAlcohol;
	}

	/**
	 * Overrides toString method
	 *
	 * @return string of the object
	 */
	@Override
	public String toString() {
		return "Drink\n\tName: " + this.getName() + "\n\tPrice: " + this.getPrice() + "\n\tDiscount: " + this.getDiscount() + "\n\tVolume: " + this.getVolume() + "\n\tHas Alcohol? " + (this.hasAlcohol ? "Yes" : "No");
	}
}
