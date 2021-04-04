package hust.soict.globalict.aims.store;

import java.util.ArrayList;
import java.util.Iterator;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.Media;

public class Store {
	private ArrayList<Media> itemsInStore;
	
	public Store() {
		super();
		itemsInStore = new ArrayList<Media> ();
	}
	
	public boolean exists(Media media) {
		for(Media i : itemsInStore) {
			if(i.equals(media) == 0) {
				return true;
			}
		}
		return false;
	}
	
	public int addMedia(Media media) {
		if(media == null) {
			System.out.println("ERROR: media = NULL");
			return -1;
		}
		this.itemsInStore.add(media.clone());
		System.out.printf("Added %s to store\n", media.title());
		return 0;
	}

	public int addMedia(Media ... mediaList) {
		int countNullObjects = 0;
		for(int i = 0; i < mediaList.length; i++) {
			if(mediaList[i] != null) {
				this.itemsInStore.add(mediaList[i].clone());
				System.out.printf("Added %s to store\n", mediaList[i].title());
			}
			else {
				countNullObjects += 1;
			}
		}
		System.out.printf("Added %d objects to store; Ignored %d NULL objects",
							mediaList.length - countNullObjects, countNullObjects);
		return 0;
	}
	
	public int removeMedia(Media media) {
		if(media == null) {
			System.out.println("ERROR: Object = NULL");
			return -1;
		}

		Iterator<Media> iter = this.itemsInStore.iterator();
		
		int countRemoved = 0;
		while(iter.hasNext()) {
			Media elem = iter.next();
			if(elem.equals(media) == 0) {
				iter.remove();
				countRemoved++;
				System.out.println("Remove ID" + elem.ID());
			}
		}
		
		if(countRemoved == 0) {
			System.out.println("NO MATCHING Media FOUND");
			return -1;
		}
		
		return 0;
	}
	
	public int removeMedia(int removedID) {
		int indexRemoved = -1;
		for(int i = 0; i < itemsInStore.size(); i++) {
			if(itemsInStore.get(i).ID() == removedID) {
				indexRemoved = i;
			}
		}
		
		if(indexRemoved == -1) {
			System.out.println("NO MATCHING ID FOUND");
			return -1;
		}
		itemsInStore.remove(indexRemoved);
		return 0;
	}
	
	/**
	 * Search a Media object's detail
	 * @param store	Store where the object is located
	 * @param ID	ID of the object to be searched
	 * @return	Media object that has ID matched to ID
	 */
	public Media searchByID(int ID) {
		for(Media i : itemsInStore) {
			if(i.ID() == ID) {
				return i;
			}
		}
		System.out.println("NO ID MATCHING FOUND");
		return null;
	}

	public static void showMenu() {
		System.out.println("AIMS: ");
		System.out.println("--------------------------------");
		System.out.println("\t1. View store");
		System.out.println("\t2. Update store");
		System.out.println("\t3. See current cart");
		System.out.println("\t0. Exit");
		System.out.println("--------------------------------");
	}

	public void printMediasInStore() {
		for(Media e : this.itemsInStore) {
			e.displayDetail();
			System.out.println();
		}
	}
}
