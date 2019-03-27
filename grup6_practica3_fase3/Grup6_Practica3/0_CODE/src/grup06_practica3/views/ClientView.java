package grup06_practica3.views;

import java.util.InputMismatchException;
import java.util.Scanner;
import grup06_practica3.controllers.ClientController;
import grup06_practica3.exceptions.ClientFullListException;
import grup06_practica3.exceptions.ClientNotFoundException;
import grup06_practica3.models.Client;
import headers.views.ClientView_H;
import javax.swing.*;
import java.awt.*;

/**
 * Author:  Bernat Bosca Candel
 * Date:    04/12/16
 */
public class ClientView extends JFrame implements ClientView_H {

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID=1L;
	
	/**
	 * Keyboard
	 */
	private static Scanner keyb = new Scanner(System.in);
	
	/**
	 * ClientController
	 */
	private ClientController clientController;

	/**
	 * Default constructor for the ClientView class
	 * 
	 * @param clientController from which you want to create a clientView
	 */
	public ClientView(ClientController clientController) {
		this.clientController = clientController;
	}

	/**
	 * Display a text of the Client that corresponds with the identifier
	 * 
	 * @param idClient client's id
	 */
	@Override
	public void displayClientText(int idClient) {
		try{
			System.out.println(this.clientController.getClient(idClient));
		} catch (ClientNotFoundException e){
			System.err.println("Error: " + e);
		}
	}

	/**
	 * Display a text of the Client that corresponds with the identifier with graphical interface
	 * 
	 * @param idClient client's id
	 */
	@Override
	public void displayClientGui(int idClient) {
		String space=" ";
		JFrame window = new JFrame();
		Container mineContainer = window.getContentPane();
		window.setTitle("Display Client");
		window.setContentPane(mineContainer);
		window.setSize(1200,200);
		mineContainer.setLayout(new FlowLayout());
		try{
			mineContainer.add(new JLabel("Client:"+space+space+"identifier="+space+this.clientController.getClient(idClient).getId()+space+space+",name="+space+this.clientController.getClient(idClient).getName()
				+space+space+",address="+space+this.clientController.getClient(idClient).getAddress()+space+space+",phoneNumber= "+space+this.clientController.getClient(idClient).getPhoneNumber()
				+space+space+",username="+space+this.clientController.getClient(idClient).getUsername()+space+space+",password= "+space+this.clientController.getClient(idClient).getPassword() 
				+space+space+",celiac="+space+this.clientController.getClient(idClient).isCeliac()+space+space+",lactose= "+space+this.clientController.getClient(idClient).isLactose()
				+space+space+",driedFruits="+space+this.clientController.getClient(idClient).isDriedFruits()+space+space+",preferential= "+space+this.clientController.getClient(idClient).isPreferential()));
			window.setLocation(100,0);
			window.setVisible(true);
		} catch (ClientNotFoundException e){
			System.err.println("Error: " + e);
		}
	}

	/**
	 * Display a text of the list of clients
	 */
	@Override
	public void displayClientListText() {
		int i;
		for(i=0;i<this.clientController.getSize();i++){
			System.out.println("\n" +this.clientController.getClientList()[i]);
		}
	}

	/**
	 * Display a text of the list of clients with graphical interface
	 */
	@Override
	public void displayClientListGui() {
		int i;
		String space=" ";
		JFrame window = new JFrame();
		Container mineContainer = window.getContentPane();
		window.setTitle("Display Client List");
		window.setContentPane(mineContainer);
		window.setSize(1200,300);
		mineContainer.setLayout(new FlowLayout());
		for(i=0;i<this.clientController.getSize();i++){
			mineContainer.add(new JLabel("Client:"+space+space+"identifier="+space+this.clientController.getClientList()[i].getId()+space+space+",name="+space+this.clientController.getClientList()[i].getName()
				+space+space+",address="+space+this.clientController.getClientList()[i].getAddress()+space+space+",phoneNumber= "+space+this.clientController.getClientList()[i].getPhoneNumber()
				+space+space+",username="+space+this.clientController.getClientList()[i].getUsername()+space+space+",password= "+space+this.clientController.getClientList()[i].getPassword() 
				+space+space+",celiac="+space+this.clientController.getClientList()[i].isCeliac()+space+space+",lactose= "+space+this.clientController.getClientList()[i].isLactose()
				+space+space+",driedFruits="+space+this.clientController.getClientList()[i].isDriedFruits()+space+space+",preferential= "+space+this.clientController.getClientList()[i].isPreferential()));
		}
		window.setLocation(100,0);
		window.setVisible(true);
	}

