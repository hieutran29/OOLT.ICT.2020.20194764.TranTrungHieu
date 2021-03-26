package hust.soict.globalict.aims;
/**
 * @author HieuTran
 */


import java.util.Scanner;

import javax.swing.JOptionPane;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.disc.DigitalVideoDisc;


public class Aims {

	public static void main(String[] args) {
		Cart cart = new Cart();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 90, 24f);
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 100, 24f);
		
//		cart.addDigitalVideoDisc(dvd1);
//		cart.addDigitalVideoDisc(dvd2);
//		cart.addDigitalVideoDisc(dvd3);
//		cart.addDigitalVideoDisc(dvd4);
//		cart.addDigitalVideoDisc(dvd5);
		
//		DigitalVideoDisc[] discList = {dvd1, dvd2, dvd3, dvd4, dvd5};
//		cart.addDigitalVideoDisc(discList);
		
		cart.addDigitalVideoDisc(dvd1, dvd2, dvd3, dvd4, dvd5);
		
		cart.displayCart();
	}	

}
