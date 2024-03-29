/**
 * @author HieuTran
 */


import java.util.*;

import javax.swing.*;

public class Cart {
	private final int MAX_NUMBER_ORDERED = 20;
	private int qtyOrdered = 0;
	private ArrayList<DigitalVideoDisc> itemsOrdered = new ArrayList<DigitalVideoDisc> ();
	
	public enum Search_Option {
		TITLE, CATEGORY, PRICE;
	};
	
	public Cart() {
		super();
	}
	
	public int getQtyOrdered() {
		return qtyOrdered;
	}

	private void setQtyOrdered(int qtyOrdered) {
		this.qtyOrdered = qtyOrdered;
	}

	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if(this.getQtyOrdered() >= this.MAX_NUMBER_ORDERED) {
			JOptionPane.showMessageDialog(null, "You cannot buy more DVD!", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
		}
		else {
			this.itemsOrdered.add(disc);
			this.setQtyOrdered(this.itemsOrdered.size());
		}
	}

	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		if(this.getQtyOrdered() <= 0) {
			JOptionPane.showMessageDialog(null, "Your order is empty!", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
		}
		else {
			Iterator<DigitalVideoDisc> iter = this.itemsOrdered.iterator();
			
			int countRemoved = 0;
			while(iter.hasNext()) {
				DigitalVideoDisc elem = iter.next();
				if(elem.title().compareToIgnoreCase(disc.title()) == 0 ||
				elem.title().replaceAll("\\s", "").compareToIgnoreCase(disc.title()) == 0) {
					elem.displayDetail("Deleted Message");
					iter.remove();
					countRemoved += 1;
				}
			}
			if(countRemoved == 0) {
				JOptionPane.showMessageDialog(null, disc.title() + ": not found", "NOT FOUND", JOptionPane.ERROR_MESSAGE);
			}

			this.setQtyOrdered(this.itemsOrdered.size());
		}
	}
	
	public float totalCost() {
		float cost = 0;
		for(DigitalVideoDisc item : itemsOrdered) {
			cost += item.cost();
		}
		return cost;
	}
	
	/** Return the first DigitalVideoDisc object that has the same value 
	 * with user-specified value.
	* @param  search  a string that used to find the matching object
	* @param  type	  attribute that we want to search for: Cart.Search_Option.TITLE,
	* 					Cart.Search_Option.CATEGORY, Cart.Search_Option.COST
	* @return      	  the first object that has attribute matching to {@link search}
	*/
	public DigitalVideoDisc searchAccordingOnType(String search, Cart.Search_Option type) {
		if(type == Cart.Search_Option.TITLE) {
			for(DigitalVideoDisc disc : this.itemsOrdered) {
				if(disc.title().equalsIgnoreCase(search)) {
					return disc;
				}
			}
		}
		else if(type == Cart.Search_Option.PRICE) {
			for(DigitalVideoDisc disc : this.itemsOrdered) {
				if(disc.cost() == Float.parseFloat(search)) {
					return disc;
				}
			}
		}
		else if(type == Cart.Search_Option.CATEGORY) {
			for(DigitalVideoDisc disc : this.itemsOrdered) {
				if(disc.category().equalsIgnoreCase(search)) {
					return disc;
				}
			}
		}
		return null;
	}
	
	public void sortAscendingByCost() {
		// using lambda expression
		this.itemsOrdered.sort(new Comparator<DigitalVideoDisc> () {
			public int compare(DigitalVideoDisc disc1, DigitalVideoDisc disc2) {
				if(disc1.cost() == disc2.cost()) {
					return 0;
				}
				else if(disc1.cost() < disc2.cost()) {
					return -1;
				}
				else {
					return 1;
				}
			}
		});
	}

	
	public void displayCart() {
		// comparator function
		Comparator<DigitalVideoDisc> DVDComparator = new Comparator<DigitalVideoDisc>() {
			@Override
			public int compare(DigitalVideoDisc disc1, DigitalVideoDisc disc2) {
				
				if(disc1.title().compareToIgnoreCase(disc2.title()) == 0) {
					if(disc1.cost() == disc2.cost()) {
						if(disc1.length() == disc2.length()) {
							return 0;
						}
						else {
							return disc2.length() - disc1.length();
						}
					}
					else if(disc1.cost() < disc2.cost()) {
						return 1;
					}
					else if(disc1.cost() > disc2.cost()) {
						return -1;
					}
				}
				else {
					return disc1.title().compareToIgnoreCase(disc2.title());
				}
				return 1;
			}
		};
		@SuppressWarnings("unchecked")
		ArrayList<DigitalVideoDisc> allDiscs = (ArrayList<DigitalVideoDisc>) itemsOrdered.clone();
		Collections.sort(allDiscs, DVDComparator);
		for(DigitalVideoDisc disc : allDiscs) {
			disc.displayDetail("Display Cart");
		}	
	}
	
	public void printAllDVD() {
		// for debugging
		for(DigitalVideoDisc disc : this.itemsOrdered) {
			disc.displayDetail("Display Cart");
		}
	}
}
