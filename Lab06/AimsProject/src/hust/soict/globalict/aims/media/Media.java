package hust.soict.globalict.aims.media;

import java.time.LocalDate;


public class Media {
    private int id = 0;
    private String title = "";
    private String category = "";
    private float cost = 0.0f;
    private LocalDate dateAdded;
    private static int numberMedias = 0;

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


    public int equals(Media media) {
		if(title().compareToIgnoreCase(media.title()) == 0 &&
			category().compareToIgnoreCase(media.category()) == 0 &&
			cost() == media.cost()) {
			return 0;
		}
		return -1;
	}

	public boolean search(String title) {
		String[] wordsInSearchedTitle = title.split("\\s");
		String[] wordsInDiscTitle = title().split("\\s");
		for(String origin : wordsInDiscTitle) {
			for(String searched : wordsInSearchedTitle)
				if(origin.equalsIgnoreCase(searched) == true) {
					return true;
				}
		}
		return false;
	}

	public void displayDetail() {
		System.out.printf("DVD - ID = %d - %s - %s - %.2f$", this.ID(), this.title(), 
                            this.category(), this.cost());
	}
}
