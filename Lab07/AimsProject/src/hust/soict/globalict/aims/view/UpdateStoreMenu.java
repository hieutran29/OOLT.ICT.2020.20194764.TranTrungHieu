package hust.soict.globalict.aims.view;

import hust.soict.globalict.aims.model.media.Media;
import hust.soict.globalict.aims.model.store.Store;

public class UpdateStoreMenu {
    public static void menu() {
        System.out.println("Update Store:");
        System.out.println("--------------------------------");
        System.out.println("\t1. Add Media to store");
        System.out.println("\t2. Remove Media from store");
        System.out.println("\t0. Exit");
        System.out.println("--------------------------------");
    }
    
    /**
     * Add a Media to a Store
     * @param store from where the Media is added
     * @param media	the Media added to Store
     * @return 0 if successful, -1 otherwise
     */
    public static int addMediaToStore(Store store, Media media) {
        return store.addMedia(media);
    }
    
    /**
     * Remove a Media from a Store
     * @param store	from where Media is removed
     * @param ID	ID of a Media removed from store
     * @return 0 if successful, -1 otherwise
     */
    public static int removeMediaFromStore(Store store, int ID) {
        return store.removeMedia(ID);
    }
}
