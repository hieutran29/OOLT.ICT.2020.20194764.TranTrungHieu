package hust.soict.globalict.aims;
/**
 * @author HieuTran
 */


import java.util.Scanner;

import javax.swing.JOptionPane;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.store.Store;
import hust.soict.globalict.aims.store.Store.SeeCurrentCart;
import hust.soict.globalict.aims.store.Store.UpdateStore;
import hust.soict.globalict.aims.store.Store.ViewStore;


public class Aims {
	static Cart cart;
	static Store store;
	static Scanner scanner;
		
		
	public static void main(String[] args) {
		cart = new Cart();
		store = new Store();
		scanner = new Scanner(System.in);
		
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
				viewStore();
			}
			else if(choice == 2) {
				updateStore();
			}
			else if(choice == 3) {
				seeCurrentCart();
			}
		} while(choice != 0);
		
		scanner.close();
	}	
	
	
	public static void viewStore() {
		store.printDVDsInStore();
		
		int choiceViewStore = 0;
		do {
			Store.ViewStore.menu();
			System.out.print("Choose: ");
			choiceViewStore = scanner.nextInt();
			
			if(choiceViewStore == 1) {
				System.out.print("Enter ID of DVD to see: ");
				int ID = scanner.nextInt();
				
				System.out.println("\n-----------");
				DigitalVideoDisc disc = Store.ViewStore.seeDVD(store, ID);
				if(disc != null) {
					disc.displayDetail();
				}
				System.out.println("\n-----------\n");
				
				if(disc != null) {
					int AddOrNot = 0;
					System.out.println("1. Add this DVD to Cart, or");
					System.out.println("0. Do nothing, exit");
					AddOrNot = scanner.nextInt();
					if(AddOrNot == 1) {
						ViewStore.addDVDFromStoreToCart(store, cart, disc);
					}
				}
				
				System.out.println();
			}
			else if(choiceViewStore == 2) {
				System.out.println("1. Add By ID");
				System.out.println("2. Add By DVD");
				System.out.print("Choose: ");
				int addMethod = scanner.nextInt();
				System.out.println();
				
				DigitalVideoDisc discAdd = null;
				if(addMethod == 1) {
					System.out.printf("Enter ID: ");
					int ID = scanner.nextInt();
					discAdd = store.searchByID(ID);
				}
				else if(addMethod == 2) {
					discAdd = DigitalVideoDisc.newDVD();
				}
				 
				if(discAdd != null) {
					Store.ViewStore.addDVDFromStoreToCart(store, cart, discAdd);
					System.out.println();
				}
			}
			else if(choiceViewStore == 3) {
				seeCurrentCart();
			}
		} while(choiceViewStore != 0);
	}
	
	public static void updateStore() {
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
	
	public static void seeCurrentCart() {
		cart.displayCart();
		
		int choiceSeeCart = 0;
		do {
			SeeCurrentCart.menu();
			System.out.print("Choose: ");
			choiceSeeCart = scanner.nextInt();
			
			if(choiceSeeCart == 1) {
				System.out.println("1. Filter by ID");
				System.out.println("2. Filter by Title");
				System.out.print("Choose: ");
				int filterChoice = scanner.nextInt();
				
				if(filterChoice == 1) {
					System.out.print("Enter ID: ");
					int ID = scanner.nextInt();
					SeeCurrentCart.filterDVDByID(cart, ID);
				}
				else {
					System.out.print("Enter Title: ");
					scanner.nextLine();
					String title = scanner.nextLine();
					SeeCurrentCart.filterDVDByTitle(cart, title);
				}
			}
			else if(choiceSeeCart == 2) {
				System.out.println("1. Sort by cost");
				System.out.println("2. Sort by title");
				System.out.println("Choose: ");
				int sortType = scanner.nextInt();
				
				if(sortType == 1) {
					SeeCurrentCart.sortDVDByCost(cart);
					cart.printAllDVD();
				}
				else if(sortType == 2) {
					SeeCurrentCart.sortDVDByTitle(cart);
					cart.printAllDVD();
				}
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

}
