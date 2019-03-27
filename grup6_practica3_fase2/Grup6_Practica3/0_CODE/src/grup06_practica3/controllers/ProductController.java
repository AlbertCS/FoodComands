package grup06_practica3.controllers;

import grup06_practica3.exceptions.ProductFullListException;
import grup06_practica3.exceptions.ProductNotFoundException;
import grup06_practica3.utils.Settings;
import grup06_practica3.views.ProductView;
import headers.controllers.ProductController_H;
import headers.models.Product_H;
import headers.views.ProductView_H;

/**
 * Author: Marc Cabre Guinovart
 */
public class ProductController implements ProductController_H {

	/**
	 * List of Product
	 */
	private final Product_H[] productList;

	/**
	 * Size of the list
	 */
	private int size;
	
	private ProductView_H view;

	/**
	 * Default constructor for the ProductController class
	 */
	public ProductController() {
		this.size = 0;
		this.productList = new Product_H[1000];
		
		view = new ProductView(this);
	}

	/**
	 * Gets the list of Product
	 *
	 * @return list of Product
	 */
	@Override
	public Product_H[] getProductList() {
		return productList;
	}

	/**
	 * Gets the size of the Product list
	 *
	 * @return size of the Product list
	 */
	@Override
	public int getSize() {
		return size;
	}

	/**
	 * Adds a new Product
	 *
	 * @param product product
	 * @throws ProductFullListException thrown if list is full
	 */
	@Override
	public void addProduct(Product_H product) throws ProductFullListException {
		if (size < productList.length) {
			productList[size] = product;
			size++;
		} else {
			throw new ProductFullListException();
		}
	}

	/**
	 * Gets the product identified by the code
	 *
	 * @param code identifier of the product
	 * @return product identified by the code
	 * @throws ProductNotFoundException thrown if the product does not exist
	 */
	@Override
	public Product_H getProduct(int code) throws ProductNotFoundException {
		return findProductById(code);
	}

	/**
	 * Removes a product from the list
	 *
	 * @param code identifier of the product
	 * @throws ProductNotFoundException thrown if the product does not exist
	 */
	@Override
	public void removeProduct(int code) throws ProductNotFoundException {

		int i = 0;
		boolean found = false;

		// Find position of the product
		while ((i < size) && !found) {
			if (productList[i].getCode() == code) {
				found = true;
			} else {
				i++;
			}
		}

		if (found) {
			if (i < size - 1) {
				System.arraycopy(productList, i + 1, productList, i, size - 1 - i);
			} else {
				productList[i] = null;
			}
			size--;
		} else {
			throw new ProductNotFoundException();
		}
	}

	/**
	 * Removes a product from the list
	 *
	 * @param product product to remove
	 * @throws ProductNotFoundException thrown if the product does not exist
	 */
	@Override
	public void removeProduct(Product_H product) throws ProductNotFoundException {
		removeProduct(product.getCode());
	}

	/**
	 * Gets the product identified by the code
	 *
	 * @param code identifier of the product
	 * @return product identified by the code
	 * @throws ProductNotFoundException thrown if the product does not exist
	 */
	private Product_H findProductById(int code) throws ProductNotFoundException {
		for (int i = 0; i < size; i++) {
			if (productList[i].getCode() == code) {
				return productList[i];
			}
		}
		throw new ProductNotFoundException();
	}

	/**
	 * Gets the product by de position in the list
	 *
	 * @param pos position of the product in the list
	 * @return product selcted product
	 * @throws ProductNotFoundException Thrown when the product is not in the list
	 */
	public Product_H findProductByPosition(int pos) throws ProductNotFoundException {
		if (pos < size) {
			return productList[size];
		}
		throw new ProductNotFoundException();
	}

	/**
	 * @param appMode application mode
	 * @throws ProductFullListException Thrown when the list is full
	 */
	public void addProductAction(String appMode) throws ProductFullListException {
		if (appMode.equals(Settings.TEXT_MODE)) {
			view.addProductText();
		} else {
			view.addProductGui();
		}
	}

	/**
	 * Calls the Remove Product actio in the product view
	 * 
	 * @param appMode application mode
	 * @throws ProductNotFoundException Thrown when the product is not in the list
	 */
	public void removeProductAction(String appMode) throws ProductNotFoundException {
		if (appMode.equals(Settings.TEXT_MODE)) {
			view.removeProductText();
		} else {
			view.removeProductGui();
		}
	}

	/**
	 * Calls the display Product actio in the product view
	 * 
	 * @param appMode application mode
	 * @throws ProductNotFoundException Thrown when the product is not in the list
	 */
	@Override
	public void displayProductAction(String appMode) throws ProductNotFoundException {
		if (appMode.equals(Settings.TEXT_MODE)) {
			view.showProductText();
		} else {
			view.showProductGui();
		}
	}


}