	/**
	 * Display a text of the list of clients and return an id selected by user
	 * 
	 * @return client's id
	 */
	@Override
	public int selectIdClientListText() {
		int i, id=0;
		boolean correct = false;
		
		displayClientListText();
		while(!correct){
			try{
				System.out.println("\nIntroduce the Id to get the orders of this client: ");
				id = keyb.nextInt();
				keyb.nextLine();		//Clean buffer
				correct=true;
				try{
					for(i=0;i<this.clientController.getSize();i++){
						this.clientController.getClient(id);
					}
				}
				catch(ClientNotFoundException e){
					System.out.println("You have entered an id that does not match any client. Please, try again.");
					correct=false;
				}
			}
			catch(InputMismatchException e){
				keyb.nextLine();		//Clean buffer
				System.out.println("You have entered a character. Please, try entered a number.");
			}
		}
		return id;
	}

	/**
	 * Display a text of the list of clients and return an id selected by user with graphical interface
	 * 
	 * @return client's id
	 */
	@Override
	public int selectIdClientListGui() {
		int i, id=0;
		String number;
		boolean correct = false;
		
		displayClientListGui();
		while(!correct){
			try{
				number = JOptionPane.showInputDialog("Introduce the Id to get the orders of this client:");
				id = Integer.parseInt(number);
				correct=true;
				try{
					for(i=0;i<this.clientController.getSize();i++){
						this.clientController.getClient(id);
					}
				}
				catch(ClientNotFoundException e){
					JOptionPane.showMessageDialog(null, "You have entered an id that does not match any client. Please, try again.", "ATENTION!", JOptionPane.WARNING_MESSAGE);
					correct=false;
				}
			}
			catch(NumberFormatException e){
				JOptionPane.showMessageDialog(null, "You have entered a character. Please, try entered a number.", "ATENTION!", JOptionPane.WARNING_MESSAGE);
			}
		}
		return id;
	}
	
	/**
	 * Create a new client and add client to list of clients (clientController)
	 */
	@Override
	public void addClientText() {
		long id = 0;
		String name = null, address = null, phoneNumber = null, username = null, password = null, aux = null;
		boolean celiac=false, lactose=false, driedFruits=false, correct=false;
		Client consumer = null;
		
		while(!correct){
			System.out.println("\nIntroduce your name: ");
			name = keyb.nextLine();
			System.out.println("Introduce your address: ");
			address = keyb.nextLine();
			while(!correct){
				try{
					System.out.println("Introduce your phone number: ");
					id = keyb.nextLong();
					phoneNumber = String.valueOf(id);
					keyb.nextLine();		//Clean buffer
					correct=true;
				}
				catch(InputMismatchException e){
					keyb.nextLine();		//Clean buffer
					System.out.println("You have entered a character. Please, try entered a number.");
				}
			}
			System.out.println("Introduce your username: ");
			username = keyb.nextLine();
			System.out.println("Introduce your password: ");
			password = keyb.nextLine();
			System.out.println("Are you celiac?");
			aux = keyb.nextLine();
			celiac = aux.equals("yes");
			System.out.println("Are you lactose intolerant?");
			aux = keyb.nextLine();
			lactose = aux.equals("yes");
			System.out.println("Are you dried fruits intolerant?");
			aux = keyb.nextLine();
			driedFruits = aux.equals("yes");
			System.out.println("You have entered: \n\nName: " +name+ "\nAddress: " +address+ "\nPhone number: " +phoneNumber
					+ "\nUsername: " +username+ "\nPassword: " +password+ "\nCeliac: " +celiac+ "\nLactose intolerant: " 
					+lactose+ "\nDried fruits intolerant: " +driedFruits+ "\n\nIs it correct?(yes/no)");
			aux = keyb.nextLine();
			correct = aux.equals("yes");
		}
		try{
			id=-1;
			consumer = new Client((int)id,name,address,phoneNumber,username,password,celiac,lactose,driedFruits);
			clientController.addClient(consumer);
			System.out.println("You entered data succesfully.");
		} catch (ClientFullListException e){
			System.err.println("Error: " + e);
		}
	}

