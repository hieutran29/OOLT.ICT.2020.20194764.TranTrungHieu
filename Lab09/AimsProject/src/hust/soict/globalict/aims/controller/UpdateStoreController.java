package hust.soict.globalict.aims.controller;

import hust.soict.globalict.aims.model.media.Media;

public class UpdateStoreController extends Controller {
    
    public void addMediaToStore(Media media) {
    	store.addMedia(media);
    }
}
