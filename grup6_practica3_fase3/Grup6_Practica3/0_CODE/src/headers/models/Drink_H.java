package headers.models;

/**
 * Author:  Albert Canellas Sole
 * Date:    20/11/16
 */
public interface Drink_H extends Product_H {

	/**
	 * Gets the volume of the drink
	 *
	 * @return volume of the drink
	 */
	double getVolume();

	/**
	 * Gets if the drink has alcohol
	 *
	 * @return true if the drink has alcohol, false otherwise
	 */
	boolean hasAlcohol();
}
