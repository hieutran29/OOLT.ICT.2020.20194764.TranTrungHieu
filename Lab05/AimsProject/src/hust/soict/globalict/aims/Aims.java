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
		Store store = new Store();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 90, 24f);
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 100, 24f);
		
		store.addDVD(dvd1);
		store.addDVD(dvd2);
		store.addDVD(dvd3);
		store.addDVD(dvd4);
		store.addDVD(dvd5);
		
		Scanner scanner = new Scanner(System.in);
		int choice = 0;
		do {
			Store.showMenu();
			System.out.print("Choose: ");
			choice = scanner.nextInt();
			
			if(choice == 1) {
				store.printDVDsInStore();
				
				int choiceViewStore = 0;
				do {
					Store.ViewStore.menu();
					System.out.print("Choose: ");
					choiceViewStore = scanner.nextInt();
					
					if(choiceViewStore == 1) {
						System.out.print("Enter ID of DVD to see: ");
						int ID = scanner.nextInt();
						Store.ViewStore.seeDVD(store, ID);
						System.out.println();
					}
					else if(choiceViewStore == 2) {
						DigitalVideoDisc discAdd = DigitalVideoDisc.newDVD();
						Store.ViewStore.addDVDFromStoreToCart(store, cart, discAdd);
						System.out.println();
					}
					else if(choiceViewStore == 3) {
						cart.displayCart();
						
						int choiceSeeCart = 0;
						do {
							SeeCurrentCart.menu();
							System.out.print("Choose: ");
							choiceSeeCart = scanner.nextInt();
							
							if(choiceSeeCart == 1) {
								SeeCurrentCart.filterDVDs(cart);
								System.out.println();
							}
							else if(choiceSeeCart == 2) {
								SeeCurrentCart.sortDVDs(cart);
								System.out.println();
							}
							else if(choiceSeeCart == 3) {
								int choiceRemove = 0;
								System.out.println("1. Remove by ID, or");
								System.out.println("2. Remove by DVD's information");
								System.out.print("Choose: ");
								choiceRemove = scanner.nextInt();
								
								if(choiceRemove == 1) {
									System.out.print("Input Removed ID: ");
									int ID = scanner.nextInt();
									SeeCurrentCart.removeDVD(cart, ID);
								}
								else if(choiceRemove == 2) {
									DigitalVideoDisc DVDRemoved = DigitalVideoDisc.newDVD();
									SeeCurrentCart.removeDVD(cart, DVDRemoved);
								}
								
								System.out.println();
							}
							else if(choiceSeeCart == 4) {
								SeeCurrentCart.placeOrder(cart);
								System.out.println();
							}
						} while(choiceSeeCart != 0);
					}
				} while(choiceViewStore != 0);
			}
			else if(choice == 2) {
				int choiceUpdateStore = 0;
				do {
					UpdateStore.menu();
					System.out.print("Choose: ");
					choiceUpdateStore = scanner.nextInt();
					
					if(choiceUpdateStore == 1) {
						DigitalVideoDisc discAdd = DigitalVideoDisc.newDVD();
						UpdateStore.addDVDToStore(store, discAdd);
						System.out.println();
					}
					else if(choiceUpdateStore == 2) {
						int choiceRemove = 0;
						System.out.println("1. Remove by ID, or");
						System.out.println("2. Remove by DVD's information");
						System.out.print("Choose: ");
						choiceRemove = scanner.nextInt();
						
						if(choiceRemove == 1) {
							System.out.print("Input Removed ID: ");
							int ID = scanner.nextInt();
							UpdateStore.removeDVDFromStore(store, ID);
						}
						else if(choiceRemove == 2) {
							DigitalVideoDisc DVDRemoved = DigitalVideoDisc.newDVD();
							UpdateStore.removeDVDFromStore(store, DVDRemoved);
						}
						
						System.out.println();
					}
				} while(choiceUpdateStore != 0);
				
			}
			else if(choice == 3) {
				cart.displayCart();
				
				int choiceSeeCart = 0;
				do {
					SeeCurrentCart.menu();
					System.out.print("Choose: ");
					choiceSeeCart = scanner.nextInt();
					
					if(choiceSeeCart == 1) {
						SeeCurrentCart.filterDVDs(cart);
					}
					else if(choiceSeeCart == 2) {
						SeeCurrentCart.sortDVDs(cart);
					}
					else if(choiceSeeCart == 3) {
						int choiceRemove = 0;
						System.out.println("1. Remove by ID, or");
						System.out.println("2. Remove by DVD's information");
						System.out.print("Choose: ");
						choiceRemove = scanner.nextInt();
						
						if(choiceRemove == 1) {
							System.out.print("Input Removed ID: ");
							int ID = scanner.nextInt();
							SeeCurrentCart.removeDVD(cart, ID);
						}
						else if(choiceRemove == 2) {
							DigitalVideoDisc DVDRemoved = DigitalVideoDisc.newDVD();
							SeeCurrentCart.removeDVD(cart, DVDRemoved);
						}
					}
					else if(choiceSeeCart == 4) {
						SeeCurrentCart.placeOrder(cart);
					}
					
					System.out.println();
				} while(choiceSeeCart != 0);
			}
		} while(choice != 0);
		
		scanner.close();
	}	

}
