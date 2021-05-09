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

public abstract class AddDiscToStore extends AddItemToStore {
	protected JTextField directorTF = new JTextField();
	protected JTextField lengthTF = new JTextField();
	
	protected JLabel directorLabel = new JLabel("Director", SwingConstants.CENTER);
	protected JLabel lengthLabel = new JLabel("Length", SwingConstants.CENTER);

	@Override
	public abstract Component createBody();

	@Override
	public abstract Media getItem();

	@Override
	public abstract String getTypeOfAddedProduct();
}
