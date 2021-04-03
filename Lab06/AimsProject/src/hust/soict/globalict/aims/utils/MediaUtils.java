package hust.soict.globalict.aims.utils;

import java.util.Arrays;
import java.util.Comparator;

import hust.soict.globalict.aims.media.Media;

public class MediaUtils {
	public static int compareByCost(Media dvd1, Media dvd2) {
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
	
	public static int compareByTitle(Media dvd1, Media dvd2) {
		return dvd1.title().compareToIgnoreCase(dvd2.title());
	}
	
	public static Media[] sortByCost(Media[] disc) {
		Arrays.sort(disc, new Comparator<Media> () {
			public int compare(Media disc1, Media disc2) {
				return compareByCost(disc1, disc2);
			}
		});
		return disc;
	}
	
	public static Media[] sortByTitle(Media[] disc) {
		Arrays.sort(disc, new Comparator<Media> () {
			public int compare(Media disc1, Media disc2) {
				return compareByTitle(disc1, disc2);
			}
		});
		return disc;
	}
}
