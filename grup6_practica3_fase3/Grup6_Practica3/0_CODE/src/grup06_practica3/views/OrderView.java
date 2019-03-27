package grup06_practica3.views;

import grup06_practica3.controllers.OrderController;
import grup06_practica3.exceptions.OrderFullListException;
import grup06_practica3.exceptions.OrderLineFullListException;
import grup06_practica3.exceptions.OrderLineNotFoundException;
import grup06_practica3.exceptions.OrderNotFoundException;
import grup06_practica3.models.OrderLine;
import headers.controllers.ProductController_H;
import headers.models.Client_H;
import headers.models.Dish_H;
import headers.models.OrderLine_H;
import headers.views.OrderView_H;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

/**
 * Author: Aleix Marin� i Tena
 * Date: 5/12/2016
 */
public class OrderView extends JFrame implements OrderView_H {
	private Scanner kb = new Scanner(System.in);
	private static final long serialVersionUID = 1L;
	private OrderController orderController;

	public OrderView(OrderController orderController) {
		this.orderController = orderController;
	}

	/**
	 * Display a text of the Order that corresponds with the identifier
	 *
	 * @throws OrderNotFoundException thrown if the client does not exist
	 */
	@Override
	public void showOrderText(int ID) throws OrderNotFoundException {
		try {
			System.out.println(this.orderController.getOrder(ID));
		} catch (OrderNotFoundException e) {
			System.err.println("Error: " + e);
		}

	}

	/**
	 * Display an order that corresponds with the identifier in a graphical mode
	 *
	 * @param ID id of the order we want to print
	 * @throws OrderNotFoundException thrown if the order does not exist
	 */
	@Override
	public void showOrderGui(int ID) throws OrderNotFoundException {
		JFrame window = new JFrame();
		Container Container1 = window.getContentPane();
		window.setTitle("Display Order");
		window.setContentPane(Container1);
		window.setDefaultCloseOperation(EXIT_ON_CLOSE);
		window.setSize(1200, 200);
		window.setLocation(100, 0);
		window.setVisible(true);
		Container1.setLayout(new FlowLayout());
		try {
			Container1.add(new JLabel(this.orderController.getOrder(ID).toString() + "\nIdentifier: " + this.orderController.getOrder(ID).getId() + " \nDate: " + this.orderController.getOrder(ID).getOrderDate() + " \nPrice: " + this.orderController.getOrder(ID).getPrice() + " \nNumber of products: " + this.orderController.getOrder(ID).getOrderLineList().getSize()));
		} catch (OrderNotFoundException e) {
			System.err.println("Error: " + e);
		}
	}

	/**
	 * Display a text of the List of Order from the history of a client
	 */
	@Override
	public void showOrdersText() {
		for (int i = orderController.getSize()-1; 0 <= i; i--) {
			System.out.println(orderController.getOrderList()[i]);
		}

	}

	/**
	 * Display a text of the List of Order from the history of a client
	 *
	 */
	@Override
	public void showOrdersGui() {
		JFrame window = new JFrame();
		Container Container1 = window.getContentPane();
		window.setTitle("Display Orders");
		window.setContentPane(Container1);
		window.setDefaultCloseOperation(EXIT_ON_CLOSE);
		window.setSize(1200, 200);
		window.setLocation(100, 0);
		window.setVisible(true);
		Container1.setLayout(new FlowLayout());
		for (int i = orderController.getSize()-1; 0 <= i; i--)
		{
			Container1.add(new JLabel(orderController.getOrderList()[i].getOrderLineList().getOrderLineList().toString() + "\nIdentifier: " + orderController.getOrderList()[i].getId() + " \nDate: " + orderController.getOrderList()[i].getOrderDate() +
					" \nPrice: " + orderController.getOrderList()[i].getPrice() + " \nNumber of products: " + orderController.getOrderList()[i].getOrderLineList().getSize()));
		}
	}

