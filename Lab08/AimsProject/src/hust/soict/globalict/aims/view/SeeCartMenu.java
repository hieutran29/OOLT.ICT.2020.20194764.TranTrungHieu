package hust.soict.globalict.aims.view;

public class SeeCartMenu {
    public static void menu() {
        System.out.println("--------------------------------");
        System.out.println("See Current Cart: ");
        System.out.println("\t1. Filter by ID in cart");
        System.out.println("\t2. Filter by title in cart");
        System.out.println("\t3. Sort by cost in cart");
        System.out.println("\t4. Sort by title in cart");
        System.out.println("\t5. Remove Media from cart");
        System.out.println("\t6. Get a lucky item from cart");
        System.out.println("\t7. Place order");
        System.out.println("\t0. Exit");
        System.out.println("--------------------------------");
    }

    public static int maxChoice() {
		return 5;
	}
}
