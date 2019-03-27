package headers.controllers;

import grup06_practica3.exceptions.ProductFullListException;
import grup06_practica3.exceptions.ProductNotFoundException;
import headers.models.Product_H;

/**
 * Author:  Marc Cabre Guinovart
 */
public interface ProductController_H {

	/**
	 * Gets the list of Product
	 *
	 * @return list of Product
	 */
	Product_H[] getProductList();

	/**
	 * Gets the size of the Product list
	 *
	 * @return size of the Product list
	 */
	int getSize();

	/**
	 * Adds a new Product
	 *
	 * @param product product
	 * @throws ProductFullListException thrown if list is full
	 */
	void addProduct(Product_H product) throws ProductFullListException;

	/**
	 * Gets the product identified by the code
	 *
	 * @param code identifier of the product
	 * @return product identified by the code
	 * @throws ProductNotFoundException thrown if the product does not exist
	 */
	Product_H getProduct(int code) throws ProductNotFoundException;

	/**
	 * Removes a product from the list
	 *
	 * @param code identifier of the product
	 * @throws ProductNotFoundException thrown if the product does not exist
	 */
	void removeProduct(int code) throws ProductNotFoundException;

	/**
	 * Removes a product from the list
	 *
	 * @param product product to remove
	 * @throws ProductNotFoundException thrown if the product does not exist
	 */
	void removeProduct(Product_H product) throws ProductNotFoundException;

	/**
	 * @param pos position of the product in the list
	 * @return product isntanc of the product in the selected position
	 * @throws ProductNotFoundException thrown when the product is not in the list
	 */
	Product_H findProductByPosition(int pos) throws ProductNotFoundException;
	
	/**
	 * 
	 * @param appMode appliction mode
	 * @throws ProductFullListException Thrown when the list is full
	 */
	void addProductAction(String appMode) throws ProductFullListException;
	
	/**
	 * 
	 * @param appMode appliction mode
	 * @throws ProductNotFoundException Thrown when the product is not in the list
	 */
	void removeProductAction(String appMode) throws ProductNotFoundException;
	
	/**
	 * 
	 * @param appMode appliction mode
	 * @throws ProductNotFoundException Thrown when the product is not in the list
	 */
	void displayProductAction(String appMode) throws ProductNotFoundException;
}
