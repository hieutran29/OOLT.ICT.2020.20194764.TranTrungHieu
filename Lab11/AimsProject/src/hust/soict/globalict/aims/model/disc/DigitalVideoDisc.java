package hust.soict.globalict.aims.model.disc;

import hust.soict.globalict.aims.exception.PlayerException;
import hust.soict.globalict.aims.model.media.Media;
import hust.soict.globalict.aims.view.Message;

/**
 * @author HieuTran
 */


public class DigitalVideoDisc extends Disc {
	
	public DigitalVideoDisc() {
		super();
	}
	
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super(title, category, director, length, cost);
	}
	
	public DigitalVideoDisc(String title) {
		super(title);
	}
	
	public DigitalVideoDisc(String title, String category, float cost) {
		super(title, category, cost);
	}
	
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super(title, category, director, cost);
	}

	@Override
	public void play() throws PlayerException {
		if(this.getLength() <= 0) {
			throw new PlayerException("ERROR: DVD length is non-positive!");
		}
		else {
			String message = "DVD: " + this.getTitle() + ", Length: " + this.getLength();
			Message.displayMessage(message, Message.MESSAGE_INFORMATION);
		}
	}

	@Override
	public DigitalVideoDisc clone() {
		int oldNumberMedias = Media.numberMedias;

        DigitalVideoDisc disc = new DigitalVideoDisc(this.getTitle(), this.getCategory(), this.getDirector(), 
													 this.getLength(), this.getCost());

		disc.id = this.id;
		disc.dateAdded = this.dateAdded;
		disc.free = this.free;

		Media.numberMedias = oldNumberMedias;

		return disc;
	}
}
