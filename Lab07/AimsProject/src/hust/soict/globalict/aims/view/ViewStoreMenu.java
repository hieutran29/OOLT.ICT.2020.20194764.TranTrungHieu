package hust.soict.globalict.aims.view;

public class ViewStoreMenu {
    public static void menu() {
        System.out.println("--------------------------------");
        System.out.println("View Store: ");
        System.out.println("\t1. See a Media detail");
        System.out.println("\t2. Add a Media to cart");
        System.out.println("\t3. See current cart");
        System.out.println("\t4. Play a Media");
        System.out.println("\t0. Exit");
        System.out.println("--------------------------------");
    }

    public static int maxChoice() {
        return 4;
    }
}
