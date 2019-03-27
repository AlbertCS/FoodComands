package grup06_practica3.events;

import grup06_practica3.views.ApplicationView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DisplayClientOrdersButtonListener implements ActionListener {

	private ApplicationView aWindow;

	public DisplayClientOrdersButtonListener(ApplicationView aWindow) {
		this.aWindow = aWindow;
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		aWindow.displayClientOrders();
	}

}
