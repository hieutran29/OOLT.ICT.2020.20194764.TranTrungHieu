package hust.soict.globalict.test.utils;
import hust.soict.globalict.aims.model.disc.DigitalVideoDisc;
import hust.soict.globalict.aims.model.media.Media;
import hust.soict.globalict.aims.utils.MediaUtils;

public class DVDTest {
	public static void main(String[] args) {
		Media dvd1 = new DigitalVideoDisc("AAAA", "aaaa", "aaaa", 1, 5.6f);
		Media dvd2 = new DigitalVideoDisc("BBBB", "bbbb", "bbbb", 2, 5.3f);
		Media dvd3 = new DigitalVideoDisc("CCCC", "cccc", "cccc", 3, 5f);
		Media dvd4 = new DigitalVideoDisc("DDDD", "dddd", "dddd", 4, 7.1f);
		Media dvd5 = new DigitalVideoDisc("EEEE", "eeee", "eeee", 5, 3.3f);
		
		int compareByCost = MediaUtils.compareByCost(dvd1, dvd2);
		if(compareByCost == 0) {
			System.out.println("dvd1.cost() == dvd2.cost()");
		}
		else if(compareByCost == -1) {
			System.out.println("dvd1.cost() < dvd2.cost()");
		}
		else {
			System.out.println("dvd1.cost() > dvd2.cost()");
		}
		System.out.println();
		
		int compareByTitle = MediaUtils.compareByTitle(dvd1, dvd2);
		if(compareByTitle == 0) {
			System.out.println("dvd1.title() == dvd2.title()");
		}
		else if(compareByTitle == -1) {
			System.out.println("dvd1.title() < dvd2.title()");
		}
		else {
			System.out.println("dvd1.title() > dvd2.title()");
		}
		System.out.println();
		
		Media[] sorted = MediaUtils.sortByCost(new Media[]
									{dvd1, dvd2, dvd3, dvd4, dvd5});
		System.out.println("Sort by cost:");
		for(int i = 0; i < sorted.length; i++) {
			System.out.println(sorted[i].toString());
			System.out.println();
		}
		System.out.println();
		
		sorted = MediaUtils.sortByTitle(new Media[]
				{dvd1, dvd2, dvd3, dvd4, dvd5});
		System.out.println("Sort by title:");
		for(int i = 0; i < sorted.length; i++) {
			System.out.println(sorted[i].toString());
			System.out.println();
		}
	}
}
