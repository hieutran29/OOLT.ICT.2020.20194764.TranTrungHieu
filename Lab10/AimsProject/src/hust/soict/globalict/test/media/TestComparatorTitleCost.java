package hust.soict.globalict.test.media;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import hust.soict.globalict.aims.model.book.Book;
import hust.soict.globalict.aims.model.disc.CD;
import hust.soict.globalict.aims.model.disc.DigitalVideoDisc;
import hust.soict.globalict.aims.model.disc.Track;
import hust.soict.globalict.aims.model.media.Media;

public class TestComparatorTitleCost {
    public static void main(String[] args) {
        Collection<Media> collection = new ArrayList<Media> ();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 90, 24f);

        CD cd1 = new CD("Future Nostalgia", "Multi", "Warner", "Dua Lipa", new ArrayList<Track> (
							List.of(new Track("Future Nostalgia", 3), 
									new Track("Don't Start Now", 3),
									new Track("Levitating", 3))
		), 100f);
        CD cd2 = new CD("Folklore", "Fold", "Republic", "Taylor Swift", new ArrayList<Track> (
            List.of(new Track("Cardigan", 4), 
                    new Track("The 1", 3))
        ), 100f);

        Book book1 = new Book("Dac Nhan Tam", "Giao duc", "", new String[] { "Dale Carnergie" }, 5f);
		Book book2 = new Book("Tam Quoc", "Lich su TQ", "", new String[] { "La Quan Trung" }, 5f);

        collection.add(dvd1);
        collection.add(dvd2);
        collection.add(dvd3);
        collection.add(cd1);
        collection.add(cd2);
        collection.add(book1);
        collection.add(book2);

        for(Media media : collection) {
            System.out.println(media.title());
        }

        // sort the collection
        Collections.sort((List<Media>) collection, Media.COMPARE_BY_TITLE_COST);

        System.out.println("-----------");
        System.out.println("After sorted: ");
        for(Media media : collection) {
            System.out.println(media.toString());
        }
        System.out.println("-----------");
    }
}
