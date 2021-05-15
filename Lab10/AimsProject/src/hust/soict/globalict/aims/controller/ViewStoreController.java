package hust.soict.globalict.aims.controller;

import java.awt.Container;

import javax.swing.JOptionPane;

import hust.soict.globalict.aims.model.disc.Disc;
import hust.soict.globalict.aims.model.media.Media;
import hust.soict.globalict.aims.model.store.Store;
import hust.soict.globalict.aims.view.ErrorMessage;
import hust.soict.globalict.aims.view.Message;

public class ViewStoreController extends Controller {
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
        if(result == 0) {
        	Message.displayMessage("Adding media to cart", Message.MESSAGE_PLAIN);
        }
        else {
        	ErrorMessage.displayError(result);
        }
    }

    public void play(Media media) {
        if(media instanceof Disc) {
        	Disc disc = (Disc) media;
        	disc.play();
        }
        else {
        	ErrorMessage.displayError(ErrorMessage.PLAY_NON_DISC);
        }
    }
    
    public void searchByID(int ID) {
    	Media result = store.searchByID(ID);
    	if(result != null) {
    		 JOptionPane.showMessageDialog(null, result.toString());
    	}
    	else {
    		ErrorMessage.displayError(ErrorMessage.NOT_FOUND);
    	}
    }
}
