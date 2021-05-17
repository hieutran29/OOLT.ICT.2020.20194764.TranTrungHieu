package hust.soict.globalict.aims.model.disc;

import hust.soict.globalict.aims.model.media.Media;

public abstract class Disc extends Media implements Playable {
	protected String director = "";
	protected int length = 0;

    public Disc() {
		super();
	}
	
	public Disc(String title, String category, String director, int length, float cost) {
		super(title, category, cost);
		this.length = length;
		this.director = director;
	}
	
	public Disc(String title) {
		super(title);
	}
	
	public Disc(String title, String category, float cost) {
		super(title, category, cost);
	}
	
	public Disc(String title, String category, String director, float cost) {
		super(title, category, cost);
		this.director = director;
	}
	
	public String getDirector() {
		return this.director;
	}
	public int getLength() {
		return this.length;
	}

    @Override
    public String toString() {
        return  "[ID = " + this.getID()  + "]" + " " +
				"[Title = " + this.getTitle()    + "]" + " " + 
				"[Category = " + this.getCategory() + "]" + " " +
				"[Director = " + this.getDirector() + "]" + " " +
				"[Length = " + this.getLength()   + "]" + " " +
				"[Cost = " + this.getCost()     + "$]" + " ";
    }

    public abstract Disc clone();

	public abstract void play();
    
}
