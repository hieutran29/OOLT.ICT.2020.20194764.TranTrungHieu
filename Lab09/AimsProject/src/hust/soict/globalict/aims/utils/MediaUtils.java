package hust.soict.globalict.aims.utils;

import java.util.Arrays;
import java.util.Comparator;

import hust.soict.globalict.aims.model.media.Media;

public class MediaUtils {
	public static int compareByCost(Media o1, Media o2) {
		if(o1.cost() < o2.cost()) {
			return -1;
		}
		else if(o1.cost() > o2.cost()) {
			return 1;
		}
		else {
			return 0;
		}
	}
	
	public static int compareByTitle(Media o1, Media o2) {
		return o1.title().compareToIgnoreCase(o2.title());
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
