package hust.soict.globalict.aims;
/**
 * @author HieuTran
 */


import java.util.Scanner;

import javax.swing.JOptionPane;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.disc.DigitalVideoDisc;
import hust.soict.globalict.aims.store.Store;
import hust.soict.globalict.aims.store.Store.SeeCurrentCart;
import hust.soict.globalict.aims.store.Store.UpdateStore;


public class Aims {

	public static void main(String[] args) {
		Cart cart = new Cart();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 90, 24f);
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 100, 24f);
		
		cart.addDigitalVideoDisc(dvd1, dvd2, dvd3, dvd4, dvd5);
//		cart.displayCart();
		
		Store store = new Store();
		store.addDVD(dvd1);
		store.addDVD(dvd2);
		store.addDVD(dvd3);
		store.addDVD(dvd4);
		store.addDVD(dvd5);
		
		DigitalVideoDisc dvd6 = new DigitalVideoDisc("Harry Potter", "aaaa", "aaaa", 50, 100f);
		
		Scanner scanner = new Scanner(System.in);
		int choice = 0;
		do {
			Store.showMenu();
			choice = scanner.nextInt();
			switch(choice) {
			case 1:
				store.printDVDsInStore();
				
				int choiceViewStore = 0;
				do {
					Store.ViewStore.menu();
					choiceViewStore = scanner.nextInt();
					switch(choiceViewStore) {
					case 1:
						Store.ViewStore.seeDVD(store, dvd6);
						break;
					case 2:
						Store.ViewStore.addDVDToCart(cart, dvd6);
						break;
					case 3:
						cart.displayCart();
						int choiceSeeCart = 0;
						do {
							SeeCurrentCart.menu();
							choiceSeeCart = scanner.nextInt();
							switch(choiceSeeCart) {
							case 1:
								SeeCurrentCart.filterDVDs(cart);
								break;
							case 2:
								SeeCurrentCart.sortDVDs(cart);
								break;
							case 3:
								SeeCurrentCart.removeDVD(cart, dvd6);
								break;
							case 4:
								SeeCurrentCart.placeOrder(cart);
								break;
							}
						} while(choiceSeeCart != 0);
						break;
					}
				} while(choiceViewStore != 0);
				break;
			case 2:
				int choiceUpdateStore = 0;
				do {
					UpdateStore.menu();
					choiceUpdateStore = scanner.nextInt();
					
					switch(choiceUpdateStore) {
					case 1:
						UpdateStore.addDVDToStore(store, dvd6);
						break;
					case 2:
						UpdateStore.remvoveDVDFromStore(store, dvd6);
						break;
					}
				} while(choiceUpdateStore != 0);
				
				break;
			case 3:
				cart.displayCart();
				int choiceSeeCart = 0;
				do {
					
					SeeCurrentCart.menu();
					choiceSeeCart = scanner.nextInt();
					switch(choiceSeeCart) {
					case 1:
						SeeCurrentCart.filterDVDs(cart);
						break;
					case 2:
						SeeCurrentCart.sortDVDs(cart);
						break;
					case 3:
						SeeCurrentCart.removeDVD(cart, dvd6);
						break;
					case 4:
						SeeCurrentCart.placeOrder(cart);
						break;
					}
				} while(choiceSeeCart != 0);
				
				break;
			}
		} while(choice != 0);
		
		scanner.close();
	}	

}
