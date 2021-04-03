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
		this.itemsInStore.add(media);
		System.out.printf("Added %s to store\n", media.title());
		return 0;
	}

	public int addMedia(Media ... mediaList) {
		for(int i = 0; i < mediaList.length; i++) {
			this.itemsInStore.add(mediaList[i]);
			System.out.printf("Added %s to store\n", mediaList[i].title());
		}
		return 0;
	}
	
	public int removeMedia(Media media) {
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
	
	public static class ViewStore {
		public static void menu() {
			System.out.println("View Store: ");
			System.out.println("--------------------------------");
			System.out.println("\t1. See a Media detail");
			System.out.println("\t2. Add a Media to cart");
			System.out.println("\t3. See current cart");
			System.out.println("\t0. Exit");
			System.out.println("--------------------------------");
		}
		
		/**
		 * See a Media object's detail
		 * @param store	Store where the object is located
		 * @param ID	ID of the object
		 * @return	Media object that has ID matched to ID
		 */
		public static Media seeMedia(Store store, int ID) {
			return store.searchByID(ID);
		}
		
		/**
		 * Add a Media from Store to Cart 
		 * @param store Store which contains Media available to be added
		 * @param cart	Cart to where DigitalVideoDis is added
		 * @param media	Media object that exists in Store
		 * @return 0 if successful, -1 otherwise 
		 */
		public static int addMediaFromStoreToCart(Store store, Cart cart, Media media) {
			if(!store.exists(media)) {
				System.out.println("CANNOT ADD A NON-EXIST Media IN STORE TO A CART");
				return -1;
			}
			return cart.addMedia(media);
		}
		
	}
	
	public static class UpdateStore {
		public static void menu() {
			System.out.println("Update Store:");
			System.out.println("--------------------------------");
			System.out.println("\t1. Add Media to store");
			System.out.println("\t2. Remove Media from store");
			System.out.println("\t0. Exit");
			System.out.println("--------------------------------");
		}
		
		/**
		 * Add a Media to a Store
		 * @param store from where the Media is added
		 * @param media	the Media added to Store
		 * @return 0 if successful, -1 otherwise
		 */
		public static int addMediaToStore(Store store, Media media) {
			return store.addMedia(media);
		}
		
		/**
		 * Remove a Media from a Store
		 * @param store	from where Media is removed
		 * @param ID	ID of a Media removed from store
		 * @return 0 if successful, -1 otherwise
		 */
		public static int removeMediaFromStore(Store store, int ID) {
			return store.removeMedia(ID);
		}
	}
	
	public static class SeeCurrentCart {
		public static void menu() {
			System.out.println("See Current Cart: ");
			System.out.println("--------------------------------");
			System.out.println("\t1. Filter Medias in cart");
			System.out.println("\t2. Sort Medias in cart");
			System.out.println("\t3. Remove Media from cart");
			System.out.println("\t4. Get a lucky item from cart");
			System.out.println("\t5. Place order");
			System.out.println("\t0. Exit");
			System.out.println("--------------------------------");
		}
		
		public static void filterMediaByID(Cart cart, int ID) {
			Media found = cart.searchByID(ID);
			System.out.println("\n----------");
			if(found != null) {
				found.displayDetail();
			}
			else {
				System.out.println("NO Media MATCHING");
			}
			System.out.println("----------\n");
		}
		
		public static void filterMediaByTitle(Cart cart, String title) {
			Media[] found = cart.searchByTitle(title);
			if(found.length == 0) {
				System.out.println("NO Media MATCHING");
			}
			else {
				for(Media f : found) {
					f.displayDetail();
					System.out.println();
				}
			}
		}
		
		public static void sortMediaByCost(Cart cart) {
			cart.sortByCostDescending();
		}
		
		public static void sortMediaByTitle(Cart cart) {
			cart.sortByTitle();
		}
		
		public static int removeMedia(Cart cart, int ID) {
			return cart.removeMedia(ID);
		}

		public static Media getLuckyItem(Cart cart) {
			return cart.getLuckyItem();
		}
		
		public static void placeOrder(Cart cart) {
			System.out.println("An order is created");
			cart.clear();
		}
	}
}
