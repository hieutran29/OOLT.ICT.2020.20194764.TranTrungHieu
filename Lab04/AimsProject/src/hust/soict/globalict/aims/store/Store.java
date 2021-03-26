package hust.soict.globalict.aims.store;

import java.util.ArrayList;
import java.util.Iterator;

import hust.soict.globalict.aims.disc.DigitalVideoDisc;

public class Store {
	private ArrayList<DigitalVideoDisc> itemsInStore;
	
	public Store() {
		super();
		itemsInStore = new ArrayList<DigitalVideoDisc> ();
	}
	
	public int addDVD(DigitalVideoDisc disc) {
		this.itemsInStore.add(disc);
		return 0;
	}
	
	public int removeDVD(DigitalVideoDisc disc) {
		Iterator<DigitalVideoDisc> iter = this.itemsInStore.iterator();
		
		while(iter.hasNext()) {
			DigitalVideoDisc elem = iter.next();
			if(elem.title().compareToIgnoreCase(disc.title()) == 0 &&
			elem.category().compareToIgnoreCase(disc.category()) == 0 &&
			elem.director().compareToIgnoreCase(disc.director()) == 0 &&
			elem.length() == disc.length() && 
			elem.cost() == disc.cost()) {
				
				iter.remove();
			}
		}
		
		return 0;
	}
	
	public void printStore() {
		for(DigitalVideoDisc e : this.itemsInStore) {
			e.displayDetail();
			System.out.println();
		}
	}
}
