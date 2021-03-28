package hust.soict.globalict.aims.store;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.disc.DigitalVideoDisc;

public class Store {
	private ArrayList<DigitalVideoDisc> itemsInStore;
	
	public Store() {
		super();
		itemsInStore = new ArrayList<DigitalVideoDisc> ();
	}
	
	public boolean exists(DigitalVideoDisc disc) {
		for(DigitalVideoDisc i : itemsInStore) {
			if(i.compare(disc) == 0) {
				return true;
			}
		}
		return false;
	}
	
	public int addDVD(DigitalVideoDisc disc) {
		this.itemsInStore.add(disc);
		System.out.printf("Added %s to store\n", disc.title());
		return 0;
	}
	
	public int removeDVD(DigitalVideoDisc disc) {
		Iterator<DigitalVideoDisc> iter = this.itemsInStore.iterator();
		
		int countRemoved = 0;
		while(iter.hasNext()) {
			DigitalVideoDisc elem = iter.next();
			if(elem.compare(disc) == 0) {
				iter.remove();
				countRemoved++;
				System.out.println("Remove ID" + elem.ID());
			}
		}
		
		if(countRemoved == 0) {
			System.out.println("NO MATCHING DVD FOUND");
			return -1;
		}
		
		return 0;
	}
	
	public int removeDVD(int removedID) {
		int indexRemoved = -1;
		for(int i = 0; i < itemsInStore.size(); i++) {
			if(itemsInStore.get(i).ID() == removedID) {
				indexRemoved = i;
			}
		}
		
		if(indexRemoved == -1) {
			System.out.println("NO MATCHING ID FOUND");
			return -1;
		}
		itemsInStore.remove(indexRemoved);
		return 0;
	}

	public static void showMenu() {
		System.out.println("AIMS: ");
		System.out.println("--------------------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
	}

	public void printDVDsInStore() {
		for(DigitalVideoDisc e : this.itemsInStore) {
			e.displayDetail();
			System.out.println();
		}
	}
	
	public static class ViewStore {
		public static void menu() {
			System.out.println("Options: ");
			System.out.println("--------------------------------");
			System.out.println("1. See a DVD�s details");
			System.out.println("2. Add a DVD to cart");
			System.out.println("3. See current cart");
			System.out.println("0. Exit");
			System.out.println("--------------------------------");
			System.out.println("Please choose a number: 0-1-2-3");
		}
		
		public static void seeDVD(Store store, int ID) {
			for(DigitalVideoDisc i : store.itemsInStore) {
				if(i.ID() == ID) {
					i.displayDetail();
					System.out.println();
					return;
				}
			}
			System.out.println("NO ID MATCHING FOUND");
		}
		
		public static int addDVDFromStoreToCart(Store store, Cart cart, DigitalVideoDisc disc) {
			if(!store.exists(disc)) {
				System.out.println("CANNOT ADD A NON-EXIST DVD IN STORE TO A CART");
				return -1;
			}
			return cart.addDigitalVideoDisc(disc);
		}
		
	}
	
	public static class UpdateStore {
		public static void menu() {
			System.out.println("1. Add DVD to store");
			System.out.println("2. Remove DVD from store");
			System.out.println("0. Exit");
		}
		
		public static void addDVDToStore(Store store, DigitalVideoDisc disc) {
			store.addDVD(disc);
		}
		
		public static void removeDVDFromStore(Store store, DigitalVideoDisc disc) {
			store.removeDVD(disc);
		}
		
		public static void removeDVDFromStore(Store store, int ID) {
			store.removeDVD(ID);
		}
	}
	
	public static class SeeCurrentCart {
		public static void menu() {
			System.out.println("Options: ");
			System.out.println("--------------------------------");
			System.out.println("1. Filter DVDs in cart");
			System.out.println("2. Sort DVDs in cart");
			System.out.println("3. Remove DVD from cart");
			System.out.println("4. Place order");
			System.out.println("0. Exit");
			System.out.println("--------------------------------");
			System.out.println("Please choose a number: 0-1-2-3-4");
		}
		
		public static void filterDVDs(Cart cart) {
			Scanner scanner = new Scanner(System.in);
			int filterChoice = 0;
			do {
				System.out.println("1. Filter by ID");
				System.out.println("2. Filter by Title");
				System.out.print("Choose: ");
				filterChoice = scanner.nextInt();
				if(filterChoice == 1) {
					System.out.print("Enter ID: ");
					int ID = scanner.nextInt();
					DigitalVideoDisc found = cart.searchByID(ID);
					if(found != null) {
						found.displayDetail();
					}
					else {
						System.out.println("NO DVD MATCHING");
					}
				}
				else {
					System.out.print("Enter Title: ");
					scanner.nextLine();
					String title = scanner.nextLine();
					DigitalVideoDisc[] found = cart.searchByTitle(title);
					if(found.length == 0) {
						System.out.println("NO DVD MATCHING");
					}
					else {
						for(DigitalVideoDisc f : found) {
							f.displayDetail();
							System.out.println();
						}
					}
				}
			} while(filterChoice != 1 && filterChoice != 2);
		}
		
		public static void sortDVDs(Cart cart) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("1. Sort by cost");
			System.out.println("2. Sort by title");
			System.out.println("Choose: ");
			int sortType = scanner.nextInt();
			
			if(sortType == 1) {
				cart.sortByCostDescending();
				cart.printAllDVD();
			}
			else if(sortType == 2) {
				cart.sortByTitle();
				cart.printAllDVD();
			}
		}
		
		public static int removeDVD(Cart cart, DigitalVideoDisc disc) {
			return cart.removeDigitalVideoDisc(disc);
		}
		
		public static int removeDVD(Cart cart, int ID) {
			return cart.removeDigitalVideoDisc(ID);
		}
		
		public static void placeOrder(Cart cart) {
			System.out.println("An order is created");
			cart.clear();
		}
	}
}
