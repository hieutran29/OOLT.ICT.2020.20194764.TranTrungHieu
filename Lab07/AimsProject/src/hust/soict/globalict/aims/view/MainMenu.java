package hust.soict.globalict.aims.view;

public class MainMenu {
    public static void menu() {
		System.out.println("--------------------------------");
        System.out.println("AIMS: ");
		System.out.println("\t1. View store");
		System.out.println("\t2. Update store");
		System.out.println("\t3. See current cart");
		System.out.println("\t0. Exit");
		System.out.println("--------------------------------");
    }

	public static int maxChoice() {
		return 3;
	}
}
