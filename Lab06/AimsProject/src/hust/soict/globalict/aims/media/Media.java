package hust.soict.globalict.aims.media;

import java.time.LocalDate;


public class Media {
    protected int id = 0;
    protected String title = "";
    protected String category = "";
    protected float cost = 0.0f;
    protected LocalDate dateAdded;
    protected boolean free = false;
    public static int numberMedias = 0;

    public Media() {
        super();
        this.dateAdded = LocalDate.now();
        this.id = ++Media.numberMedias;
    }

    public Media(String title) {
        this.title = title;
        this.dateAdded = LocalDate.now();
        this.id = ++Media.numberMedias;
    }

    public Media(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
        this.dateAdded = LocalDate.now();
        this.id = ++Media.numberMedias;
    }

    public int ID() {
        return this.id;
    }

    public String title() {
        return this.title;
    }

    public String category() {
        return this.category;
    }

    public float cost() {
        return this.cost;
    }

    public boolean isFree() {
        return this.free;
    }

    public void setFree(boolean bool) {
        this.free = bool;
        if(bool == true) {
            cost = 0;
        }
    }

    public Media clone() {
		int oldNumberMedias = Media.numberMedias;
        Media media = new Media(this.title(), this.category(), this.cost());
        
        media.id = this.id;
        media.dateAdded = this.dateAdded;
        media.free = this.free;
        
        Media.numberMedias = oldNumberMedias;
        return media;
    }

    public int equals(Media media) {
        if(media == null) {
            System.out.println("ERROR: Cannot compare to NULL object");
            return -1;
        }

		if(title().compareToIgnoreCase(media.title()) == 0 &&
			category().compareToIgnoreCase(media.category()) == 0 &&
			cost() == media.cost()) {
			return 0;
		}
		return -1;
	}

	public boolean search(String title) {
		String[] wordsInSearchedTitle = title.split("\\W+");
		String[] wordsInDiscTitle = title().split("\\W+");
		for(String origin : wordsInDiscTitle) {
			for(String searched : wordsInSearchedTitle)
				if(origin.equalsIgnoreCase(searched) == true) {
					return true;
				}
		}
		return false;
	}

	public void displayDetail() {
		System.out.printf("Media - ID = %d - %s - %s - %.2f$ %s", this.ID(), this.title(), 
                            this.category(), this.cost(), (this.isFree() ? "- free" : ""));
	}
}
