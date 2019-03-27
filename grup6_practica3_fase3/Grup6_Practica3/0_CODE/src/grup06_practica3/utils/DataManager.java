package grup06_practica3.utils;

import grup06_practica3.controllers.ClientController;
import grup06_practica3.controllers.OrderLineController;
import grup06_practica3.controllers.ProductController;
import grup06_practica3.exceptions.*;
import grup06_practica3.models.Client;
import grup06_practica3.models.Dish;
import grup06_practica3.models.Drink;
import headers.controllers.ClientController_H;
import headers.controllers.OrderLineController_H;
import headers.controllers.ProductController_H;
import headers.models.Client_H;
import headers.models.Order_H;
import headers.models.Product_H;
import headers.utils.DataManager_H;

import java.io.*;
import java.sql.Date;
import java.util.Scanner;

public class DataManager implements DataManager_H {

	/**
	 * Imports products form file
	 *
	 * @param filename
	 *            name of the file
	 * @return list of products
	 * @throws FileNotFoundException
	 *             thrown if the file does not exist
	 * @throws ProductFullListException
	 *             thrown if the list is full
	 */
	@Override
	public ProductController_H loadProductsFromFile(String filename)
			throws FileNotFoundException, ProductFullListException {
		String tmpLine;
		ProductController_H tempList = new ProductController();
		try (Scanner input = new Scanner(new File(filename))) {
			while (input.hasNextLine()) {
				tmpLine = input.nextLine();
				// If the line is not a comment line
				if (!tmpLine.substring(0, 1).equals("#")) {
					String[] fields = tmpLine.split(";");
					if (fields.length == 8 || fields.length == 7) {
						switch (fields[0]) {
						case "DISH": {
							tempList.addProduct(new Dish(Integer.parseInt(fields[1]), fields[2],
									Double.parseDouble(fields[3]), Double.parseDouble(fields[4]),
									fields[5].equals("true"), fields[6].equals("true"), fields[7].equals("true")));
							break;
						}
						case "DRINK": {
							tempList.addProduct(new Drink(Integer.parseInt(fields[1]), fields[2],
									Double.parseDouble(fields[3]), Double.parseDouble(fields[4]),
									Double.parseDouble(fields[5]), fields[6].equals("true")));
							break;
						}

						}
					}
				}
			}
			input.close();
		}

		return tempList;
	}

	/**
	 * Imports clients from file
	 *
	 * @param filename
	 *            name of the file
	 * @return list of clients
	 * @throws FileNotFoundException
	 *             thrown if the file does not exist
	 * @throws ClientFullListException
	 *             thrown if the list is full
	 */
	@Override
	public ClientController_H loadClientFromFile(String filename)
			throws FileNotFoundException, ClientFullListException {
		String tmpLine;
		ClientController_H tempList = new ClientController();
		try (Scanner input = new Scanner(new File(filename))) {
			while (input.hasNextLine()) {
				tmpLine = input.nextLine();
				// If the line is not a comment line
				if (!tmpLine.substring(0, 1).equals("#")) {
					String[] fields = tmpLine.split(";");
					if (fields.length == 9) {
						tempList.addClient((new Client(Integer.parseInt(fields[0]), fields[1], fields[2], fields[3],
								fields[4], fields[5], fields[6].equals("true"), fields[7].equals("true"),
								fields[8].equals("true"))));
					}
				}
			}
			input.close();
		}

		return tempList;
	}

	/**
	 * Imports orders from file
	 *
	 * @param clients
	 *            list of clients
	 * @param filename
	 *            name of the file
	 * @throws FileNotFoundException
	 *             thrown if the file does not exist
	 * @throws OrderFullListException
	 *             thrown if the list is full
	 * @throws OrderLineFullListException
	 *             thrown if the list is full
	 * @throws ProductNotFoundException Thrown when the product is no found in the lists
	 * @throws NumberFormatException Thrwon when number format exception occurs
	 * @throws ClientNotFoundException Thrown when the client is not found in the list
	 */
	@Override
	public void loadOrdersFromFile(ClientController_H clients, String filename, ProductController_H products)
			throws FileNotFoundException, OrderFullListException, OrderLineFullListException, NumberFormatException,
			ProductNotFoundException, ClientNotFoundException {
		String tmpLine;
		try (Scanner input = new Scanner(new File(filename))) {
			while (input.hasNextLine()) {
				tmpLine = input.nextLine();
				// If the line is not a comment line
				if (!tmpLine.substring(0, 1).equals("#")) {
					String[] fields = tmpLine.split(";");
					if (fields.length == 5) {
						int clientId = Integer.parseInt(fields[1]);
						String lines_temp = fields[4].substring(1, fields[4].length() - 1);
						String[] lines = lines_temp.split("-");
						OrderLineController_H order_lines = new OrderLineController();
						for (int j = 0; j < lines.length; j++) {
							String[] columns = lines[j].split(":");
							order_lines.addOrderLine(products.getProduct(Integer.parseInt(columns[0])),
									Integer.parseInt(columns[1]));
						}
						Order_H order = clients.getClient(clientId).getOrderList()
								.addOrder(order_lines.getOrderLineList()[0]);
						for (int i = 1; i < order_lines.getSize(); i++) {
							order.getOrderLineList().addOrderLine(order_lines.getOrderLineList()[i].getProduct(),
									order_lines.getOrderLineList()[i].getQuantity());
						}
					}
				}
			}
			input.close();
		}
	}

