package hust.soict.globalict.aims.utils;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.Media;

public class SeeCurrentCart {
    public static void menu() {
        System.out.println("See Current Cart: ");
        System.out.println("--------------------------------");
        System.out.println("\t1. Filter Medias in cart");
        System.out.println("\t2. Sort Medias in cart");
        System.out.println("\t3. Remove Media from cart");
        System.out.println("\t4. Get a lucky item from cart");
        System.out.println("\t5. Place order");
        System.out.println("\t0. Exit");
        System.out.println("--------------------------------");
    }
    
    public static void filterMediaByID(Cart cart, int ID) {
        Media found = cart.searchByID(ID);
        System.out.println("\n----------");
        if(found != null) {
            found.getDetail();
        }
        else {
            System.out.println("NO Media MATCHING");
        }
        System.out.println("----------\n");
    }
    
    public static void filterMediaByTitle(Cart cart, String title) {
        Media[] found = cart.searchByTitle(title);
        if(found.length == 0) {
            System.out.println("NO Media MATCHING");
        }
        else {
            for(Media f : found) {
                f.getDetail();
                System.out.println();
            }
        }
    }
    
    public static void sortMediaByCost(Cart cart) {
        cart.sortByCostDescending();
    }
    
    public static void sortMediaByTitle(Cart cart) {
        cart.sortByTitle();
    }
    
    public static int removeMedia(Cart cart, int ID) {
        return cart.removeMedia(ID);
    }

    public static Media getLuckyItem(Cart cart) {
        return cart.getLuckyItem();
    }
    
    public static void placeOrder(Cart cart) {
        System.out.println("An order is created");
        cart.clear();
    }
}
