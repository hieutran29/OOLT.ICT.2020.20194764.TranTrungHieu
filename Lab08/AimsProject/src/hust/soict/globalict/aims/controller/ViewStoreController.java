package hust.soict.globalict.aims.controller;

import hust.soict.globalict.aims.model.cart.Cart;
import hust.soict.globalict.aims.model.disc.Disc;
import hust.soict.globalict.aims.model.media.Media;
import hust.soict.globalict.aims.model.store.Store;
import hust.soict.globalict.aims.view.ViewStoreMenu;

public class ViewStoreController extends Controller {
    @Override
    public void menu() {
        ViewStoreMenu.menu();
    }

    @Override
    public void start() {
        int choice;
        do {
            System.out.println();
            menu();

            System.out.print("Enter choice: ");
            choice = scanner.nextInt();

            if(choice == 1) {
                System.out.print("Enter ID of Media to see: ");
				int ID = scanner.nextInt();
				
				System.out.println("\n-----------");
				Media media = seeMedia(storeDB.store, ID);
				if(media != null) {
					System.out.println(media.toString());
				}
				System.out.println("\n-----------\n");
				
				if(media != null) {
					int AddOrNot = 0;
					System.out.println("1. Add this Media to Cart, or");
					System.out.println("0. Do nothing, exit");
					System.out.print("Choose: ");
					AddOrNot = scanner.nextInt();
					if(AddOrNot == 1) {
						addMediaFromStoreToCart(storeDB.store, cartDB.cart, media);
					}
				}
            }
            else if(choice == 2) {
				System.out.printf("Enter ID: ");
				int ID = scanner.nextInt();

				Media mediaAdd = storeDB.store.searchByID(ID);
				 
				if(mediaAdd != null) {
					addMediaFromStoreToCart(storeDB.store, cartDB.cart, mediaAdd);
				}
            }
            else if(choice == 3) {
                cartDB.cart.displayCart();
            }
            else if(choice == 4) {
				System.out.print("Enter ID to play: ");
				int ID = scanner.nextInt();
				scanner.nextLine();
				play(storeDB.store, ID);
            }
            else if(choice == 0) {
                break;
            }
            else {
                message("ERROR: Choice invalid");
            }

        } while(choice >= 0 && choice <= ViewStoreMenu.maxChoice());
    }

    /**
     * See a Media object's detail
     * @param store	Store where the object is located
     * @param ID	ID of the object
     * @return	Media object that has ID matched to ID
     */
    private Media seeMedia(Store store, int ID) {
        return store.searchByID(ID);
    }
    
    /**
     * Add a Media from Store to Cart 
     * @param store Store which contains Media available to be added
     * @param cart	Cart to where DigitalVideoDis is added
     * @param media	Media object that exists in Store
     * @return 0 if successful, -1 otherwise 
     */
    private int addMediaFromStoreToCart(Store store, Cart cart, Media media) {
        if(!store.exists(media)) {
            System.out.println("CANNOT ADD A NON-EXIST Media IN STORE TO A CART");
            return -1;
        }
        return cart.addMedia(media);
    }

    private void play(Store store, int ID) {
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
