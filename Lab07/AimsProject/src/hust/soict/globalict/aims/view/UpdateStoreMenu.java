package hust.soict.globalict.aims.view;

import hust.soict.globalict.aims.model.media.Media;
import hust.soict.globalict.aims.model.store.Store;

public class UpdateStoreMenu {
    public static void menu() {
        System.out.println("--------------------------------");
        System.out.println("Update Store:");
        System.out.println("\t1. Add Media to store");
        System.out.println("\t2. Remove Media from store");
        System.out.println("\t0. Exit");
        System.out.println("--------------------------------");
    }
    
    public static int maxChoice() {
		return 3;
	}
}
