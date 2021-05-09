package hust.soict.globalict.aims.view.updatestore;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import hust.soict.globalict.aims.model.disc.DigitalVideoDisc;
import hust.soict.globalict.aims.model.media.Media;

public class AddDVDToStore extends AddDiscToStore {
	
	public AddDVDToStore() {
		this.setLayout(new BorderLayout());
		
		this.add(createHeader(), BorderLayout.NORTH);
		this.add(createBody(), BorderLayout.CENTER);
		this.add(createFooter(), BorderLayout.SOUTH);
	}

	@Override
	public Component createBody() {
		JPanel body = new JPanel();
		body.setLayout(new GridLayout(5, 2));
		
		body.add(titleLabel);
		body.add(titleTF);
		
		body.add(categoryLabel);
		body.add(categoryTF);
		
		body.add(directorLabel);
		body.add(directorTF);
		
		body.add(lengthLabel);
		body.add(lengthTF);
		
		body.add(costLabel);
		body.add(costTF);
		
		return body;
	}

	@Override
	public Media getItem() {
		String title = this.titleTF.getText();
		String category = this.categoryTF.getText();
		float cost = Float.parseFloat(this.costTF.getText());
		String director = directorTF.getText();
		int length = Integer.parseInt(lengthTF.getText());
		return new DigitalVideoDisc(title, category, director, length, cost);
	}

	@Override
	public String getTypeOfAddedProduct() {
		return "DVD";
	}

}
