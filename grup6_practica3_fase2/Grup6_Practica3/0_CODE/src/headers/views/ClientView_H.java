package headers.views;


/**
 * Author:  Bernat Bosca Candel
 * Date:    04/12/16
 */
public interface ClientView_H {

	/**
	 * Display a text of the Client that corresponds with the identifier
	 * 
	 * @param idClient client's id
	 */
	void displayClientText(int idClient);

	/**
	 * Display a text of the Client that corresponds with the identifier with graphical interface
	 * 
	 * @param idClient client's id
	 */
	void displayClientGui(int idClient);

	/**
	 * Display a text of the list of clients
	 */
	void displayClientListText();

	/**
	 * Display a text of the list of clients with graphical interface
	 */
	void displayClientListGui();

	/**
	 * Display a text of the list of clients and return an id selected by user
	 * 
	 * @return client's id
	 */
	int selectIdClientListText();
	
	/**
	 * Display a text of the list of clients and return an id selected by user with graphical interface
	 * 
	 * @return client's id
	 */
	int selectIdClientListGui();
	
	/**
	 * Create a new client and add client to list of clients (clientController)
	 */
	void addClientText();

	/**
	 * Create a new client and add client to list of clients (clientController) with graphical interface
	 */
	void addClientGui();
	
	/**
	 * Close the keyboard
	 */
	void closeKeyboardClientView();
}
