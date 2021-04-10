package hust.soict.globalict.aims.media;

public class Disc extends Media {
	private String director = "";
	private int length = 0;

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

    public Disc clone() {
		int oldNumberMedias = Media.numberMedias;

        Disc disc = new Disc(this.title(), this.category(), this.director(), 
						this.length(), this.cost());

		disc.id = this.id;
		disc.dateAdded = this.dateAdded;
		disc.free = this.free;

		Media.numberMedias = oldNumberMedias;

		return disc;
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
    public String getDetail() {
        return  "[ID = " + this.ID()  + "]" + " " +
				"[" + this.title()    + "]" + " " + 
				"[" + this.category() + "]" + " " +
				"[" + this.director() + "]" + " " +
				"[" + this.length()   + "]" + " " +
				"[" + this.cost()     + "$]" + " ";
    }
    
}