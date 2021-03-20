package LibPackage;
/**
 * @author HieuTran
 */


/**
 * Pleas note that, in this class, I removed all "get" prefix for "getter" methods.
 * In aspect of real world and of a real creature, a DVD cannot itself 
 * "get" any attribute and give to us. We are not "getting" anything from a DVD. 
 * All we do is asking a DVD to tell us its attribute.
 */



import java.time.LocalDate;

import javax.swing.JOptionPane;


public class DigitalVideoDisc {
	private int id;
	private String title;
	private String category;
	private String director;
	private int length;
	private float cost;
	private LocalDate dateAdded;
	private static int numberDVDs = 0;
	
	public DigitalVideoDisc() {
		super();
	}
	
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
		this.dateAdded = LocalDate.now();
		id = ++DigitalVideoDisc.numberDVDs;
	}
	
	public DigitalVideoDisc(String title) {
		super();
		this.title = title;
		this.dateAdded = LocalDate.now();
		id = ++DigitalVideoDisc.numberDVDs;
	}
	
	public DigitalVideoDisc(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
		this.dateAdded = LocalDate.now();
		id = ++DigitalVideoDisc.numberDVDs;
	}
	
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.cost = cost;
		this.dateAdded = LocalDate.now();
		id = ++DigitalVideoDisc.numberDVDs;
	}
	public int ID() {
		return id;
	}
	public String title() {
		return title;
	}
	public String category() {
		return category;
	}
	public String director() {
		return director;
	}
	public int length() {
		return length;
	}
	public float cost() {
		return cost;
	}
	
	public void playDVD() {
		if(this.length() == 0) {
			JOptionPane.showMessageDialog(null, "This DVD has length 0", 
										  null, JOptionPane.ERROR_MESSAGE);	
		}
		else {
			String message = "Title: " + this.title() + "\n" +
					 		 "Length: " + this.length();
			JOptionPane.showMessageDialog(null, message, "Play DVD", 
										  JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public void displayDetail() {
		System.out.printf("DVD - %s - %s - %s - %d - %.2f$", this.title(), this.category(),
											this.director(), this.length(), this.cost());
	}

	/* just for Lab 04 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setDVD(DigitalVideoDisc dvd) {
		this.title = dvd.title();
		this.category = dvd.category();
		this.director = dvd.director();
		this.length = dvd.length();
		this.cost = dvd.cost();
	}
}
