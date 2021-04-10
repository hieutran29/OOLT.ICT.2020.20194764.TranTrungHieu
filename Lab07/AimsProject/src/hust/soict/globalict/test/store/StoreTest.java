package hust.soict.globalict.test.store;

import hust.soict.globalict.aims.media.book.Book;
import hust.soict.globalict.aims.media.disc.DigitalVideoDisc;
import hust.soict.globalict.aims.store.Store;

public class StoreTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Store store = new Store();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 90, 24f);
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 100, 24f);
		DigitalVideoDisc dvd6 = new DigitalVideoDisc("AAAA", "aaaa", "aaaa", 6, 100f);
		
		Book book1 = new Book("Dac Nhan Tam", "Giao duc", "", new String[] { "Dale Carnergie" }, 5f);
		Book book2 = new Book("Tam Quoc", "Lich su TQ", "", new String[] { "La Quan Trung" }, 5f);
		Book book3 = new Book("Lap trinh huong doi tuong", "Giao duc", "", new String[] { "" }, 2f);

		store.addMedia(dvd1);
		store.addMedia(dvd2);
		store.addMedia(dvd3);
		store.addMedia(dvd4);
		store.addMedia(dvd5);
		store.addMedia(dvd6);

		store.addMedia(book1);
		store.addMedia(book2);
		store.addMedia(book3);
		
		System.out.println("Store before removing id6");
		store.printMediasInStore();
		
		store.removeMedia(dvd6);
		System.out.println("Store after removing id6");
		store.printMediasInStore();

		store.removeMedia(7);
		System.out.println("Store after removing id7");
		store.printMediasInStore();
	}

}
