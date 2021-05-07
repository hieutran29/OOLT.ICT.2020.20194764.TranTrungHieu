package hust.soict.globalict.aims.controller;

import hust.soict.globalict.aims.model.cart.Cart;
import hust.soict.globalict.aims.model.disc.Disc;
import hust.soict.globalict.aims.model.media.Media;
import hust.soict.globalict.aims.model.store.Store;
import hust.soict.globalict.aims.view.Message;
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
            Message.printMessage("\n", Message.MESSAGE_PLAIN);
            menu();

            System.out.print("Enter choice: ");
            choice = scanner.nextInt();

            if(choice == 1) {
                Message.printMessage("Enter ID of Media to see: ", Message.MESSAGE_QUESTION);
				int ID = scanner.nextInt();
				
				Message.printMessage("-----------\n", Message.MESSAGE_PLAIN);
				Media media = seeMedia(storeDB.store, ID);
				if(media != null) {
					Message.printMessage(media.toString(), Message.MESSAGE_PLAIN);
				}
				Message.printMessage("\n-----------\n", Message.MESSAGE_PLAIN);
				
				if(media != null) {
					int AddOrNot = 0;
					Message.printMessage("1. Add this Media to Cart, or\n", Message.MESSAGE_PLAIN);
					Message.printMessage("0. Do nothing, exit\n", Message.MESSAGE_PLAIN);
				    Message.printMessage("Choose: ", Message.MESSAGE_PLAIN);
					AddOrNot = scanner.nextInt();
					if(AddOrNot == 1) {
						addMediaFromStoreToCart(storeDB.store, cartDB.cart, media);
					}
				}
            }
            else if(choice == 2) {
				Message.printMessage("Enter ID: ", Message.MESSAGE_QUESTION);
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
				Message.printMessage("Enter ID to play: ", Message.MESSAGE_QUESTION);
				int ID = scanner.nextInt();
				scanner.nextLine();
				play(storeDB.store, ID);
            }
        } while(choice != 0);
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
        if(!store.contains(media)) {
            Message.printMessage("Media not existed in store", Message.MESSAGE_ERROR);
            return -1;
        }
        return cart.addMedia(media);
    }

    private void play(Store store, int ID) {
        Media media = store.searchByID(ID);
        if(media == null) {
            Message.printMessage("NO MATCHING ID FOUND", Message.MESSAGE_ERROR);
            return;
        }

        String className = media.getClass().getSimpleName();
        if(className.equals("Book")) {
            Message.printMessage("Cannot play a book", Message.MESSAGE_ERROR);
            return;
        }
        else {
            Disc disc = (Disc) media;
            disc.play();
        }
    }
}
