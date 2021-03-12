import java.util.Scanner;


public class Aims {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cart cart = new Cart();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		cart.addDigitalVideoDisc(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		cart.addDigitalVideoDisc(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		cart.addDigitalVideoDisc(dvd3);
		
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 90, 24f);
		cart.addDigitalVideoDisc(dvd4);
		
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 100, 24f);
		cart.addDigitalVideoDisc(dvd5);
		
		System.out.println("Total cost is: " + cart.totalCost());
		
		System.out.println("Display cart: ");
		cart.displayCart();
		
//		System.out.println("Sort ascending by cost: ");
//		cart.sortAscendingByCost();
//		cart.printAllDVD();
		
//		Scanner scanner = new Scanner(System.in);
//		System.out.print("Input the book you want to remove: ");
//		String s = scanner.nextLine();
//		cart.removeDigitalVideoDisc(new DigitalVideoDisc(s));
//		System.out.println("Total cost is: " + cart.totalCost());
//		scanner.close();
		
//		System.out.println("Search found: ");
//		DigitalVideoDisc search = cart.searchAccordingOnType("science fiction", Cart.Search_Option.CATEGORY);
//		if(search == null) {
//			System.out.println("\tnull");
//		}
//		else {
//			search.displayDetail();
//		}
//	}

}
