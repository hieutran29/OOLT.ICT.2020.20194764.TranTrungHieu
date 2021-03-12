import javax.swing.JOptionPane;

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
	public DigitalVideoDisc(String title, String category, String director, String length, String cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = (length.length() == 0 ? 0 : Integer.parseInt(length));
		this.cost = (cost.length() == 0 ? 0 : Float.parseFloat(cost));
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
			JOptionPane.showMessageDialog(null, "This DVD has length 0", 
										  null, JOptionPane.ERROR_MESSAGE);	
		}
		else {
			String message = "Title: " + this.getTitle() + "\n" +
					 		 "Length: " + this.getLength();
			JOptionPane.showMessageDialog(null, message, "Play DVD", 
										  JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public void displayDetail(String titleMessage) {
		String message = "Title: " + this.getTitle() + "\n" +
						 "Category: " + this.getCategory() + "\n" +
						 "Director: " + this.getDirector() + "\n" +
						 "Length: " + this.getLength() + "\n" +
						 "Cost: " + this.getCost();
		JOptionPane.showMessageDialog(null, message, titleMessage, 
										JOptionPane.INFORMATION_MESSAGE);
	}
}
