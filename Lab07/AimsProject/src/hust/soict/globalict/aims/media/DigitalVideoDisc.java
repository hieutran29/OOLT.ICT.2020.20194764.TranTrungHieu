package hust.soict.globalict.aims.media;
/**
 * @author HieuTran
 */


public class DigitalVideoDisc extends Disc implements Playable {
	
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
	
	public DigitalVideoDisc clone() {
		int oldNumberMedias = Media.numberMedias;
		DigitalVideoDisc disc = new DigitalVideoDisc(this.title(), this.category(), 
										this.director(), this.length(), this.cost());

		disc.id = this.id;
		disc.dateAdded = this.dateAdded;
		disc.free = this.free;

		Media.numberMedias = oldNumberMedias;
		return disc;
	}

	@Override
	public void play() {
		if(this.length() <= 0) {
			System.out.printf("DVD %s cannot be played!! Length <= 0", this.title());
		}
		else {
			System.out.printf("[Play DVD: %s, Length: %d]\n", this.title(), this.length());
		}
	}
}
