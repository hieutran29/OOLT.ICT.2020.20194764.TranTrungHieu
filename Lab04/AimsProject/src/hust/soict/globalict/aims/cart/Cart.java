package hust.soict.globalict.aims.cart;
/**
 * @author HieuTran
 */


import java.util.*;

import javax.swing.*;

import hust.soict.globalict.aims.disc.DigitalVideoDisc;
import hust.soict.globalict.aims.utils.DVDUtils;

public class Cart {
	private final int MAX_NUMBER_ORDERED = 20;
	private int qtyOrdered = 0;
	private ArrayList<DigitalVideoDisc> itemsOrdered = new ArrayList<DigitalVideoDisc> ();
	
	public Cart() {
		super();
	}
	
	public int getQtyOrdered() {
		return qtyOrdered;
	}

	private void setQtyOrdered(int qtyOrdered) {
		this.qtyOrdered = qtyOrdered;
	}

	public int addDigitalVideoDisc(DigitalVideoDisc disc) {
		if(this.getQtyOrdered() >= this.MAX_NUMBER_ORDERED) {
			System.out.println("You cannot buy more DVD!");
			return -1;
		}
		else {
			this.itemsOrdered.add(disc);
			System.out.printf("Added %s to cart\n", disc.title());
			this.setQtyOrdered(this.itemsOrdered.size());
		}
		return 0;
	}
//	public int addDigitalVideoDisc(DigitalVideoDisc[] discList) {
//		if(this.getQtyOrdered() + discList.length > this.MAX_NUMBER_ORDERED) {
//			System.out.println("You cannot buy more DVD!");
//			return -1;
//		}
//		else {
//			for(int i = 0; i < discList.length; i++) {
//				this.itemsOrdered.add(discList[i]);
//			}
//			this.setQtyOrdered(this.itemsOrdered.size());
//		}
//		return 0;
//	}
	public int addDigitalVideoDisc(DigitalVideoDisc ... discList) {
		if(this.getQtyOrdered() + discList.length > this.MAX_NUMBER_ORDERED) {
			System.out.println("You cannot buy more DVD!");
			return -1;
		}
		else {
			for(int i = 0; i < discList.length; i++) {
				this.itemsOrdered.add(discList[i]);
				System.out.printf("Added %s to cart\n", discList[i].title());
			}
			this.setQtyOrdered(this.itemsOrdered.size());
		}
		return 0;
	}
	public int addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		if(this.getQtyOrdered() + 2 > this.MAX_NUMBER_ORDERED) {
			System.out.println("You cannot buy more DVD!");
			return -1;
		}
		else {
			this.itemsOrdered.add(dvd1);
			this.itemsOrdered.add(dvd2);
			System.out.printf("Added %s to cart\n", dvd1.title());
			System.out.printf("Added %s to cart\n", dvd2.title());
			this.setQtyOrdered(this.itemsOrdered.size());
		}
		return 0;
	}

	/**
	 * Remove DVD(s) in the cart that have attributes 
	 * matching to attributes of disc with case-insensitive.
	 * @param disc element to be removed from cart
	 * @return 0 if successful, -1 if failed
	 */
	public int removeDigitalVideoDisc(DigitalVideoDisc disc) {
		if(this.getQtyOrdered() <= 0) {
			System.out.println("Your order is empty!");
			return -1;
		}
		else {
			Iterator<DigitalVideoDisc> iter = this.itemsOrdered.iterator();
			
			int countRemoved = 0;
			while(iter.hasNext()) {
				DigitalVideoDisc elem = iter.next();
				if(elem.compare(disc) == 0) {
					System.out.println("Remove ID" + elem.ID());
					iter.remove();
					countRemoved += 1;
				}
			}
			if(countRemoved == 0) {
				System.out.println(disc.title() + ": not found");
				return -1;
			}

			this.setQtyOrdered(this.itemsOrdered.size());
		}
		return 0;
	}
	
	public float totalCost() {	
		float cost = 0;
		for(DigitalVideoDisc item : itemsOrdered) {
			cost += item.cost();
		}
		return cost;
	}
	
	/**
	 * 
	 * @param ID ID of the DVD to be searched
	 * @return a DigitalVideoDisc object if found, null otherwise
	 */
	public DigitalVideoDisc searchByID(int ID) {
		for(DigitalVideoDisc dvd : this.itemsOrdered) {
			if(dvd.ID() == ID) {
				return dvd;
			}
		}
		return null;
	}

	/**
	 * Search for the first DigitalVideoDisc object that at least one token of title
	 * is a substring of disc.title.
	 * @param title title wanted to search, can contains many tokens separated by whitespace.
	 * @return the an array DigitalVideoDisc objects that match the condition.
	 */
	public DigitalVideoDisc[] searchByTitle(String title) {
		DigitalVideoDisc[] ret = new DigitalVideoDisc[MAX_NUMBER_ORDERED];
		int found = 0;
		for(DigitalVideoDisc dvd : this.itemsOrdered) {
			if(dvd.search(title)) {
				ret[found++] = dvd;
			}
		}
		return Arrays.copyOf(ret, found);
	}
	
	public void sortByCostAscending() {
		// using lambda expression
		this.itemsOrdered.sort(new Comparator<DigitalVideoDisc> () {
			public int compare(DigitalVideoDisc disc1, DigitalVideoDisc disc2) {
				int compareByCost = DVDUtils.compareByCost(disc1, disc2);
				if(compareByCost == 0) {
					return DVDUtils.compareByTitle(disc1, disc2);
				}
				else {
					return compareByCost;
				}
			}
		});
	}
	
	public void sortByCostDescending() {
		// using lambda expression
		this.itemsOrdered.sort(new Comparator<DigitalVideoDisc> () {
			public int compare(DigitalVideoDisc disc1, DigitalVideoDisc disc2) {
				int compareByCost = -DVDUtils.compareByCost(disc1, disc2);
				if(compareByCost == 0) {
					return DVDUtils.compareByTitle(disc1, disc2);
				}
				else {
					return compareByCost;
				}
			}
		});
	}

	public void sortByTitle() {
		this.itemsOrdered.sort(new Comparator<DigitalVideoDisc> () {
			public int compare(DigitalVideoDisc disc1, DigitalVideoDisc disc2) {
				int compareByTitle = DVDUtils.compareByTitle(disc1, disc2);
				if(compareByTitle == 0) {
					return -DVDUtils.compareByCost(disc1, disc2);
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
		Comparator<DigitalVideoDisc> DVDComparator = new Comparator<DigitalVideoDisc>() {
			@Override
			public int compare(DigitalVideoDisc disc1, DigitalVideoDisc disc2) {
				int compareByTitle = DVDUtils.compareByTitle(disc1, disc2);
				if(compareByTitle == 0) {
					int compareByCost = DVDUtils.compareByCost(disc1, disc2);
					if(compareByCost == 0) {
						return disc2.length() - disc1.length();
					}
					return -compareByCost;
				}
				return compareByTitle;
			}
		};
		@SuppressWarnings("unchecked")
		ArrayList<DigitalVideoDisc> allDiscs = (ArrayList<DigitalVideoDisc>) itemsOrdered.clone();
		Collections.sort(allDiscs, DVDComparator);
		
		System.out.println("*********CART*********");
		System.out.println("Ordered Items:");
		for(int i = 0; i < allDiscs.size(); i++) {
			System.out.print((i + 1) + ". ");
			allDiscs.get(i).displayDetail();
			System.out.println();
		}	
		System.out.println("Total cost: " + this.totalCost());
		System.out.println("******************");
	}
	
	public void clear() {
		this.itemsOrdered.clear();
		this.setQtyOrdered(0);
	}
	
	public void printAllDVD() {
		// for debugging
		for(DigitalVideoDisc disc : this.itemsOrdered) {
			disc.displayDetail();
			System.out.println();
		}
	}
}
