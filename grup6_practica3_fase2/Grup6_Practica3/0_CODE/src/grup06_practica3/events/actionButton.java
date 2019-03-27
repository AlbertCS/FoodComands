package grup06_practica3.events;
/**
 * Author: Albert Ca�ellas Sol�
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import grup06_practica3.views.ProductView;

public class actionButton implements ActionListener {

	private ProductView productView;

	public actionButton(ProductView productView) {
		this.productView = productView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		productView.buttonPressed1();

	}

}


