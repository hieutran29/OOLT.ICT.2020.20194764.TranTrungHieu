import java.util.Scanner;

import javax.swing.JOptionPane;


public class Aims {

	public static void main(String[] args) {
		Cart cart = new Cart();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		cart.addDigitalVideoDisc(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		cart.addDigitalVideoDisc(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		cart.addDigitalVideoDisc(dvd3);
		
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 90, 24f);
		cart.addDigitalVideoDisc(dvd4);
		
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 100, 24f);
		cart.addDigitalVideoDisc(dvd5);
		
		int choice = 0;
		String[] options = {"Add DVD", "Remove DVD", 
							"Total Cost", "Display Cart",
							"Quit"};

		do {
			choice = JOptionPane.showOptionDialog(null, "Choose 1 option", "Menu", 
										 		  JOptionPane.YES_NO_CANCEL_OPTION, 
										 		  JOptionPane.QUESTION_MESSAGE, 
										 		  null, options, 0);
			switch(choice) {
			case 0:
				String[] attributes = {"title", "category", "director", "length", "cost"}; 
				String[] newDVDAttributes = new String[5];
				for(int i = 0; i < attributes.length; i++) {
					newDVDAttributes[i] = JOptionPane.showInputDialog("Enter " + attributes[i]);
				}
				DigitalVideoDisc dvd = new DigitalVideoDisc(newDVDAttributes[0],
															newDVDAttributes[1],
															newDVDAttributes[2],
															newDVDAttributes[3],
															newDVDAttributes[4]);
				if(dvd.title().length() != 0) {
					cart.addDigitalVideoDisc(dvd);
					if(JOptionPane.showConfirmDialog(null, "Do you want to play the DVD?", 
													 null, JOptionPane.YES_NO_OPTION) == 0) {
						dvd.playDVD();
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "You must type in title!!!");
				}
				break;
			case 1:
				String removedBookTitle = JOptionPane.showInputDialog("Enter title of the book you want to remove");
				DigitalVideoDisc removedDVD = new DigitalVideoDisc(removedBookTitle);
				cart.removeDigitalVideoDisc(removedDVD);
				break;
			case 2:
				float totalCost = cart.totalCost();
				JOptionPane.showMessageDialog(null, Float.toString(totalCost), 
											  "Total Cost", JOptionPane.INFORMATION_MESSAGE);
				break;
			case 3:
				cart.displayCart();
				break;
			}
		} while(choice != options.length - 1);
	}	

}
