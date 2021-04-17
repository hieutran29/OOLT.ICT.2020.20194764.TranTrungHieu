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
	
	public String director() {
		return this.director;
	}
	public int length() {
		return this.length;
	}

	public int equals(Disc disc) {
		if(disc == null) {
			System.out.println("ERROR: Cannot compare to NULL objects");
			return -1;
		}

		if( this.title().equalsIgnoreCase(disc.title()) &&
			this.category().equalsIgnoreCase(disc.category()) &&
			this.length() == disc.length() &&
            this.director().equalsIgnoreCase(disc.director()) &&
			this.cost() == disc.cost()) {

			return 0;
        }
		return -1;
	}

    @Override
    public String toString() {
        return  "[ID = " + this.ID()  + "]" + " " +
				"[Title = " + this.title()    + "]" + " " + 
				"[Category = " + this.category() + "]" + " " +
				"[Director = " + this.director() + "]" + " " +
				"[Length = " + this.length()   + "]" + " " +
				"[Cost = " + this.cost()     + "$]" + " ";
    }

    public abstract Disc clone();

	public abstract void play();
    
}
