package headers.views;

public interface ApplicationView_H {

	/**
	 * Display menu using the text mode
	 */
	void runTextMenu();

	/**
	 * Display menu using the gui mode
	 */
	void runGuiMenu();
	
	/**
	 * 
	 * @param text Exception message
	 */
	 void showExceptionText(String text);
	 
	 /**
	  * 
	  * @param text Exception message
	  */
	 void showExceptionGui(String text);
	
}
