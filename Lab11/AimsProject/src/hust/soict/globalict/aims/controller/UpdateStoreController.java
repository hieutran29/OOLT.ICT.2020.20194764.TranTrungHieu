package hust.soict.globalict.aims.controller;

import hust.soict.globalict.aims.model.media.Media;
import hust.soict.globalict.aims.view.ErrorMessage;
import hust.soict.globalict.aims.view.Message;

public class UpdateStoreController extends Controller {
    
    public void addMediaToStore(Media media) {
    	try {
    		store.addMedia(media);
    		Message.displayMessage("Added media to store successfully", Message.MESSAGE_INFORMATION);
    	} catch(Exception e) {
    		ErrorMessage.displayError(e.getMessage());
    	}
    }
}
