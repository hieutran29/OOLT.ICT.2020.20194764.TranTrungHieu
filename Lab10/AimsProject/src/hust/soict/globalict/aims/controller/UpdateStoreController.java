package hust.soict.globalict.aims.controller;

import hust.soict.globalict.aims.model.media.Media;

public class UpdateStoreController extends Controller {
    
    public int addMediaToStore(Media media) {
    	return store.addMedia(media);
    }
}
