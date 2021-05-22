package hust.soict.globalict.aims.model.store;

import java.util.NoSuchElementException;

import hust.soict.globalict.aims.exception.AlreadyExistedException;
import hust.soict.globalict.aims.model.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Store {
	private ObservableList<Media> itemsInStore;
	
	public Store() {
		super();
		itemsInStore = FXCollections.observableArrayList();
	}
	
	public ObservableList<Media> getItemsInStore() {
		return this.itemsInStore;
	}

	public boolean contains(Media media) {
		return itemsInStore.contains(media);
	}
	
	public void addMedia(Media media) throws AlreadyExistedException {
		try {
			if(itemsInStore.contains(media)) {
				throw new AlreadyExistedException("Media already existed in store");
			}
			this.itemsInStore.add(media.clone());
		} catch(NullPointerException e) {
			throw new NullPointerException("Media is NULL");
		}
	}

	public int addMedia(Media ... mediaList) {
		for(int i = 0; i < mediaList.length; i++) {
			if(mediaList[i] != null && !itemsInStore.contains(mediaList[i])) {
				this.itemsInStore.add(mediaList[i].clone());
			}
		}
		return 0;
	}
	
	public void removeMedia(Media media) {
		if(media == null) {
			throw new NullPointerException("Cannot remove, media is full");
		}

		if(itemsInStore.size() <= 0) {
			throw new NoSuchElementException("Store is empty");
		}
		
		this.itemsInStore.remove(media);
	}
	
	public void removeMedia(int removedID) {
		if(itemsInStore.size() <= 0) {
			throw new NoSuchElementException("Store is empty");
		}
		
		int indexRemoved = -1;
		for(int i = 0; i < itemsInStore.size(); i++) {
			if(itemsInStore.get(i).getID() == removedID) {
				indexRemoved = i;
			}
		}
		
		if(indexRemoved == -1) {
			throw new NoSuchElementException("Media with ID " + removedID + "does not exist");
		}
		
		itemsInStore.remove(indexRemoved);
	}
	
	/**
	 * Search a Media object's detail
	 * @param store	Store where the object is located
	 * @param ID	ID of the object to be searched
	 * @return	Media object that has ID matched to ID
	 */
	public Media searchByID(int ID) {
		for(Media i : itemsInStore) {
			if(i.getID() == ID) {
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
