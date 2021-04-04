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
		if(media == null) {
			System.out.println("ERROR: Cannot add a NULL object. Object is ignored");
			return -1;
		}
		if(this.itemsOrdered.size() + 1 > MAX_NUMBER_ORDERED) {
			System.out.printf("Cannot add more media!! You have %d order(s) left\n", 
								MAX_NUMBER_ORDERED - this.itemsOrdered.size());
			return -1;
		}
        this.itemsOrdered.add(media);
        System.out.printf("Added %s to cart\n", media.title());
		return 0;
	}
	
	public int addMedia(Media ... mediaList) {
		int countNullObjects = 0;
		for(Media media : mediaList) {
			if(media == null) {
				countNullObjects += 1;
			}
		}

		if(this.itemsOrdered.size() + (mediaList.length - countNullObjects) > MAX_NUMBER_ORDERED) {
			System.out.printf("Cannot add more media!! You have %d order(s) left\n", 
								MAX_NUMBER_ORDERED - this.itemsOrdered.size());
			return -1;
		}

		for(int i = 0; i < mediaList.length; i++) {
			if(mediaList[i] != null) {
				this.itemsOrdered.add(mediaList[i]);
				System.out.printf("Added %s to cart\n", mediaList[i].title());
			}
		}
		System.out.printf("Added %d objects to cart; Ignored %d NULL objects",
							mediaList.length - countNullObjects, countNullObjects);
		return 0;
	}

	public int addMedia(Media media1, Media media2) {
		int countNullObjects = 0;
		countNullObjects = (media1 != null ? 0 : 1) + (media2 != null ? 0 : 1);

		if(this.itemsOrdered.size() + (2 - countNullObjects) > MAX_NUMBER_ORDERED) {
			System.out.printf("Cannot add more media!! You have %d order(s) left\n", 
								MAX_NUMBER_ORDERED - this.itemsOrdered.size());
			return -1;
		}

		if(media1 != null) {
			this.itemsOrdered.add(media1);
			System.out.printf("Added %s to cart\n", media1.title());
		}
		if(media2 != null) {
			this.itemsOrdered.add(media2);
			System.out.printf("Added %s to cart\n", media2.title());
		}

		System.out.printf("Added %d media(s) to cart; Ignored %d NULL objects\n",
							2 - countNullObjects, countNullObjects);
		return 0;
	}

	/**
	 * Remove DVD(s) in the cart that have attributes 
	 * matching to attributes of media with case-insensitive.
	 * @param media element to be removed from cart
	 * @return 0 if successful, -1 if failed
	 */
	public int removeMedia(Media media) {
		if(media == null) {
			System.out.println("ERROR: Object = NULL");
			return -1;
		}
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

	public Media getLuckyItem() {
		List<Integer> ids = new ArrayList<Integer>();
		int maxID = -1;

		for(Media item : this.itemsOrdered) {
			ids.add(item.ID());
			maxID = Math.max(maxID, item.ID());
		}

		int luckyID = (int) (Math.random() * (double) (maxID + 1));
		for(Media item : itemsOrdered) {
			if(item.ID() == luckyID) {
				item.setFree(true);
				return item;
			}
		}
		return null;
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
