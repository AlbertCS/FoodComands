package grup06_practica3.views;

import java.util.Scanner;
import javax.swing.*;

import grup06_practica3.controllers.ProductController;
import grup06_practica3.events.actionButton;
import grup06_practica3.events.dishAction;
import grup06_practica3.events.drinkAction;
import grup06_practica3.events.removeAction;
import grup06_practica3.exceptions.ProductFullListException;
import grup06_practica3.exceptions.ProductNotFoundException;
import grup06_practica3.models.Dish;
import grup06_practica3.models.Drink;
import headers.models.Product_H;
import headers.views.ProductView_H;

import java.awt.*;



/**
 * Author: Albert Cañellas Solé
 */


public class ProductView extends JFrame implements ProductView_H  {
	
	
	private static final long serialVersionUID = 1L;
	private Scanner keyboard=new Scanner(System.in);
	private ProductController productController;
	JTextField text;
	Container productContainer=null;
	
	
	public ProductView(ProductController productController) {
		
		this.productController = productController;
	}
	
	/**
	 * Method that shows the products list by console
	 * @throws ProductNotFoundException Thrown when the product is not in the list
	 */
	public void showProductsText() throws ProductNotFoundException {
		for(int i=0; i<productController.getSize(); i++){
			System.out.println(productController.findProductByPosition(i));
		}
	}

	/**
	 * Method that shows a product list by windows
	 * @throws ProductNotFoundException Thrown when the product is not in the list
	 */
	public void showProductsGui() throws ProductNotFoundException{
		
		int i;
		JFrame window = new JFrame();
		Container mineContainer = window.getContentPane();
		window.setTitle("Show Products List");
		window.setContentPane(mineContainer);
		window.setSize(1200,300);
		mineContainer.setLayout(new FlowLayout());
		for(i=0;i<this.productController.getSize();i++){
			mineContainer.add(new JLabel(this.productController.findProductByPosition(i).toString()));
		}
		window.setLocation(100,0);
		window.setVisible(true);
	}


	/**
	 * Method to add a product of the class dish if op=1 or a drink op=2
	 * the client has to introduce the parameters
	 * @throws ProductFullListException Thrown when the list is full
	 * */
	
