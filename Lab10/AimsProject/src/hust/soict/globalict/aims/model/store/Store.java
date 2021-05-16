package hust.soict.globalict.aims.model.store;

import java.util.ArrayList;

import hust.soict.globalict.aims.model.media.Media;
import hust.soict.globalict.aims.view.ErrorMessage;
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
	
	public int addMedia(Media media) {
		if(media == null) {
			return ErrorMessage.ITEM_NULL;
		}
		if(itemsInStore.contains(media)) {
			return ErrorMessage.ALREADY_EXISTED_IN_CART;
		}
		this.itemsInStore.add(media.clone());
		return 0;
	}

	public int addMedia(Media ... mediaList) {
		for(int i = 0; i < mediaList.length; i++) {
			if(mediaList[i] != null && !itemsInStore.contains(mediaList[i])) {
				this.itemsInStore.add(mediaList[i].clone());
			}
		}
		return 0;
	}
	
	public int removeMedia(Media media) {
		if(media == null) {
			return ErrorMessage.ITEM_NULL;
		}
		
		if(this.itemsInStore.size() <= 0) {
			return ErrorMessage.STORE_EMPTY;
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
			return ErrorMessage.NOT_FOUND;
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
