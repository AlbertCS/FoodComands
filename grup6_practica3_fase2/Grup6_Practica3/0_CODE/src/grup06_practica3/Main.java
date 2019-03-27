package grup06_practica3;

import grup06_practica3.controllers.ApplicationController;
import grup06_practica3.utils.Settings;

public class Main {

	public static void main(String[] args) {
		ApplicationController application = new ApplicationController();
		application.run(Settings.TEXT_MODE);
	}
}