	/**
	 * Exports products to file
	 *
	 * @param products
	 *            list of products
	 * @param filename
	 *            name of the file
	 * @throws IOException
	 *             thrown if the file cannot be opened
	 */
	@Override
	public void writeProductsToFile(ProductController_H products, String filename) throws IOException {
		Product_H product;
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
			writer.write(Settings.PRODUCTS_HEADER);
			for (int i = 0; i < products.getSize(); i++) {
				product = products.getProductList()[i];
				if (product instanceof Dish) {
					writer.write("DISH;" + product.getCode() + ";" + product.getName() + ";" + product.getPrice() + ";"
							+ product.getDiscount() + ";" + ((Dish) product).isCeliac() + ";"
							+ ((Dish) product).isLactose() + ";" + ((Dish) product).isDriedFruits() + "\n");
				}
				if (product instanceof Drink) {
					writer.write("DRINK;" + product.getCode() + ";" + product.getName() + ";" + product.getPrice() + ";"
							+ product.getDiscount() + ";" + ((Drink) product).getVolume() + ";"
							+ ((Drink) product).hasAlcohol() + "\n");
				}
			}
			writer.close();
		}
	}

	/**
	 * Exports clients to file
	 *
	 * @param clients
	 *            list of clients
	 * @param filename
	 *            name of the file
	 * @throws IOException
	 *             thrown if the file cannot be opened
	 */
	@Override
	public void writeClientToFile(ClientController_H clients, String filename) throws IOException {
		Client_H client;
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
			writer.write(Settings.CLIENTS_HEADER);
			for (int i = 0; i < clients.getSize(); i++) {
				client = clients.getClientList()[i];
				writer.write(client.getId() + ";" + client.getName() + ";" + client.getAddress() + ";"
						+ client.getUsername() + ";" + client.getPassword() + ";" + client.getPhoneNumber() + ";"
						+ client.isCeliac() + ";" + client.isLactose() + ";" + client.isDriedFruits() + "\n");

			}
			writer.close();
		}
	}

	/**
	 * Exports list of orders to file
	 *
	 * @param filename
	 *            name of the file
	 * @throws IOException
	 *             thrown if the file cannot be opened
	 * @throws OrderNotFoundException
	 *             if the order not exists
	 * @throws OrderLineNotFoundException
	 *             if the order line not exists
	 */
	@Override
	public void writeOrdersToFile(ClientController_H clients, String filename)
			throws IOException, OrderNotFoundException, OrderLineNotFoundException {
		Client_H client;
		Order_H order;
		String line_to_write = "";
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
			writer.write(Settings.ORDERS_HEADER);
			for (int i = 0; i < clients.getSize(); i++) {
				client = clients.getClientList()[i];
				for (int j = 0; j < client.getOrderList().getSize(); j++) {
					order = client.getOrderList().getOrderList()[j];
					line_to_write += order.getId() + ";" + client.getId() + ";" + order.getOrderDate().getTime() + ";"
							+ order.getPrice() + ";[";
					for (int k = 0; k < order.getOrderLineList().getSize(); k++) {
						if (k > 0) {
							line_to_write += "-";
						}
						line_to_write += order.getOrderLineList().getOrderLineList()[k].getProduct().getCode() + ":"
								+ order.getOrderLineList().getOrderLineList()[k].getQuantity();
					}
					line_to_write += "]";
					writer.write(line_to_write + "\n");
					line_to_write = "";
				}
			}
			writer.close();
		}
	}
}
