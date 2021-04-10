package hust.soict.globalict.aims.view;

import hust.soict.globalict.aims.model.cart.Cart;
import hust.soict.globalict.aims.model.disc.Disc;
import hust.soict.globalict.aims.model.media.Media;
import hust.soict.globalict.aims.model.store.Store;

public class ViewStoreMenu {
    public static void menu() {
        System.out.println("View Store: ");
        System.out.println("--------------------------------");
        System.out.println("\t1. See a Media detail");
        System.out.println("\t2. Add a Media to cart");
        System.out.println("\t3. See current cart");
        System.out.println("\t4. Play a Media");
        System.out.println("\t0. Exit");
        System.out.println("--------------------------------");
    }
    
    /**
     * See a Media object's detail
     * @param store	Store where the object is located
     * @param ID	ID of the object
     * @return	Media object that has ID matched to ID
     */
    public static Media seeMedia(Store store, int ID) {
        return store.searchByID(ID);
    }
    
    /**
     * Add a Media from Store to Cart 
     * @param store Store which contains Media available to be added
     * @param cart	Cart to where DigitalVideoDis is added
     * @param media	Media object that exists in Store
     * @return 0 if successful, -1 otherwise 
     */
    public static int addMediaFromStoreToCart(Store store, Cart cart, Media media) {
        if(!store.exists(media)) {
            System.out.println("CANNOT ADD A NON-EXIST Media IN STORE TO A CART");
            return -1;
        }
        return cart.addMedia(media);
    }

    public static void play(Store store, int ID) {
        Media media = store.searchByID(ID);
        if(media == null) {
            System.out.println("NO MATCHING ID FOUND");
            return;
        }

        String className = media.getClass().getSimpleName();
        if(className.equals("Book")) {
            System.out.println("Cannot play a book");
            return;
        }
        else {
            Disc disc = (Disc) media;
            disc.play();
        }
    }
}
