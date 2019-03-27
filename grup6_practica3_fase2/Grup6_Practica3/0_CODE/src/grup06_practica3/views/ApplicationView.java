package grup06_practica3.views;

import grup06_practica3.controllers.ApplicationController;
import grup06_practica3.events.*;
import grup06_practica3.exceptions.*;
import grup06_practica3.utils.Settings;
import headers.controllers.ApplicationController_H;
import headers.views.ApplicationView_H;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import static grup06_practica3.utils.Settings.*;

public class ApplicationView extends JFrame implements ApplicationView_H {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Frame Variables
	 */

	private JButton b_add_product = new JButton("Add Product");
	private JButton b_load_products = new JButton("Load Products");
	private JButton b_remove_product = new JButton("Remove Product");
	private JButton b_display_product = new JButton("Display Product");
	private JButton b_add_client = new JButton("Add Client");
	private JButton b_display_client_orders = new JButton("Display Client Orders");
	private JButton b_add_order = new JButton("Add Order");
	private JButton b_copy_order = new JButton("Copy Order");
	private JButton b_load_client_orders = new JButton("Load Client Orders");
	private JButton b_save_client_orders = new JButton("Save Client Orders");

	/**
	 * Instance of the application controller
	 */
	private ApplicationController_H controller;

	/**
	 * Default constructor for the ApplicationView class
	 *
	 * @param controller instance of the application controller
	 */
	public ApplicationView(ApplicationController controller) {
		this.controller = controller;
	}

	/**
	 * Display menu using the text mode
	 */
	@Override
	public void runTextMenu() {
		try (Scanner scanner = new Scanner(System.in)) {
			int option;
			do {
				System.out.println(" 1.  Add a new product");
				System.out.println(" 2.  Load products from file");
				System.out.println(" 4.  Display product information");
				System.out.println(" 3.  Remove product identified by code");
				System.out.println(" 5.  Create a new client");
				System.out.println(" 6.  Display client orders");
				System.out.println(" 7.  Add a new order");
				System.out.println(" 8.  Copy an existing order");
				System.out.println(" 9.  Load clients and orders from file");
				System.out.println("10.  Save clients and orders into file");
				System.out.println("11.  Exit");
				System.out.println();
				System.out.print("Option: ");

				option = scanner.nextInt();
				scanner.nextLine();

				switch (option) {
					case ADD_PRODUCT: {
						addProduct();
						break;
					}
					case LOAD_PRODUCTS: {
						loadProducts();
						break;
					}
					case REMOVE_PRODUCT: {
						removeProduct();
						break;
					}
					case DISPLAY_PRODUCT: {
						displayProduct();
						break;
					}
					case ADD_CLIENT: {
						addClient();
						break;
					}
					case DISPLAY_CLIENT_ORDERS: {
						displayClientOrders();
						break;
					}
					case ADD_ORDER: {
						addOrder();
						break;
					}
					case COPY_ORDER: {
						copyOrder();
						break;
					}
					case LOAD_CLIENTS_ORDERS: {
						loadClientsAndOrders();
						break;
					}
					case SAVE_CLIENTS_ORDERS: {
						saveClientsAndOrders();
						break;
					}
					case EXIT: {
						System.out.println("Bye!");
						break;
					}
					default: {
						System.out.println("Error: invalid option");
						break;
					}
				}

				System.out.println();
			} while (option != EXIT);
			scanner.close();
		}

	}

	/**
	 * Display menu using the gui mode
	 */
	@Override
	public void runGuiMenu() {
		iniComponents();
	}

	private void iniComponents() {
		this.setTitle("Restaurant Manager");

		// get our container
		Container container = getContentPane();

		// Creating a BorderLayout to manage our items
		container.setLayout(new GridLayout(5, 2));

		b_add_product.addActionListener(new AddProductButtonListener(this));
		b_load_products.addActionListener(new LoadProductsButtonListener(this));
		b_remove_product.addActionListener(new RemoveProductButtonListener(this));
		b_display_product.addActionListener(new DisplayProductButtonListener(this));
		b_add_client.addActionListener(new AddClientButtonListener(this));
		b_display_client_orders.addActionListener(new DisplayClientOrdersButtonListener(this));
		b_add_order.addActionListener(new AddOrderButtonListener(this));
		b_copy_order.addActionListener(new CopyOrderButtonListener(this));
		b_load_client_orders.addActionListener(new LoadClientOrdersButtonListener(this));
		b_save_client_orders.addActionListener(new SaveClientOrdersButtonListener(this));

		container.add(b_add_product);
		container.add(b_load_products);
		container.add(b_remove_product);
		container.add(b_display_product);
		container.add(b_add_client);
		container.add(b_display_client_orders);
		container.add(b_add_order);
		container.add(b_copy_order);
		container.add(b_load_client_orders);
		container.add(b_save_client_orders);

		// We need to free memory when we close the window
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// We set the width and the height of our window.
		setSize(300, 300);
		// In other case, we won't be able to see the window.
		setVisible(true);
	}

	public void addProduct() {
		try {
			controller.addProductAction();
		} catch (ProductFullListException e) {
			controller.throwExceptionAction(e.getMessage());
		}
	}

	public void loadProducts() {
		try {
			controller.loadProductsFromFile(Settings.PRODUCTS_PATH);
		} catch (FileNotFoundException | ProductFullListException e) {
			controller.throwExceptionAction(e.getMessage());
		}
	}

	public void removeProduct() {
		try {
			controller.removeProductAction();
		} catch (ProductNotFoundException e) {
			System.out.println("Error: " + e);
		}
	}

	public void displayProduct() {
		try {
			controller.displayProductAction();
		} catch (ProductNotFoundException e) {
			System.out.println("Error: " + e);
		}
	}

	public void addClient() {
		controller.addClientAction();
	}

	public void displayClientOrders() {
		controller.displayClientOrderstAction();
	}

	public void addOrder() {
		try {
			controller.addOrderAction();
		} catch (ClientNotFoundException | OrderLineFullListException e) {
			controller.throwExceptionAction(e.getMessage());
		}
	}

	public void copyOrder() {
		try {
			controller.copyOrderAction();
		} catch (ClientNotFoundException | OrderNotFoundException e) {
			controller.throwExceptionAction(e.getMessage());
		}
	}

	public void loadClientsAndOrders() {
		try {
			try {
				controller.loadClientsFromFile(Settings.CLIENTS_PATH, Settings.ORDERS_PATH);
			} catch (NumberFormatException | ClientFullListException | OrderFullListException
					| OrderLineFullListException | ProductNotFoundException | ClientNotFoundException e) {
				controller.throwExceptionAction(e.getMessage());
			}
		} catch (FileNotFoundException e) {
			controller.throwExceptionAction(e.getMessage());
		}
	}

	public void saveClientsAndOrders() {
		try {
			controller.saveClientsToFile(Settings.CLIENTS_PATH, Settings.ORDERS_PATH);
		} catch (IOException | ClientNotFoundException | OrderNotFoundException
				| OrderLineNotFoundException e) {
			controller.throwExceptionAction(e.getMessage());
		}
	}
	
	public void showExceptionText(String text){
		System.out.println(text);
	}
	
	public void showExceptionGui(String text){
		JOptionPane.showMessageDialog(null, text, "Error", JOptionPane.ERROR_MESSAGE);
	}

}
