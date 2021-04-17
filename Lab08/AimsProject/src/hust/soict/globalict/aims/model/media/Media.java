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

    public abstract Media clone();

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Media) {
            Media media = (Media) obj;
            if(media.id == this.id) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int compareTo(Media o) {
        int compareByTitle = MediaUtils.compareByTitle(this, o);
        if(compareByTitle == 0) {
            int compareByCost = MediaUtils.compareByCost(this, o);
            return -compareByCost;
        }
        return compareByTitle;
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

	public abstract String getDetail();
}
