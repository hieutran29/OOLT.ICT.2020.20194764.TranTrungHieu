package hust.soict.globalict.test.cart;

import hust.soict.globalict.aims.model.book.Book;
import hust.soict.globalict.aims.model.cart.Cart;
import hust.soict.globalict.aims.model.disc.DigitalVideoDisc;
import hust.soict.globalict.aims.model.media.Media;

public class CartTest {
	public static void SUCC_FAIL_MSG(String message, int flag) {
		if(flag == 0) {
			System.out.println(message + ": OK!");
		}
		else if(flag == -1) {
			System.out.println(message + ": FAILED!");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cart cart = new Cart();

		DigitalVideoDisc dvd1 = new DigitalVideoDisc("AAAA", "aaaa", "aaaa", 1, 5.6f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("BBBB", "bbbb", "bbbb", 2, 5.3f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("CCCC", "cccc", "cccc", 3, 5f);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("DDDD", "dddd", "dddd", 4, 7.1f);
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("EEEE", "eeee", "eeee", 5, 3.3f);
		DigitalVideoDisc dvd6 = new DigitalVideoDisc("FFFF", "ffff", "ffff", 6, 2.5f);

		Book book1 = new Book("Dac Nhan Tam", "Giao duc", "", new String[] { "Dale Carnergie" }, 5f);
		Book book2 = new Book("Tam Quoc", "Lich su TQ", "", new String[] { "La Quan Trung" }, 5f);
		Book book3 = new Book("Lap trinh huong doi tuong", "Giao duc", "", new String[] { "" }, 2f);
		
		int testRemoveWhenEmpty = cart.removeMedia(dvd1);
		SUCC_FAIL_MSG("Remove When Empty", testRemoveWhenEmpty);
		System.out.println();
		
		int testAdding = cart.addMedia(dvd1, dvd2, dvd3, dvd4, dvd5, dvd6, book1, book2, book3);
		SUCC_FAIL_MSG("Adding To Cart", testAdding);
		System.out.println();
		
		cart.displayCart();
		System.out.println();
		
		int testRemoveDVD6 = cart.removeMedia(dvd6);
		SUCC_FAIL_MSG("Remove DVD6", testRemoveDVD6);
		System.out.println();
		
		float totalCostAfterRemoveID6 = cart.totalCost();
		if(totalCostAfterRemoveID6 == 38.3f) {
			SUCC_FAIL_MSG("Cost After Remove ID6 = 38.3", 0);
		}
		else if(totalCostAfterRemoveID6 != 38.3f) {
			SUCC_FAIL_MSG("Cost After Remove ID6 = 38.3", -1);
		}
		System.out.println();
		
		System.out.println("Cart After Remove DVD6:");
		cart.displayCart();
		System.out.println();
		
		cart.sortByCostAscending();
		System.out.println("Sort Cart By Cost Ascending:");
		cart.printAllMedia();
		System.out.println();
		
		cart.sortByCostDescending();
		System.out.println("Sort Cart By Cost Descending:");
		cart.printAllMedia();
		System.out.println();
		
		cart.sortByTitle();
		System.out.println("Sort Cart by Title:");
		cart.printAllMedia();
		System.out.println();
		
		Media testSearchID3 = cart.searchByID(3);
		if(testSearchID3 != null) {
			System.out.println("Search ID 3:");
			System.out.println(testSearchID3.getDetail());
			System.out.println();
			SUCC_FAIL_MSG("Search ID 3", 0);
		}
		else {
			System.out.println();
			SUCC_FAIL_MSG("Search ID 3", -1);
		}
		
		Media testSearchID6 = cart.searchByID(6);
		if(testSearchID6 != null) {
			System.out.println("Search ID 6:");
			System.out.println(testSearchID3.getDetail());
			SUCC_FAIL_MSG("Search ID 6 FOUND", -1);
		}
		else {
			SUCC_FAIL_MSG("Search ID 6 NOT FOUND", 0);
		
		}

		int testRemoveID8 = cart.removeMedia(8);
		SUCC_FAIL_MSG("Remove ID8", testRemoveID8);
		System.out.println();
		
		float totalCostAfterRemoveID8 = cart.totalCost();
		if(totalCostAfterRemoveID8 == 33.3f) {
			SUCC_FAIL_MSG("Cost After Remove ID8 = 33.3", 0);
		}
		else if(totalCostAfterRemoveID8 != 33.3f) {
			SUCC_FAIL_MSG("Cost After Remove ID8 = 33.3", -1);
		}
		System.out.println();
		
		System.out.println("Cart After Remove ID8:");
		cart.displayCart();
		System.out.println();
		
	}

}
