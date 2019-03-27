package grup06_practica3.events;

import grup06_practica3.views.ApplicationView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddOrderButtonListener implements ActionListener {

	private ApplicationView aWindow;

	public AddOrderButtonListener(ApplicationView aWindow) {
		this.aWindow = aWindow;
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		aWindow.addOrder();
	}

}
