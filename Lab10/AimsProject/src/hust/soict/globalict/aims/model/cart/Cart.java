package hust.soict.globalict.aims.model.cart;
/**
 * @author HieuTran
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import hust.soict.globalict.aims.model.media.Media;
import hust.soict.globalict.aims.utils.MediaUtils;
import hust.soict.globalict.aims.view.Message;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {
	public final static int MAX_NUMBER_ORDERED = 20;
	private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

	public Cart() {
		super();
	}
	
	public ObservableList<Media> getItemsOrdered() {
		return this.itemsOrdered;
	}

	public int addMedia(Media media) {
		if(media == null) {
			Message.printMessage("Object is NULL\n", Message.MESSAGE_ERROR);
			return -1;
		}
		if(this.itemsOrdered.size() + 1 > MAX_NUMBER_ORDERED) {
			Message.printMessage("The cart is almost full\n", Message.MESSAGE_WARNING);
			return -1;
		}
		if(itemsOrdered.contains(media)) {
			Message.printMessage("Object existed in cart\n", Message.MESSAGE_ERROR);
			return -1;
		}
        this.itemsOrdered.add(media.clone());
		Message.printMessage("Add " + media.getTitle() + " to cart\n", Message.MESSAGE_INFORMATION);
		return 0;
	}
	
	public int addMedia(Media ... mediaList) {
		if(this.itemsOrdered.size() + mediaList.length > MAX_NUMBER_ORDERED) {
			Message.printMessage("The cart is almost full\n", Message.MESSAGE_WARNING);
			return -1;
		}

		for(int i = 0; i < mediaList.length; i++) {
			if(mediaList[i] != null && !itemsOrdered.contains(mediaList[i])) {
				this.itemsOrdered.add(mediaList[i].clone());
				Message.printMessage("Add " + mediaList[i].getTitle() + " to cart\n", Message.MESSAGE_INFORMATION);
			}
		}
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
			Message.printMessage("Object is NULL\n", Message.MESSAGE_ERROR);
			return -1;
		}

		if(this.itemsOrdered.size() <= 0) {
			Message.printMessage("Cart is empty\n", Message.MESSAGE_ERROR);
			return -1;
		}
		this.itemsOrdered.remove(media);
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
			Message.printMessage("No matching ID\n", Message.MESSAGE_ERROR);
			return -1;
		}
		itemsOrdered.remove(indexRemoved);
		return 0;
	}

    public float totalCost() {	
		float cost = 0;
		for(Media item : itemsOrdered) {
			cost += item.getCost();
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

		int luckyID = (int) (Math.random() * (double) maxID) + 1;
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
		this.itemsOrdered.sort(Media.COMPARE_BY_COST_TITLE);
	}

	public void sortByTitle() {
		this.itemsOrdered.sort(Media.COMPARE_BY_TITLE_COST);
	}
	
	/**
	 * Display the cart in alphabetical, then by descending cost, then by descending length
	 */
	public void displayCart() {
		// comparator function
//		Comparator<Media> comparator = new Comparator<Media>() {
//			@Override
//			public int compare(Media media1, Media media2) {
//				int compareByTitle = MediaUtils.compareByTitle(media1, media2);
//				if(compareByTitle == 0) {
//					int compareByCost = MediaUtils.compareByCost(media1, media2);
//					return -compareByCost;
//				}
//				return compareByTitle;
//			}
//		};
//		@SuppressWarnings("unchecked")
//		ArrayList<Media> allMedias = (ArrayList<Media>) itemsOrdered.clone();
//		Collections.sort(allMedias, comparator);
//		
//		Message.printMessage("*********CART*********\n", Message.MESSAGE_PLAIN);
//		Message.printMessage("Ordered Items:\n", Message.MESSAGE_PLAIN);
//		for(int i = 0; i < allMedias.size(); i++) {
//			System.out.print((i + 1) + ". ");
//			Message.printMessage(allMedias.get(i).toString(), Message.MESSAGE_PLAIN);
//			Message.printMessage("\n", Message.MESSAGE_PLAIN);
//		}
//		Message.printMessage("Total cost: " + this.totalCost() + "\n", Message.MESSAGE_PLAIN);
//		Message.printMessage("******************\n", Message.MESSAGE_PLAIN);
	}
	
	public void clear() {
		this.itemsOrdered.clear();
	}
	
	public void printAllMedia() {
		// for debugging
		for(Media media : this.itemsOrdered) {
			Message.printMessage(media.toString(), Message.MESSAGE_PLAIN);
			Message.printMessage("\n", Message.MESSAGE_PLAIN);
		}
	}
}
