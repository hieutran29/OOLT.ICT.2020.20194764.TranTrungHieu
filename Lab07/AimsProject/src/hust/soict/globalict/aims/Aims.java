package hust.soict.globalict.aims;
/**
 * @author HieuTran
 */


import java.util.Scanner;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.store.Store;
import hust.soict.globalict.aims.utils.SeeCurrentCart;
import hust.soict.globalict.aims.utils.UpdateStore;
import hust.soict.globalict.aims.utils.ViewStore;


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

		Book book1 = new Book("Dac Nhan Tam", "Giao duc", "", new String[] { "Dale Carnergie" }, 5f);
		Book book2 = new Book("Tam Quoc", "Lich su TQ", "", new String[] { "La Quan Trung" }, 5f);
		Book book3 = new Book("Tu dien Anh-Viet", "Giao duc", "", new String[] { "Oxford", "NXB Giao Duc" }, 2f);

		store.addMedia(dvd1);
		store.addMedia(dvd2);
		store.addMedia(dvd3);
		store.addMedia(dvd4);
		store.addMedia(dvd5);

		store.addMedia(book1, book2, book3);
		
		Scanner scanner = new Scanner(System.in);
		int choice = 0;
		do {
			System.out.println();
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
		store.printMediasInStore();
		
		int choiceViewStore = 0;
		do {
			System.out.println();
			ViewStore.menu();
			System.out.print("Choose: ");
			choiceViewStore = scanner.nextInt();
			
			if(choiceViewStore == 1) {
				System.out.print("Enter ID of Media to see: ");
				int ID = scanner.nextInt();
				
				System.out.println("\n-----------");
				Media media = ViewStore.seeMedia(store, ID);
				if(media != null) {
					System.out.println(media.getDetail());
				}
				System.out.println("\n-----------\n");
				
				if(media != null) {
					int AddOrNot = 0;
					System.out.println("1. Add this Media to Cart, or");
					System.out.println("0. Do nothing, exit");
					System.out.print("Choose: ");
					AddOrNot = scanner.nextInt();
					if(AddOrNot == 1) {
						ViewStore.addMediaFromStoreToCart(store, cart, media);
					}
				}
				
				System.out.println();
			}
			else if(choiceViewStore == 2) {
				System.out.printf("Enter ID: ");
				int ID = scanner.nextInt();

				Media mediaAdd = store.searchByID(ID);
				 
				if(mediaAdd != null) {
					ViewStore.addMediaFromStoreToCart(store, cart, mediaAdd);
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
			System.out.println();
			UpdateStore.menu();
			System.out.print("Choose: ");
			choiceUpdateStore = scanner.nextInt();
			
			if(choiceUpdateStore == 1) {
				String title = "", category = "";
				float cost = 0.0f;

				System.out.println("1. Add a book");
				System.out.println("2. Add a DVD");
				System.out.println("0. Exit");
				System.out.print("Choose: ");
				int choice = scanner.nextInt();
				scanner.nextLine();

				System.out.print("Title: "); title = scanner.nextLine();
				System.out.print("Category: "); category = scanner.nextLine();
				System.out.print("Cost: "); cost = scanner.nextFloat();
				scanner.nextLine();

				if(choice == 1) {
					String content = "";
					String authors = "";

					System.out.print("List of authors (separated by ','): ");	
					authors = scanner.nextLine();
					System.out.print("Content: ");	content = scanner.nextLine();

					UpdateStore.addMediaToStore(store, new Book(title, category, content, authors.split("\\W+"), cost));
				}
				else if(choice == 2) {
					int length = 0;
					String director = "";

					System.out.print("\nDirector: ");	director = scanner.nextLine();
					System.out.print("\nLength: ");		length = scanner.nextInt();

					UpdateStore.addMediaToStore(store, new DigitalVideoDisc(title, category, director, length, cost));
				}
			}
			else if(choiceUpdateStore == 2) {
				System.out.print("Input Removed ID: ");
				int ID = scanner.nextInt();
				UpdateStore.removeMediaFromStore(store, ID);
				
				System.out.println();
			}
		} while(choiceUpdateStore != 0);
		
	}
	
	public static void seeCurrentCart() {
		System.out.println();
		cart.displayCart();
		
		int choiceSeeCart = 0;
		do {
			System.out.println();
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
					SeeCurrentCart.filterMediaByID(cart, ID);
				}
				else {
					System.out.print("Enter Title: ");
					scanner.nextLine();
					String title = scanner.nextLine();
					SeeCurrentCart.filterMediaByTitle(cart, title);
				}
			}
			else if(choiceSeeCart == 2) {
				System.out.println("1. Sort by cost");
				System.out.println("2. Sort by title");
				System.out.print("Choose: ");
				int sortType = scanner.nextInt();
				
				if(sortType == 1) {
					SeeCurrentCart.sortMediaByCost(cart);
					cart.printAllMedia();
				}
				else if(sortType == 2) {
					SeeCurrentCart.sortMediaByTitle(cart);
					cart.printAllMedia();
				}
			}
			else if(choiceSeeCart == 3) {
				System.out.print("Input Removed ID: ");
				int ID = scanner.nextInt();
				SeeCurrentCart.removeMedia(cart, ID);
			}
			else if(choiceSeeCart == 4) {
				Media luckyItem = SeeCurrentCart.getLuckyItem(cart);
				if(luckyItem == null) {
					System.out.println("Good Luck Next Time :(");
				}
				else {
					System.out.println(luckyItem.getDetail());
				}
			}
			else if(choiceSeeCart == 5) {
				SeeCurrentCart.placeOrder(cart);
			}
			
			System.out.println();
		} while(choiceSeeCart != 0);
	}

}
