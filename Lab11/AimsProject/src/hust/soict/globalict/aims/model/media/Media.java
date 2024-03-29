package hust.soict.globalict.aims.model.media;

import java.time.LocalDate;
import java.util.Comparator;

import hust.soict.globalict.aims.utils.MediaComparatorByCostTitle;
import hust.soict.globalict.aims.utils.MediaComparatorByTitleCost;
import hust.soict.globalict.aims.utils.MediaUtils;


public abstract class Media implements Comparable<Media> {
    protected int id = 0;
    protected String title = "";
    protected String category = "";
    protected float cost = 0.0f;
    protected LocalDate dateAdded;
    protected boolean free = false;
    public static int numberMedias = 0;

    public static final Comparator<Media> COMPARE_BY_TITLE_COST 
                    = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE
                    = new MediaComparatorByCostTitle();

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

    public int getID() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getCategory() {
        return this.category;
    }

    public float getCost() {
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

    public abstract Media clone();

    @Override
    public boolean equals(Object obj) {
    	try {
    		Media media = (Media) obj;
    		return media.id == this.id;
    	} catch(NullPointerException e) {
    		throw e;
    	} catch(ClassCastException e) {
    		throw new ClassCastException("Cannot cast to Media");
    	}
    }

    @Override
    public int compareTo(Media o) {
    	try {
	        int compareByTitle = MediaUtils.compareByTitle(this, o);
	        if(compareByTitle == 0) {
	            int compareByCost = MediaUtils.compareByCost(this, o);
	            return -compareByCost;
	        }
	        return compareByTitle;
    	} catch(NullPointerException e) {
    		throw e;
    	}
    }

	public boolean search(String title) {
		if(title == null) {
			throw new NullPointerException("Title is null");
		}
		String[] wordsInSearchedTitle = title.split("\\W+");
		String[] wordsInDiscTitle = getTitle().split("\\W+");
		for(String origin : wordsInDiscTitle) {
			for(String searched : wordsInSearchedTitle)
				if(origin.equalsIgnoreCase(searched) == true) {
					return true;
				}
		}
		return false;
	}

    @Override
    public abstract String toString();
}