	public void addProductText() throws ProductFullListException {
		int op=0, code=0, ok=0;
		double price=0, discount=0, volume=0;
		boolean celiac=false, lactose=false, driedFruit=false, hasAlcohol=false;
		String name=".", a=".";
		Product_H d = null;
		System.out.println("\tPlease select an option.");
		System.out.println("\tPress 1 to add a dish or 2 to add a drink.");
		while(op!=1 && op!=2){
			System.out.println("Introduce 1 or 2");
			try{
				op=Integer.parseInt(keyboard.nextLine());
			}
			catch(NumberFormatException e){
				System.err.println("Error: "+e);
			}
		}
		while(ok!=1){
		switch(op){
		case 1:
			System.out.println("\tIntroduce the parametres in order to add a new dish.");
			//Code
			while(ok!=1){
				System.out.println("\n\tCode:");
				try{
					code=Integer.parseInt(keyboard.nextLine());
					ok=1;
				}
				catch(NumberFormatException e){
					System.err.println("Error: "+e);
					ok=0;
				}
			}
			//Name
			ok=0;
			while(ok!=1){
				System.out.println("\n\tName:");
				try{
					name=keyboard.nextLine();
					ok=1;
				}
				catch(NumberFormatException e){
					System.err.println("Error: "+e);
					ok=0;
				}
			}
			//Price
			ok=0;
			while(ok!=1){
				System.out.println("\n\tPrice:");
				try{
					price=Double.parseDouble(keyboard.nextLine());
					ok=1;
				}
				catch(NumberFormatException e){
					System.err.println("Error: "+e);
					ok=0;
				}
			}
			//Discount
			ok=0;
			while(ok!=1){
				System.out.println("\n\tDiscount:");
				try{
					discount=Double.parseDouble(keyboard.nextLine());
					ok=1;
				}
				catch(NumberFormatException e){
					System.err.println("Error: "+e);
					ok=0;
				}
			}
			//Celiac
			while(!(a.equals("Yes"))&&!(a.equals("No"))){
				System.out.println("\n\tCeliac: Yes or No");
				a=keyboard.nextLine();
			}
			if(a.equals("Yes")){
				celiac=true;
			}
			else celiac=false;
			//Lactose
			while(!(a.equals("Yes"))&&!(a.equals("No"))){
				System.out.println("\n\tLactose: Yes or No");
				a=keyboard.nextLine();
			}
			if(a.equals("Yes")){
				lactose=true;
			}
			else lactose=false;
			//Dried Fruit
			while(!(a.equals("Yes"))&&!(a.equals("No"))){
				System.out.println("\n\tDriedFruit: Yes or No");
				a=keyboard.nextLine();
			}
			if(a.equals("Yes")){
				driedFruit=true;
			}
			else driedFruit=false;
			//Revision
			while(!(a.equals("Yes"))&&!(a.equals("No"))){
				System.out.println("\n\tCode: "+code+" Name: "+name+" Price: "+price+" Discount: "+discount+" Celiac: "+celiac+" Lactose: "+lactose+" DriedFruits: "+driedFruit+"\n\tIt's correct? Yes | No");   
				a=keyboard.nextLine();
			}
			if(a.equals("Yes")) ok=1;
			else ok=0;
			d = new Dish(code, name, price, discount, celiac, lactose, driedFruit);
		case 2:
			System.out.println("\tIntroduce the parametres in order to add a new drink.");
			//Code
			while(ok!=1){
				System.out.println("\n\tCode:");
				try{
					code=Integer.parseInt(keyboard.nextLine());
					ok=1;
				}
				catch(NumberFormatException e){
					System.err.println("Error: "+e);
					ok=0;
				}
			}
			//Name
			ok=0;
			while(ok!=1){
				System.out.println("\n\tName:");
				try{
					name=keyboard.nextLine();
					ok=1;
				}
				catch(NumberFormatException e){
					System.err.println("Error: "+e);
					ok=0;
				}
			}
			//Price
			ok=0;
			while(ok!=1){
				System.out.println("\n\tPrice:");
				try{
					price=Double.parseDouble(keyboard.nextLine());
					ok=1;
				}
				catch(NumberFormatException e){
					System.err.println("Error: "+e);
					ok=0;
				}
			}
			//Discount
			ok=0;
			while(ok!=1){
				System.out.println("\n\tDiscount:");
				try{
					discount=Double.parseDouble(keyboard.nextLine());
					ok=1;
				}
				catch(NumberFormatException e){
					System.err.println("Error: "+e);
					ok=0;
				}
			}
			//Volume
			ok=0;
			while(ok!=1){
				System.out.println("\n\tVolume:");
				try{
					volume=Double.parseDouble(keyboard.nextLine());
					ok=1;
				}
				catch(NumberFormatException e){
					System.err.println("Error: "+e);
					ok=0;
				}
			}
			//Has alcohol
			while(!(a.equals("Yes"))&&!(a.equals("No"))){
				System.out.println("\n\thasAlcohol: Yes or No");
				a=keyboard.nextLine();
			}
			if(a.equals("Yes")){
				hasAlcohol=true;
			}
			else hasAlcohol=false;
			//Revision
			while(!(a.equals("Yes"))&&!(a.equals("No"))){
				System.out.println("\n\tCode: "+code+" Name: "+name+" Price: "+price+" Discount: "+discount+" Celiac: "+celiac+" Lactose: "+lactose+" DriedFruits: "+driedFruit+"\n\tIt's correct? Yes | No");   
				a=keyboard.nextLine();
			}
			if(a.equals("Yes")) ok=1;
			else ok=0;
			d= new Drink(code, name, price, discount, volume, hasAlcohol);
		}
		}
		this.productController.addProduct(d);
	}

	/**
	 * Method that adds a products (drink/dish) depends of the button pressed
	 */
	public void addProductGui() {
		
		JFrame window = new JFrame();
		Container productContainer = window.getContentPane();
		window.setTitle("Add Product");
		window.setContentPane(productContainer);
		window.setSize(400,150);
		
		Button dish= new Button("Dish");
		productContainer.add(dish);
		dishAction accio=new dishAction(this);
		dish.addActionListener(accio);
		
		Button drink= new Button("Drink");
		productContainer.add(drink);
		drinkAction accio1=new drinkAction(this);
		drink.addActionListener(accio1);
		
		productContainer.setLayout(new FlowLayout());
		
		window.setVisible(true);
		window.setLocation(500,250);
	}
	
