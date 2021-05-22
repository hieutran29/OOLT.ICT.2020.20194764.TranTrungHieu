package hust.soict.globalict.aims.controller;

import javax.swing.JOptionPane;

import hust.soict.globalict.aims.exception.PlayerException;
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
    	try {
    		cart.addMedia(media);
    		Message.displayMessage("Added media to cart successfully", Message.MESSAGE_INFORMATION);
    	} catch(Exception e) {
    		ErrorMessage.displayError(e.getMessage());
    	}
    }

    public void play(Media media) {
        if(media instanceof Disc) {
        	Disc disc = (Disc) media;
        	try {
        		disc.play();
        	} catch(PlayerException e) {
        		ErrorMessage.displayError(e.getMessage());
        	}
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
