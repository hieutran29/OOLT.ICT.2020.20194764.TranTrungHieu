package hust.soict.globalict.aims.disc;
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
import java.util.Scanner;

import javax.swing.JOptionPane;


public class DigitalVideoDisc {
	private int id = -1;
	private String title = "";
	private String category = "";
	private String director = "";
	private int length = 0;
	private float cost = 0.0f;
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
	
	public static DigitalVideoDisc newDVD() {
		String title = "", category = "", director = "";
		int length = 0;
		float cost = 0.0f;
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter Title: ");
		title = scanner.nextLine();
		
		System.out.print("Enter Category: ");
		category = scanner.nextLine();
		
		System.out.print("Enter Director: ");
		director = scanner.nextLine();
		
		int choice = 0;
		
		do {
			System.out.print("Enter Length: ");
			length = scanner.nextInt();
			if(length < 0) {
				System.out.println("****You cannot input a negative length****");
				System.out.println("1. Reinput, or");
				System.out.println("0. Exit, and Length = 0");
				System.out.println("*****************************************");
				System.out.print("Option: ");
				choice = scanner.nextInt();
				if(choice == 0) {
					length = 0;
				}
			}
			
		} while(choice != 0 || length < 0);
		
		do {
			System.out.print("Enter Cost: ");
			cost = scanner.nextFloat();
			if(cost < 0) {
				System.out.println("****You cannot input a negative cost****");
				System.out.println("1. Reinput, or");
				System.out.println("0. Exit, and Cost = 0");
				System.out.println("*****************************************");
				System.out.print("Option: ");
				choice = scanner.nextInt();
				if(choice == 0) {
					cost = 0f;
				}
			}
		} while(choice != 0 || cost < 0);
		
		return new DigitalVideoDisc(title, category, director, length, cost);
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
		System.out.printf("DVD - ID = %d - %s - %s - %s - %d - %.2f$", this.ID(), this.title(), this.category(),
											this.director(), this.length(), this.cost());
	}
	
	public int compare(DigitalVideoDisc disc) {
		if(title().compareToIgnoreCase(disc.title()) == 0 &&
			category().compareToIgnoreCase(disc.category()) == 0 &&
			director().compareToIgnoreCase(disc.director()) == 0 &&
			length() == disc.length() && 
			cost() == disc.cost()) {
			return 0;
		}
		return -1;
	}
	
	public boolean search(String title) {
		String[] wordsInSearchedTitle = title.split("\\s");
		String[] wordsInDiscTitle = title().split("\\s");
		for(String origin : wordsInDiscTitle) {
			for(String searched : wordsInSearchedTitle)
				if(origin.equalsIgnoreCase(searched) == true) {
					return true;
				}
		}
		return false;
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