	public void buttonDish(){
		int option = 0;
		String name = null;
		int code=0; 
		double	price=0, discount=0;
		boolean celiac=false, lactose=false, driedFruits=false, correct1=false, correct=false;
		Dish dish = null;
		while(!correct){
			while(!correct1){
				try{
					code = Integer.parseInt(JOptionPane.showInputDialog("Introduce products code:"));
					correct1=true;
				}
				catch(NumberFormatException e){
					JOptionPane.showMessageDialog(null, "You have entered a character. Please, try entered a number", "ATENCION!", JOptionPane.WARNING_MESSAGE);
				}
			}
			name = JOptionPane.showInputDialog("Introduce products name:");
			correct1=false;
			while(!correct1){
				try{
					price = Double.valueOf(JOptionPane.showInputDialog("Introduce products price:"));
					correct1=true;
				}
				catch(NumberFormatException e){
					JOptionPane.showMessageDialog(null, "You have entered a character. Please, try entered a number", "ATENCION!", JOptionPane.WARNING_MESSAGE);
				}
			}
			correct1=false;
			while(!correct1){
				try{
					discount = Double.valueOf(JOptionPane.showInputDialog("Introduce products discount:"));
					correct1=true;
				}
				catch(NumberFormatException e){
					JOptionPane.showMessageDialog(null, "You have entered a character. Please, try entered a number", "ATENCION!", JOptionPane.WARNING_MESSAGE);
				}
			}
			option = JOptionPane.showConfirmDialog(null, "Are you celiac?", "QUESTION", JOptionPane.YES_NO_OPTION);
			celiac = (option==JOptionPane.YES_OPTION);
			option = JOptionPane.showConfirmDialog(null, "Are you lactose intolerant?", "QUESTION", JOptionPane.YES_NO_OPTION);
			lactose = (option==JOptionPane.YES_OPTION);
			option = JOptionPane.showConfirmDialog(null, "Are you dried fruits intolerant?", "QUESTION", JOptionPane.YES_NO_OPTION);
			driedFruits = (option==JOptionPane.YES_OPTION);
			option = JOptionPane.showConfirmDialog(null, "You have entered: \n\nCode: " +code+ "\nName: " +name+ "\nPrice: " +price
					+ "\nDiscount: " +discount+ "\nCeliac: " +celiac+ "\nLactose intolerant: " +lactose+ "\nDried fruits intolerant: " +driedFruits+ "\n\nIs it correct?", "QUESTION", JOptionPane.YES_NO_OPTION);
			correct = (option==JOptionPane.YES_OPTION);
			JOptionPane.showMessageDialog(null, "You entered data succesfully");
		}		
		try{
			dish = new Dish (code,name,price,discount,celiac,lactose,driedFruits);
			productController.addProduct(dish);
			
		} catch (ProductFullListException e){
			System.err.println("Error: " + e);
		}
	}
	
	public void buttonDrink(){
		int option = 0;
		String name = null;
		int code=0; 
		double	price=0, discount=0, volume=0 ;
		boolean correct1=false, hasAlcohol=false, correct=false;
		Drink drink = null;
		while(!correct){
			while(!correct1){
				try{
					code = Integer.parseInt(JOptionPane.showInputDialog("Introduce products code:"));
					correct1=true;
				}
				catch(NumberFormatException e){
					JOptionPane.showMessageDialog(null, "You have entered a character. Please, try entered a number", "ATENCION!", JOptionPane.WARNING_MESSAGE);
				}
			}
			name = JOptionPane.showInputDialog("Introduce products name:");
			correct1=false;
			while(!correct1){
				try{
					price = Double.valueOf(JOptionPane.showInputDialog("Introduce products price:"));
					correct1=true;
				}
				catch(NumberFormatException e){
					JOptionPane.showMessageDialog(null, "You have entered a character. Please, try entered a number", "ATENCION!", JOptionPane.WARNING_MESSAGE);
				}
			}
			correct1=false;
			while(!correct1){
				try{
					discount = Double.valueOf(JOptionPane.showInputDialog("Introduce products discount:"));
					correct1=true;
				}
				catch(NumberFormatException e){
					JOptionPane.showMessageDialog(null, "You have entered a character. Please, try entered a number", "ATENCION!", JOptionPane.WARNING_MESSAGE);
				}
			}
			correct1=false;
			while(!correct1){
				try{
					volume = Double.valueOf(JOptionPane.showInputDialog("Introduce products volume:"));
					correct1=true;
				}
				catch(NumberFormatException e){
					JOptionPane.showMessageDialog(null, "You have entered a character. Please, try entered a number", "ATENCION!", JOptionPane.WARNING_MESSAGE);
				}
			}
			option = JOptionPane.showConfirmDialog(null, "Are you celiac?", "QUESTION", JOptionPane.YES_NO_OPTION);
			hasAlcohol = (option==JOptionPane.YES_OPTION);
			
			option = JOptionPane.showConfirmDialog(null, "You have entered: \n\nCode: " +code+ "\nName: " +name+ "\nPrice: " +price
					+ "\nDiscount: " +discount+ "\nHas alcohol: " +hasAlcohol+  "\n\nIs it correct?", "QUESTION", JOptionPane.YES_NO_OPTION);
			correct = (option==JOptionPane.YES_OPTION);
		}		
		try{
			drink = new Drink (code,name,price,discount,volume,hasAlcohol);
			productController.addProduct(drink);
			
		} catch (ProductFullListException e){
			System.err.println("Error: " + e);
		}
	}

