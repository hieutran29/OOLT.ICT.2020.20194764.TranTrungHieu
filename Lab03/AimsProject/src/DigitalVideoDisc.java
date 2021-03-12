/*
 * QUESTION: If you create a constructor method to build a DVD by title,
 * then create a constructor method to build a DVD by category.
 * Does Java allow you to do it?
 * 
 * ANSWER: Yes, definitely. However, both will have their own initialized attributes, 
 * 			and will not share any attribute.
 * For example: 
 * 		a) When we declare a new DVD variable, called DVD1, by using title constructor,
 * 			(DigitalVideoDisc DVD1 = new DigitalVideoDisc("The Lion King")), 
 * 			then all attributes of DVD1 except DVD1.title will have default value.
 * 		b) Similarly, when we declare a new DVD variable through category constructor, 
 * 			then all attributes of that variable except category will have default value.
 * 	-> Each variable has its own variable. There is no way that DVD1 has category of DVD2
 * 		just by using category constructor for DVD2, and vice versa, there is no way that 
 * 		DVD2 has title just by using title constructor for DVD1.
 */



public class DigitalVideoDisc {
	private String title;
	private String category;
	private String director;
	private int length;
	private float cost;
	
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
	}
	public DigitalVideoDisc(String title) {
		super();
		this.title = title;
	}
	public DigitalVideoDisc(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
	}
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.cost = cost;
	}
	
	public String getTitle() {
		return title;
	}
	public String getCategory() {
		return category;
	}
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	public float getCost() {
		return cost;
	}
	
	public void playDVD() {
		if(this.getLength() == 0) {
			System.out.println("The DVD cannot be played");
		}
		else {
			System.out.println("\tTitle: " + this.getTitle());
			System.out.println("\tLength: " + this.getLength());
		}
	}
	
	public void displayDetail() {
		System.out.println("\tTitle: " + this.getTitle());
		System.out.println("\tCategory: " + this.getCategory());
		System.out.println("\tDirector: " + this.getDirector());
		System.out.println("\tLength: " + this.getLength());
		System.out.println("\tCost: " + this.getCost());
	}
}
