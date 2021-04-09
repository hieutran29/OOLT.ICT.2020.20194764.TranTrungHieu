package hust.soict.globalict.test.utils;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.utils.DVDUtils;

public class DVDTest {
	public static void main(String[] args) {
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("AAAA", "aaaa", "aaaa", 1, 5.6f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("BBBB", "bbbb", "bbbb", 2, 5.3f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("CCCC", "cccc", "cccc", 3, 5f);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("DDDD", "dddd", "dddd", 4, 7.1f);
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("EEEE", "eeee", "eeee", 5, 3.3f);
		
		int compareByCost = DVDUtils.compareByCost(dvd1, dvd2);
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
		
		int compareByTitle = DVDUtils.compareByTitle(dvd1, dvd2);
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
		
		DigitalVideoDisc[] sorted = DVDUtils.sortByCost(new DigitalVideoDisc[]
									{dvd1, dvd2, dvd3, dvd4, dvd5});
		System.out.println("Sort by cost:");
		for(int i = 0; i < sorted.length; i++) {
			sorted[i].displayDetail();
			System.out.println();
		}
		System.out.println();
		
		sorted = DVDUtils.sortByTitle(new DigitalVideoDisc[]
				{dvd1, dvd2, dvd3, dvd4, dvd5});
		System.out.println("Sort by title:");
		for(int i = 0; i < sorted.length; i++) {
			sorted[i].displayDetail();
			System.out.println();
		}
	}
}