	/**
	 * interface with user to create an order
	 *
	 * @param client instance of client
	 * @param menu   instance of productlist (menu)
	 * @throws OrderLineFullListException thrown when orderLine list is full
	 */
	@Override
	public void createOrderText(Client_H client, ProductController_H menu) throws OrderLineFullListException{
		boolean flag = false, bucle = true, b = true;
		int k = -1, compta = 0;
		
		String tmp;
		while (b) {
			while (bucle) {
				flag = false;
				while (flag == false) {
					for (int i=0; i<menu.getSize();i++)
					{
						System.out.println(menu.getProductList()[i].toString());
					}
					System.out.println("Which product do you want to add?");
					tmp = kb.nextLine();
					for (int i = 0; i < menu.getSize(); i++) {
						if (menu.getProductList()[i].getName().equals(tmp)) {
							flag = true;
							k = i;
						}
					}
					if (flag == false) {
						System.out.println("Sorry, this product is not on our menu. Try again.");
					}
				}
				int quant = 0;
				while (quant < 1 || quant > 30) {
					try {
						System.out.println("How many units of this product do you want to add? ");
						quant = kb.nextInt();
						kb.nextLine();
						if (quant < 1 || quant > 30) {
							System.out.println("Sorry, you cannot add this quantity of product. Try again.");
						}
					} catch (NumberFormatException e) {
						System.out.println("Error: " + e);
						;
					}
				}
				compta++;
				OrderLine_H temp = new OrderLine(0, menu.getProductList()[k], quant);
				if (compta == 1) {
					try {
						this.orderController.addOrder(temp);
					} catch (OrderFullListException e) {
						System.err.println("Error: " + e);
					}
				} else {
					try {
						this.orderController.getOrderList()[this.orderController.getSize() - 1].getOrderLineList().addOrderLine(temp.getProduct(), temp.getQuantity());
					} catch (OrderLineFullListException e) {
						System.err.println("Error: " + e);
					}
				}
				if (menu.getProductList()[k] instanceof Dish_H) 
				{
				if (((client.isCeliac() && ((Dish_H) menu.getProductList()[k]).isCeliac()) || (client.isDriedFruits() && ((Dish_H) menu.getProductList()[k]).isDriedFruits()) || (client.isLactose() && ((Dish_H) menu.getProductList()[k]).isLactose()))) {
					while (flag) {
						System.out.println("Hey! seems that you just added a product that contains alergens which you are alergic. Do you want to remove it?");
						tmp = kb.nextLine();
						if (tmp.equals("no")) {
							flag = false;
						} else if (tmp.equals("yes")) {
							flag = false;
							try {
								this.orderController.getOrderList()[this.orderController.getSize() - 1].getOrderLineList().removeOrderLine(this.orderController.getOrderList()[this.orderController.getSize() - 1].getOrderLineList().getSize() - 1);
							} catch (OrderLineNotFoundException e) {
								// TODO: Si peta aquí miradlo bien porque no debería pasar
								System.out.println("Error: " + e);
							}
						}
						if (flag == true) {
							System.out.println("Sorry, i'm not understanding you, can you repeat?");
						}
					}
				}
				}
				flag = true;
				while (flag) {
					System.out.println("Do you want to add another product from the menu? (yes/no)");
					tmp = kb.nextLine();
					if (tmp.equals("no")) {
						flag = false;
						bucle = false;
					} else if (tmp.equals("yes")) {
						flag = false;
					}
					if (flag == true) {
						System.out.println("Sorry, i'm not understanding you, can you repeat?");
					}
				}
			}
			double price = 0;
			for (int i = 0; i < this.orderController.getOrderList()[this.orderController.getSize() - 1].getOrderLineList().getSize(); i++) {
				if (client.isPreferential()) {
					price = price+(this.orderController.getOrderList()[this.orderController.getSize() - 1].
							getOrderLineList().getOrderLineList()[i].getProduct().getPrice() * 
							(1 - this.orderController.getOrderList()[this.orderController.getSize() - 1].
									getOrderLineList().getOrderLineList()[i].getProduct().getDiscount() / 100))*
							this.orderController.getOrderList()[this.orderController.getSize() - 1].getOrderLineList().getOrderLineList()[i].getQuantity();
				} else {
					price = price+this.orderController.getOrderList()[this.orderController.getSize() - 1].getOrderLineList().getOrderLineList()[i].getProduct().getPrice()*this.orderController.getOrderList()[this.orderController.getSize() - 1].getOrderLineList().getOrderLineList()[i].getQuantity();
				}
			}
			this.orderController.getOrderList()[this.orderController.getSize() - 1].setPrice(price);
			System.out.println("Your order contains this so far...\n");
			System.out.println(this.orderController.getOrderList()[this.orderController.getSize() - 1]);
			while (!flag) {
				System.out.println("Do you want to confirm your order?");
				tmp = kb.nextLine();
				if (tmp.equals("yes")) {
					flag = true;
					b = false;
					bucle=false;
				} else if (tmp.equals("no")) {
					flag = true;
					b=true;
					bucle=true;
				}
				if (!flag) {
					System.out.println("Sorry, i'm not understanding you, can you repeat?");
				}
			}
		}
		System.out.println("Your ID order is " + this.orderController.getOrderList()[this.orderController.getSize() - 1].getId());
		System.out.println("Bye!");
	}

