package hust.soict.globalict.aims.utils;
import java.util.Arrays;
import java.util.Comparator;

import hust.soict.globalict.aims.model.disc.DigitalVideoDisc;


public class DVDUtils {
	public static int compareByCost(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		if(dvd1.cost() < dvd2.cost()) {
			return -1;
		}
		else if(dvd1.cost() > dvd2.cost()) {
			return 1;
		}
		else {
			return 0;
		}
	}
	
	public static int compareByTitle(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		return dvd1.title().compareToIgnoreCase(dvd2.title());
	}
	
	public static DigitalVideoDisc[] sortByCost(DigitalVideoDisc[] disc) {
		Arrays.sort(disc, new Comparator<DigitalVideoDisc> () {
			public int compare(DigitalVideoDisc disc1, DigitalVideoDisc disc2) {
				return compareByCost(disc1, disc2);
			}
		});
		return disc;
	}
	
	public static DigitalVideoDisc[] sortByTitle(DigitalVideoDisc[] disc) {
		Arrays.sort(disc, new Comparator<DigitalVideoDisc> () {
			public int compare(DigitalVideoDisc disc1, DigitalVideoDisc disc2) {
				return compareByTitle(disc1, disc2);
			}
		});
		return disc;
	}
}
