package hust.soict.globalict.aims.media;
/**
 * @author HieuTran
 */


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
		System.out.printf("DVD - ID = %d - %s - %s - %s - %d - %.2f$ %s", this.ID(), this.title(), this.category(),
								this.director(), this.length(), this.cost(), (this.isFree() ? "- free" : ""));
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
