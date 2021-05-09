package hust.soict.globalict.aims.data;

import java.util.ArrayList;
import java.util.List;

import hust.soict.globalict.aims.model.book.Book;
import hust.soict.globalict.aims.model.disc.CD;
import hust.soict.globalict.aims.model.disc.DigitalVideoDisc;
import hust.soict.globalict.aims.model.disc.Track;
import hust.soict.globalict.aims.model.store.Store;

public class StoreDB {
	public static Store store = new Store();

    public StoreDB() {
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 90, 24f);
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 100, 24f);

		
		CD cd1 = new CD("Future Nostalgia", "Multi", "Warner", "Dua Lipa", new ArrayList<Track> (
							List.of(new Track("Future Nostalgia", 3), 
									new Track("Don't Start Now", 3),
									new Track("Levitating", 3))
		), 100f);

		CD cd2 = new CD("The Album", "Pop/Dance", "YG", "BlackPink", new ArrayList<Track> (
							List.of(new Track("How you like that", 3), 
									new Track("Pretty Savage", 3),
									new Track("Lovesick Girls", 3))
		), 100f);

		CD cd3 = new CD("Folklore", "Fold", "Republic", "Taylor Swift", new ArrayList<Track> (
							List.of(new Track("Cardigan", 4), 
									new Track("The 1", 3))
		), 100f);

		Book book1 = new Book("Dac Nhan Tam", "Giao duc", "", new String[] { "Dale Carnergie" }, 5f);
		Book book2 = new Book("Tam Quoc", "Lich su TQ", "", new String[] { "La Quan Trung" }, 5f);
		Book book3 = new Book("Tu dien Anh-Viet", "Giao duc", "Translate English words to Vietnamese", new String[] { "Oxford", "NXB Giao Duc" }, 2f);

		store.addMedia(dvd1);
		store.addMedia(dvd2);
		store.addMedia(dvd3);
		store.addMedia(dvd4);
		store.addMedia(dvd5);
		store.addMedia(cd1, cd2, cd3);
		store.addMedia(book1, book2, book3);
    }
}
