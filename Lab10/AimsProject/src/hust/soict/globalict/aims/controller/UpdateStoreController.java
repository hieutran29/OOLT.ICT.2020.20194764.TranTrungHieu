package hust.soict.globalict.aims.controller;

import hust.soict.globalict.aims.model.media.Media;
import hust.soict.globalict.aims.view.ErrorMessage;
import hust.soict.globalict.aims.view.Message;

public class UpdateStoreController extends Controller {
    
    public void addMediaToStore(Media media) {
    	int result = store.addMedia(media);
    	if(result == 0) {
    		Message.displayMessage("Add item to store", Message.MESSAGE_PLAIN);
    	}
    	else {
    		ErrorMessage.displayError(result);
    	}
    }
}
