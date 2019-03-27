package headers.models;

/**
 * Author:  Albert Canellas Sole
 * Date:    20/11/16
 */
public interface Dish_H extends Product_H {

	/**
	 * Gets if the client is celiac
	 *
	 * @return true if the client is celiac
	 */
	boolean isCeliac();

	/**
	 * Gets if the client is lactose intolerant
	 *
	 * @return true if the client is lactose intolerant
	 */
	boolean isLactose();

	/**
	 * Gets if the client is allergic to dried fruits
	 *
	 * @return true if the client is allergic to dried fruits
	 */
	boolean isDriedFruits();
}
