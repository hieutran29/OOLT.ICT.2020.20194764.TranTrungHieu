package hust.soict.globalict.aims;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.disc.DigitalVideoDisc;

public class DiskTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cart cart = new Cart();

		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 90, 24f);
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 100, 24f);

		cart.addDigitalVideoDisc(dvd1, dvd2, dvd3, dvd4, dvd5);

		DigitalVideoDisc[] search = cart.searchByTitle("the lion");
		if(search.length != 0) {
			System.out.println("Search \"the lion\": Found - OK");
		}
		else {
			System.out.println("Search \"the lion\": Not Found - False");
		}

		search = cart.searchByTitle("loin king");
		if(search.length != 0) {
			System.out.println("Search \"loin king\": Found - OK");
		}
		else {
			System.out.println("Search \"loin\": Not Found - False");
		}

		search = cart.searchByTitle("gniK noiL");
		if(search.length == 0) {
			System.out.println("Search \"gniK noiL\": NOT FOUND - OK");
		}
		else {
			System.out.println("Search \"gniK noiL\": FOUND - False");
		}

		search = cart.searchByTitle("War");
		if(search.length == 0) {
			System.out.println("Search \"War\": NOT FOUND - OK");
		}
		else {
			System.out.println("Search \"War\": Found - False");
		}

		search = cart.searchByTitle("raW");
		if(search.length == 0) {
			System.out.println("Search \"raW\": NOT FOUND - OK");
		}
		else {
			System.out.println("Search \"raW\": FOUND - False");
		}
	}

}