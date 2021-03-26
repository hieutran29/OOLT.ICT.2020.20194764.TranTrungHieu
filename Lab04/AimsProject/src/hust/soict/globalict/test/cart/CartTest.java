package hust.soict.globalict.test.cart;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.disc.DigitalVideoDisc;

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
		
		int testRemoveWhenEmpty = cart.removeDigitalVideoDisc(dvd1);
		SUCC_FAIL_MSG("Remove When Empty", testRemoveWhenEmpty);
		System.out.println();
		
		int testAdding = cart.addDigitalVideoDisc(dvd1, dvd2, dvd3, dvd4, dvd5, dvd6);
		SUCC_FAIL_MSG("Adding To Cart", testAdding);
		System.out.println();
		
		cart.displayCart();
		System.out.println();
		
		int testRemoveDVD6 = cart.removeDigitalVideoDisc(dvd6);
		SUCC_FAIL_MSG("Remove DVD6", testRemoveDVD6);
		System.out.println();
		
		float totalCostAfterRemoveDVD6 = cart.totalCost();
		if(totalCostAfterRemoveDVD6 == 26.3f) {
			SUCC_FAIL_MSG("Cost After Remove DVD6 = 26.3", 0);
		}
		else if(totalCostAfterRemoveDVD6 != 26.3f) {
			SUCC_FAIL_MSG("Cost After Remove DVD6 = 26.3", -1);
		}
		System.out.println();
		
		System.out.println("Cart After Remove DVD6:");
		cart.displayCart();
		System.out.println();
		
		cart.sortByCostAscending();
		System.out.println("Sort Cart By Cost Ascending:");
		cart.printAllDVD();
		
		cart.sortByCostDescending();
		System.out.println("Sort Cart By Cost Descending:");
		cart.printAllDVD();
		
		cart.sortByTitle();
		System.out.println("Sort Cart by Title:");
		cart.printAllDVD();
		System.out.println();
		
		DigitalVideoDisc testSearchID3 = cart.searchByID(3);
		if(testSearchID3 != null) {
			System.out.println("Search ID 3:");
			testSearchID3.displayDetail();
			System.out.println();
			SUCC_FAIL_MSG("Search ID 3", 0);
		}
		else {
			System.out.println();
			SUCC_FAIL_MSG("Search ID 3", -1);
		}
		
		DigitalVideoDisc testSearchID6 = cart.searchByID(6);
		if(testSearchID6 != null) {
			System.out.println("Search ID 6:");
			testSearchID3.displayDetail();
			SUCC_FAIL_MSG("Search ID 6", 0);
		}
		else {
			SUCC_FAIL_MSG("Search ID 6", -1);
		
		}
		
	}

}
