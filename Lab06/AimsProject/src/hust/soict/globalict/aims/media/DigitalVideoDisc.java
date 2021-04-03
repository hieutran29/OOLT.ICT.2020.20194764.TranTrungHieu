package hust.soict.globalict.aims.media;
/**
 * @author HieuTran
 */

import java.util.Scanner;


public class DigitalVideoDisc extends Media {
	private String director = "";
	private int length = 0;
	
	public DigitalVideoDisc() {
		super();
	}
	
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super(title, category, cost);
		this.length = length;
		this.director = director;
	}
	
	public DigitalVideoDisc(String title) {
		super(title);
	}
	
	public DigitalVideoDisc(String title, String category, float cost) {
		super(title, category, cost);
	}
	
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super(title, category, cost);
		this.director = director;
	}
	
	public String director() {
		return this.director;
	}
	public int length() {
		return this.length;
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

		scanner.close();
		
		return new DigitalVideoDisc(title, category, director, length, cost);
	}
	
	public void playDVD() {
		String message = "";
		if(this.length() == 0) {
			message = "This DVD has length 0";
		}
		else {
			message = "Title: " + this.title() + "\n" +
					 		 "Length: " + this.length();
		}
		System.out.println(message);
	}
	
	public void displayDetail() {
		System.out.printf("DVD - ID = %d - %s - %s - %s - %d - %.2f$", this.ID(), this.title(), this.category(),
											this.director(), this.length(), this.cost());
	}
	
	public int equals(DigitalVideoDisc disc) {
		if(super.equals(disc) == 0) {
			if(disc.length() == this.length() && disc.director() == this.director()) {
				return 0;
			}
		}
		return -1;
	}
	

}
