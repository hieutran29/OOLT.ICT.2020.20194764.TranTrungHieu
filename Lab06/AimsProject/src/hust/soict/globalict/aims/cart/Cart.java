package hust.soict.globalict.aims.cart;
/**
 * @author HieuTran
 */


import java.util.*;

import hust.soict.globalict.aims.media.*;
import hust.soict.globalict.aims.utils.MediaUtils;

public class Cart {
	public final static int MAX_NUMBER_ORDERED = 20;
	private ArrayList<Media> itemsOrdered = new ArrayList<Media> ();

	public Cart() {
		super();
	}

	public int addMedia(Media media) {
        this.itemsOrdered.add(media);
        System.out.printf("Added %s to cart\n", media.title());
		return 0;
	}
	
	public int addMedia(Media ... mediaList) {
		for(int i = 0; i < mediaList.length; i++) {
			this.itemsOrdered.add(mediaList[i]);
			System.out.printf("Added %s to cart\n", mediaList[i].title());
		}
		return 0;
	}

	public int addMedia(Media dvd1, Media dvd2) {
		this.itemsOrdered.add(dvd1);
		this.itemsOrdered.add(dvd2);
		System.out.printf("Added %s to cart\n", dvd1.title());
		System.out.printf("Added %s to cart\n", dvd2.title());
		return 0;
	}

	/**
	 * Remove DVD(s) in the cart that have attributes 
	 * matching to attributes of media with case-insensitive.
	 * @param media element to be removed from cart
	 * @return 0 if successful, -1 if failed
	 */
	public int removeMedia(Media media) {
		if(this.itemsOrdered.size() <= 0) {
			System.out.println("Your order is empty!");
			return -1;
		}
		else {
			Iterator<Media> iter = this.itemsOrdered.iterator();
			
			int countRemoved = 0;
			while(iter.hasNext()) {
				Media elem = iter.next();
				if(elem.equals(media) == 0) {
					System.out.println("Remove ID" + elem.ID());
					iter.remove();
					countRemoved += 1;
				}
			}
			if(countRemoved == 0) {
				System.out.println(media.title() + ": not found");
				return -1;
			}
		}
		return 0;
	}
	
	public int removeMedia(int removedID) {
		int indexRemoved = -1;
		for(int i = 0; i < itemsOrdered.size(); i++) {
			if(itemsOrdered.get(i).ID() == removedID) {
				indexRemoved = i;
			}
		}
		
		if(indexRemoved == -1) {
			System.out.println("NO MATCHING ID FOUND");
			return -1;
		}
		itemsOrdered.remove(indexRemoved);
		return 0;
	}

    public float totalCost() {	
		float cost = 0;
		for(Media item : itemsOrdered) {
			cost += item.cost();
		}
		return cost;
	}
	/**
	 * 
	 * @param ID ID of the DVD to be searched
	 * @return a Media object if found, null otherwise
	 */
	public Media searchByID(int ID) {
		for(Media dvd : this.itemsOrdered) {
			if(dvd.ID() == ID) {
				return dvd;
			}
		}
		return null;
	}

	/**
	 * Search for the first Media object that at least one token of title
	 * is a substring of media.title.
	 * @param title title wanted to search, can contains many tokens separated by whitespace.
	 * @return an array Media objects that match the condition.
	 */
	public Media[] searchByTitle(String title) {
		Media[] ret = new Media[MAX_NUMBER_ORDERED];
		int found = 0;
		for(Media media : this.itemsOrdered) {
			if(media.search(title)) {
				ret[found++] = media;
			}
		}
		return Arrays.copyOf(ret, found);
	}
	
	public void sortByCostAscending() {
		// using lambda expression
		this.itemsOrdered.sort(new Comparator<Media> () {
			public int compare(Media media1, Media media2) {
				int compareByCost = MediaUtils.compareByCost(media1, media2);
				if(compareByCost == 0) {
					return MediaUtils.compareByTitle(media1, media2);
				}
				else {
					return compareByCost;
				}
			}
		});
	}
	
	public void sortByCostDescending() {
		// using lambda expression
		this.itemsOrdered.sort(new Comparator<Media> () {
			public int compare(Media media1, Media media2) {
				int compareByCost = -MediaUtils.compareByCost(media1, media2);
				if(compareByCost == 0) {
					return MediaUtils.compareByTitle(media1, media2);
				}
				else {
					return compareByCost;
				}
			}
		});
	}

	public void sortByTitle() {
		this.itemsOrdered.sort(new Comparator<Media> () {
			public int compare(Media media1, Media media2) {
				int compareByTitle = MediaUtils.compareByTitle(media1, media2);
				if(compareByTitle == 0) {
					return -MediaUtils.compareByCost(media1, media2);
				}
				else {
					return compareByTitle;
				}
			}
		});
	}
	
	/**
	 * Display the cart in alphabetical, then by descending cost, then by descending length
	 */
	public void displayCart() {
		// comparator function
		Comparator<Media> comparator = new Comparator<Media>() {
			@Override
			public int compare(Media media1, Media media2) {
				int compareByTitle = MediaUtils.compareByTitle(media1, media2);
				if(compareByTitle == 0) {
					int compareByCost = MediaUtils.compareByCost(media1, media2);
					return -compareByCost;
				}
				return compareByTitle;
			}
		};
		@SuppressWarnings("unchecked")
		ArrayList<Media> allMedias = (ArrayList<Media>) itemsOrdered.clone();
		Collections.sort(allMedias, comparator);
		
		System.out.println("*********CART*********");
		System.out.println("Ordered Items:");
		for(int i = 0; i < allMedias.size(); i++) {
			System.out.print((i + 1) + ". ");
			allMedias.get(i).displayDetail();
			System.out.println();
		}	
		System.out.println("Total cost: " + this.totalCost());
		System.out.println("******************");
	}
	
	public void clear() {
		this.itemsOrdered.clear();
	}
	
	public void printAllMedia() {
		// for debugging
		for(Media media : this.itemsOrdered) {
			media.displayDetail();
			System.out.println();
		}
	}
}