	/**
	 * Create a new client and add client to list of clients (clientController) with graphical interface
	 */
	@Override
	public void addClientGui() {
		int option = 0, id = 0;
		String name = null, address = null, phoneNumber = null, username = null, password = null;
		boolean celiac=false, lactose=false, driedFruits=false, correct=false;
		Client consumer = null;
		JFrame window = new JFrame();
		Container mineContainer = window.getContentPane();
		window.setTitle("Add Client");
		window.setContentPane(mineContainer);
		window.setSize(400,150);
		
		while(!correct){
			name = JOptionPane.showInputDialog("Introduce your name:");
			address = JOptionPane.showInputDialog("Introduce your address:");
			while(!correct){
				try{
					phoneNumber = JOptionPane.showInputDialog("Introduce your phone number:");
					option = Integer.parseInt(phoneNumber);
					correct=true;
				}
				catch(NumberFormatException e){
					JOptionPane.showMessageDialog(null, "You have entered a character. Please, try entered a number.", "ATENTION!", JOptionPane.WARNING_MESSAGE);
				}
			}
			username = JOptionPane.showInputDialog("Introduce your username:");
			password = JOptionPane.showInputDialog("Introduce your password:");
			option = JOptionPane.showConfirmDialog(null, "Are you celiac?", "QUESTION", JOptionPane.YES_NO_OPTION);
			celiac = (option==JOptionPane.YES_OPTION);
			option = JOptionPane.showConfirmDialog(null, "Are you lactose intolerant?", "QUESTION", JOptionPane.YES_NO_OPTION);
			lactose = (option==JOptionPane.YES_OPTION);
			option = JOptionPane.showConfirmDialog(null, "Are you dried fruits intolerant?", "QUESTION", JOptionPane.YES_NO_OPTION);
			driedFruits = (option==JOptionPane.YES_OPTION);
			option = JOptionPane.showConfirmDialog(null, "You have entered: \n\nName: " +name+ "\nAddress: " +address+ "\nPhone number: " +phoneNumber
					+ "\nUsername: " +username+ "\nPassword: " +password+ "\nCeliac: " +celiac+ "\nLactose intolerant: " 
					+ lactose+ "\nDried fruits intolerant: " +driedFruits+ "\n\nIs it correct?", "QUESTION", JOptionPane.YES_NO_OPTION);
			correct = (option==JOptionPane.YES_OPTION);
		}
		try{
			id=-1;
			consumer = new Client(id,name,address,phoneNumber,username,password,celiac,lactose,driedFruits);
			clientController.addClient(consumer);
			mineContainer.setLayout(new FlowLayout());
			mineContainer.add(new JLabel("You entered data succesfully."));
			window.setVisible(true);
			window.setLocation(500,250);
		} catch (ClientFullListException e){
			System.err.println("Error: " + e);
		}
	}
	
	/**
	 * Close the keyboard
	 */
	@Override
	public void closeKeyboardClientView() {
		keyb.close();
	}
}
