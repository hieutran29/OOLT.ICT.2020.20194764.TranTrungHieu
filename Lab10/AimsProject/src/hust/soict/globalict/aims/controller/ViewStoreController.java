package hust.soict.globalict.aims.controller;

import java.awt.Container;

import javax.swing.JDialog;

import hust.soict.globalict.aims.data.CartDB;
import hust.soict.globalict.aims.model.cart.Cart;
import hust.soict.globalict.aims.model.disc.Disc;
import hust.soict.globalict.aims.model.media.Media;
import hust.soict.globalict.aims.model.store.Store;
import hust.soict.globalict.aims.view.Message;

public class ViewStoreController extends Controller {
	Container container;
	
	public ViewStoreController(Container container/*, Store store, Cart cart*/) {
		this.container = container;
//		this.store = store;
//		this.cart = cart;
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
     * @param cart	Cart to where DigitalVideoDis is added
     * @param media	Media object that exists in Store
     * @return 0 if successful, -1 otherwise 
     */
    public void addMediaFromStoreToCart(Media media) {
        int result = cart.addMedia(media);
        if(result == -1) {
        	Message.displayMessage("Error while adding media to cart", Message.MESSAGE_ERROR);
        }
        else {
        	Message.displayMessage("Adding media to cart successfully", Message.MESSAGE_PLAIN);
        }
    }

    public void play(Media media) {
        if(media instanceof Disc) {
        	Disc disc = (Disc) media;
        	disc.play();
        }
        else {
        	Message.displayMessage("Cannot play a non-disc", Message.MESSAGE_ERROR);
        }
    }
}