	/**
	 * Method to remove a product by the code, it ask to the client the code of the product that he/she wants to remove by console
	 * */
	public void removeProductText() throws ProductNotFoundException {
		int code=0, ok=0;
		while(ok!=1){
			System.out.println("\n\tIntroduce the code of the product to remove.");
			try{
				code=Integer.parseInt(keyboard.nextLine());		
				ok=1;
			}
			catch(NumberFormatException e){
				System.err.println("Error: "+e);
				ok=0;
			}
		}
		this.productController.removeProduct(code);
	}

	/**
	 * Method to remove a product by the code, it ask to the client the code of the product that he/she wants to remove by windows
	 * */
	public void removeProductGui() {
		String title="Remove product";
		
		productContainer=getContentPane();
		productContainer.setLayout(new GridLayout(3,0));
		setTitle(title);
		//Button exitProducts=new Button("EXIT");
		//exitProducts.setBounds(MAXIMIZED_HORIZ, MAXIMIZED_VERT, 40, 20);
		
		JLabel descr1= new JLabel("Write the code of the product:");
		productContainer.add(descr1);
		text= new JTextField();
		Button remove= new Button("Remove");
		productContainer.add(remove);
		removeAction accio=new removeAction(this);
		remove.addActionListener(accio);
		productContainer.add(text);
		setSize(400,200); 
		setVisible(true);
	}
	public void buttonPressed2(){
		JLabel descr2=null;
		try{
			int code1=Integer.parseInt(text.getText());
			descr2= new JLabel(String.valueOf(code1));
			productContainer.add(descr2);
			this.productController.removeProduct(code1);
		}catch (ProductNotFoundException e){
			System.err.println("Error: "+e);
		}
	}
	
	/**
	 * Method to show a product by the code, it ask to the client the code of the product that he/she wants to show by console
	 * @throws ProductNotFoundException Thrown when the product is not in the list
	 * */
	public void showProductText() throws ProductNotFoundException {
		int code=0, ok=0;
		while(ok!=1){
			System.out.println("\n\tIntroduce the code of the product to display.");
			try{
				code=Integer.parseInt(keyboard.nextLine());		
				ok=1;
			}
			catch(NumberFormatException e){
				System.err.println("Error: "+e);
				ok=0;
			}
		System.out.println(this.productController.getProduct(code));
		}	
	}

	/**
	 * Method to show a product by the code, it ask to the client the code of the product that he/she wants to show by window
	 * */
	public void showProductGui() {
		String title="Show Products";
		
		productContainer=getContentPane();
		productContainer.setLayout(new GridLayout(3,0));
		setTitle(title);
		//Button exitProducts=new Button("EXIT");
		//exitProducts.setBounds(MAXIMIZED_HORIZ, MAXIMIZED_VERT, 40, 20);
		
		JLabel descr1= new JLabel("Write the code of the product:");
		productContainer.add(descr1);

		text= new JTextField();
		Button busca= new Button("Busca");
		productContainer.add(busca);
		actionButton accio=new actionButton(this);
		busca.addActionListener(accio);
		productContainer.add(text);
		setSize(400,200); 
		setVisible(true);
	}
	
	public void buttonPressed1(){
		JLabel descr2=null;
		try{
			int code1=Integer.parseInt(text.getText());
			descr2= new JLabel(this.productController.getProduct(code1).toString());
			productContainer.add(descr2);
		}catch (ProductNotFoundException e){
			System.err.println("Error: "+e);
		}
	}

}
