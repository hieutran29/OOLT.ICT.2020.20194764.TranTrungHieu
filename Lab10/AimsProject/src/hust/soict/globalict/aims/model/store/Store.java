package hust.soict.globalict.aims.model.store;

import java.util.ArrayList;

import hust.soict.globalict.aims.model.media.Media;

public class Store {
	private ArrayList<Media> itemsInStore;
	
	public Store() {
		super();
		itemsInStore = new ArrayList<Media> ();
	}
	
	public ArrayList<Media> getItemsInStore() {
		return this.itemsInStore;
	}

	public boolean contains(Media media) {
		return itemsInStore.contains(media);
	}
	
	public int addMedia(Media media) {
		if(media == null) {
			return -1;
		}
		if(itemsInStore.contains(media)) {
			return -1;
		}
		this.itemsInStore.add(media.clone());
		return 0;
	}

	public int addMedia(Media ... mediaList) {
		int countNullObjects = 0;
		for(int i = 0; i < mediaList.length; i++) {
			if(mediaList[i] != null && !itemsInStore.contains(mediaList[i])) {
				this.itemsInStore.add(mediaList[i].clone());
			}
			else {
				countNullObjects += 1;
			}
		}
		return 0;
	}
	
	public int removeMedia(Media media) {
		if(media == null) {
			return -1;
		}
		
		if(this.itemsInStore.size() <= 0) {
			return -1;
		}
		if(this.itemsInStore.size() > 0) {
			this.itemsInStore.remove(media);
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
		return null;
	}

	public void printMediasInStore() {
		for(Media e : this.itemsInStore) {
			System.out.println(e.toString());
			System.out.println();
		}
	}
}
