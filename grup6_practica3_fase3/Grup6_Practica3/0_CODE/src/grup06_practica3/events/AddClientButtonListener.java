package grup06_practica3.events;

import grup06_practica3.views.ApplicationView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddClientButtonListener implements ActionListener {

	private ApplicationView aWindow;

	public AddClientButtonListener(ApplicationView aWindow) {
		this.aWindow = aWindow;
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		aWindow.addClient();
	}

}
