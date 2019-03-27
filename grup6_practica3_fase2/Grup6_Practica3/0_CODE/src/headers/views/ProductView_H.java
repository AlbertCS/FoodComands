package headers.views;

import grup06_practica3.exceptions.ProductFullListException;
import grup06_practica3.exceptions.ProductNotFoundException;

public interface ProductView_H {

	void showProductsText() throws ProductNotFoundException;

	void showProductsGui() throws ProductNotFoundException;

	void addProductText() throws ProductFullListException;

	void addProductGui();

	void removeProductText() throws ProductNotFoundException;

	void removeProductGui();

	void showProductText() throws ProductNotFoundException;

	void showProductGui();
}