	@Override
	public void createOrderGui(Client_H client, ProductController_H menu) throws OrderLineFullListException{
		String msg = null;
		boolean correct = false, choose, bucle = true, b = true;
		int k = -1, option = 0, compta = 0, quant;
		double price = 0;
		JFrame window = new JFrame();
		Container Container1 = window.getContentPane();
		window.setTitle("Create new Order");
		window.setContentPane(Container1);
		window.setSize(800, 600);
		window.setLocation(100, 0);
		window.setVisible(true);

		Container1.setLayout(new FlowLayout());
		while (b) {
			while (bucle) {
				correct=false;
				while (!correct) {
					for (int i=0; i<menu.getSize();i++)
					{
						Container1.add(new JLabel(menu.getProductList()[i].toString()));
					}
					msg = JOptionPane.showInputDialog("Introduce product you want to add (introduce name):");
					for (int i = 0; i < menu.getSize(); i++) {
						if (menu.getProductList()[i].getName().equals(msg)) {
							correct = true;
							k = i;
						}
					}
					if (correct == false) {
						JOptionPane.showMessageDialog(null, "Sorry, this product is not on our menu. Try again.");
					}
				}
				quant = 0;
				while (quant < 1 || quant > 30) {
					try {
						msg = JOptionPane.showInputDialog(null, "How many units of this product do you want to add? minimum 1, maximum 30");
						quant = Integer.parseInt(msg);
					} catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(null, "You must introduce a number. Try again.");
					}
				}
				compta++;
				OrderLine_H temp = new OrderLine(0, menu.getProductList()[k], quant);
				if (compta == 1) {
					try {
						this.orderController.addOrder(temp);
					} catch (OrderFullListException e) {
						System.err.println("Error: " + e);
					}
				} else {
					try {
						this.orderController.getOrderList()[this.orderController.getSize() - 1].getOrderLineList().addOrderLine(temp.getProduct(), temp.getQuantity());
					} catch (OrderLineFullListException e) {
						System.err.println("Error: " + e);
					}
				}
				if (menu.getProductList()[k] instanceof Dish_H) 
				{
				if (((client.isCeliac() && ((Dish_H) menu.getProductList()[k]).isCeliac()) || (client.isDriedFruits() && ((Dish_H) menu.getProductList()[k]).isDriedFruits()) || (client.isLactose() && ((Dish_H) menu.getProductList()[k]).isLactose()))) {					
					option = JOptionPane.showConfirmDialog(null, "Hey! seems that you just added a product that contains alergens which you are alergic. Do you want to remove it?", "QUESTION", JOptionPane.YES_NO_OPTION);
					choose = (option == JOptionPane.YES_OPTION);
					if (choose) {
						try {
							this.orderController.getOrderList()[this.orderController.getSize() - 1].getOrderLineList().removeOrderLine(this.orderController.getOrderList()[this.orderController.getSize() - 1].getOrderLineList().getSize() - 1);
						} catch (OrderLineNotFoundException e) {
							// TODO: Si peta aquí miradlo bien porque no debería pasar
							System.out.println("Error: " + e);
						}
					}
				}}
				option = JOptionPane.showConfirmDialog(null, "Do you want to add another product from menu?", "QUESTION", JOptionPane.YES_NO_OPTION);
				choose = (option == JOptionPane.YES_OPTION);
				if (!choose) {
					bucle = false;
				}
			}
			for (int i = 0; i < this.orderController.getOrderList()[this.orderController.getSize() - 1].getOrderLineList().getSize(); i++) {
				if (client.isPreferential()) {
					price = price+(this.orderController.getOrderList()[this.orderController.getSize() - 1].
							getOrderLineList().getOrderLineList()[i].getProduct().getPrice() * 
							(1 - this.orderController.getOrderList()[this.orderController.getSize() - 1].
									getOrderLineList().getOrderLineList()[i].getProduct().getDiscount() / 100))*
							this.orderController.getOrderList()[this.orderController.getSize() - 1].getOrderLineList().getOrderLineList()[i].getQuantity();
				} else {
					price = price+this.orderController.getOrderList()[this.orderController.getSize() - 1].getOrderLineList().getOrderLineList()[i].getProduct().getPrice()*this.orderController.getOrderList()[this.orderController.getSize() - 1].getOrderLineList().getOrderLineList()[i].getQuantity();
				}
			}
			this.orderController.getOrderList()[this.orderController.getSize() - 1].setPrice(price);
			JOptionPane.showMessageDialog(null,"Your order contains this so far...\n" + this.orderController.getOrderList()[this.orderController.getSize() - 1].toString());
			option = JOptionPane.showConfirmDialog(null, "Do you want to confirm your order?", "QUESTION", JOptionPane.YES_NO_OPTION);
			choose = (option == JOptionPane.YES_OPTION);
			if (choose) {
				b = false;
			}
			else
			{
				bucle=true;
			}
		}
		JOptionPane.showMessageDialog(null, "Your ID order is " + this.orderController.getOrderList()[this.orderController.getSize() - 1].getId() + "\nGood bye buddy");
	}

	@Override
	public void copyOrderText(Client_H client) throws OrderNotFoundException{
		int ID = -1;
		double price = 0;
		boolean flag = false, b = true;
		while (b) {
			try {
				while (!flag) {
					System.out.println("Here is the list of orders you made:");
					for (int i=0; i<client.getOrderList().getSize();i++)
					{
						System.out.println(client.getOrderList().getOrderList()[i]);
					}
					try {
						System.out.println("Which order do you want to copy? Type the ID number");
						ID = kb.nextInt();
						kb.nextLine();
						this.orderController.addOrder(this.orderController.getOrder(ID).getOrderLineList().getOrderLineList()[0]);
						flag = true;
					} catch (NumberFormatException e) {
						System.out.println("You must introduce a number. Try again.");
					} catch (OrderNotFoundException e) {
						System.err.println("Error: " + e);
					} catch (OrderFullListException e) {
						System.err.println("Error: " + e);
					}
				}
				for (int i = 1; i < this.orderController.getOrder(ID).getOrderLineList().getSize(); i++) {
					this.orderController.getOrder(this.orderController.getSize() - 1).getOrderLineList().addOrderLine(this.orderController.getOrder(ID).getOrderLineList().getOrderLineList()[i].getProduct(), this.orderController.getOrder(ID).getOrderLineList().getOrderLineList()[i].getQuantity());
				}
			} catch (OrderLineFullListException e) {
				System.err.println("Error: " + e);
			}
			for (int i = 0; i < this.orderController.getOrderList()[this.orderController.getSize() - 1].getOrderLineList().getSize(); i++) {
				if (client.isPreferential()) {
					price = price+(this.orderController.getOrderList()[this.orderController.getSize() - 1].
							getOrderLineList().getOrderLineList()[i].getProduct().getPrice() * 
							(1 - this.orderController.getOrderList()[this.orderController.getSize() - 1].
									getOrderLineList().getOrderLineList()[i].getProduct().getDiscount() / 100))*
							this.orderController.getOrderList()[this.orderController.getSize() - 1].getOrderLineList().getOrderLineList()[i].getQuantity();
				} else {
					price = price+this.orderController.getOrderList()[this.orderController.getSize() - 1].getOrderLineList().getOrderLineList()[i].getProduct().getPrice()*this.orderController.getOrderList()[this.orderController.getSize() - 1].getOrderLineList().getOrderLineList()[i].getQuantity();
				}
			}
			this.orderController.getOrderList()[this.orderController.getSize() - 1].setPrice(price);
			System.out.println("Your order contains this so far...\n");
			System.out.println(this.orderController.getOrderList()[this.orderController.getSize() - 1]);
			while (flag) {
				System.out.println("Do you want to confirm your order?");
				String msg = kb.nextLine();
				if (msg.equals("yes")) {
					flag = false;
					b = false;
				} else if (msg.equals("no")) {
					flag = false;
					b=false;
					this.orderController.removeOrder(this.orderController.getOrderList()[this.orderController.getSize()-1].getId());
				}
				if (flag) {
					System.out.println("Sorry, i'm not understanding you, can you repeat?");
				}
			}
		}
		System.out.println("Your ID order is " + this.orderController.getOrderList()[this.orderController.getSize() - 1].getId());
		System.out.println("Bye!");
	}

	@Override
	public void copyOrderGui(Client_H client) throws OrderNotFoundException{
		int ID = 0, option;
		double price = 0;
		boolean correct = false, choose, b = true;
		String msg;
		JFrame window = new JFrame();
		Container Container1 = window.getContentPane();
		window.setTitle("Copy Order");
		window.setContentPane(Container1);
		window.setSize(800, 600);
		window.setLocation(100, 0);
		window.setVisible(true);
		Container1.setLayout(new FlowLayout());
		while (b) {
			for (int i = 0; i < client.getOrderList().getSize(); i++) {
				Container1.add(new JLabel("Here is the list of orders you made:\n" + client.getOrderList().getOrderList()[i].getOrderLineList().toString() + "\nIdentifier: " + client.getOrderList().getOrderList()[i].getId() + " Date: " + client.getOrderList().getOrderList()[i].getOrderDate() +
						" Price: " + client.getOrderList().getOrderList()[i].getPrice() + " Number of products: " + client.getOrderList().getOrderList()[i].getOrderLineList().getSize()));
			}
			try {
				while (!correct) {
					try {
						msg = JOptionPane.showInputDialog(null, "Which order do you want to copy? Type the ID number");
						ID = Integer.parseInt(msg);
						this.orderController.addOrder(this.orderController.getOrder(ID).getOrderLineList().getOrderLineList()[0]);
						correct = true;
					} catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(null, "You must introduce a number. Try again.");
					} catch (OrderNotFoundException | OrderFullListException e) {
						System.err.println("Error: " + e);
					}

				}
				for (int i = 1; i < this.orderController.getOrder(ID).getOrderLineList().getSize(); i++) {
					this.orderController.getOrderList()[this.orderController.getSize()-1].getOrderLineList().addOrderLine(this.orderController.getOrder(ID).getOrderLineList().getOrderLineList()[i].getProduct(), this.orderController.getOrder(ID).getOrderLineList().getOrderLineList()[i].getQuantity());
				}
			} catch (OrderLineFullListException e) {
				System.err.println("Error: " + e);
			}
			for (int i = 0; i < this.orderController.getOrderList()[this.orderController.getSize() - 1].getOrderLineList().getSize(); i++) {
				if (client.isPreferential()) {
					price = price+(this.orderController.getOrderList()[this.orderController.getSize() - 1].
							getOrderLineList().getOrderLineList()[i].getProduct().getPrice() * 
							(1 - this.orderController.getOrderList()[this.orderController.getSize() - 1].
									getOrderLineList().getOrderLineList()[i].getProduct().getDiscount() / 100))*
							this.orderController.getOrderList()[this.orderController.getSize() - 1].getOrderLineList().getOrderLineList()[i].getQuantity();
				} else {
					price = price+this.orderController.getOrderList()[this.orderController.getSize() - 1].getOrderLineList().getOrderLineList()[i].getProduct().getPrice()*this.orderController.getOrderList()[this.orderController.getSize() - 1].getOrderLineList().getOrderLineList()[i].getQuantity();
				}
			}
			this.orderController.getOrderList()[this.orderController.getSize() - 1].setPrice(price);
			Container1.add(new JLabel("Your order contains this so far...\n" + this.orderController.getOrderList()[this.orderController.getSize() - 1].toString()));
			option = JOptionPane.showConfirmDialog(null, "Do you want to confirm your order? (yes/no)", "QUESTION", JOptionPane.YES_NO_OPTION);
			choose = (option == JOptionPane.YES_OPTION);
			if (choose) {
				b = false;
			} else {
				b=true;
				correct=false;
				this.orderController.removeOrder(this.orderController.getOrderList()[this.orderController.getSize()-1].getId());
			}
		}
		JOptionPane.showMessageDialog(null, "Your ID order is " + this.orderController.getOrderList()[this.orderController.getSize() - 1].getId() + "\nGood bye buddy");
	}

}
