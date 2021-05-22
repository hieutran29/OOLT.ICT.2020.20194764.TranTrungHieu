package hust.soict.globalict.aims.model.disc;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import hust.soict.globalict.aims.exception.AlreadyExistedException;
import hust.soict.globalict.aims.exception.PlayerException;
import hust.soict.globalict.aims.model.media.Media;

public class CD extends Disc {
    private String artist = "";
    private ArrayList<Track> tracks = new ArrayList<Track>();

    public CD() {
        super();
    }

	public CD(String title, String category, String director, String artist, ArrayList<Track> tracks, float cost) {
		super(title, category, director, cost);
        this.artist = artist;
        this.tracks = tracks;
        this.length = 0;
        for(Track t : tracks) {
            this.length += t.length();
        }
	}

    public CD(String artist, ArrayList<Track> tracks) {
        this.artist = artist;
        this.tracks = tracks;
    }

    public String artist() {
        return this.artist;
    }

    public int getLength() {
        int totalLength = 0;
        for(Track t : tracks) {
            totalLength += t.length();
        }
        return totalLength;
    }

    public void addTrack(Track track) throws AlreadyExistedException {
        if(track == null) {
            throw new NullPointerException("Track is NULL");
        }

        if(tracks.contains(track)) {
            throw new AlreadyExistedException("Track is already existed");
        }
        
        this.tracks.add(track);
    }

    public void removeTrack(Track track) {
        if(track == null) {
            throw new NullPointerException("Track is NULL");
        }

        if(this.tracks.size() <= 0) {
            throw new NoSuchElementException("CD is empty to be removed");
        }

        if(!tracks.contains(track)) {
            throw new NoSuchElementException("Track is not existed");
        }
        this.tracks.remove(track);
    }

    @Override
    public String toString() {
        StringBuffer ret = new StringBuffer("[ID = " + this.getID()  + "]" + " " +
                                            "[Title = " + this.getTitle()    + "]" + " " + 
                                            "[Category = " + this.getCategory() + "]" + " " +
                                            "[Director = " + this.getDirector() + "]" + " " +
                                            "[Artist = " + this.artist()   + "]" + " " +
                                            "[Length = " + this.getLength()   + "]" + " " +
                                            "[Cost = " + this.getCost()     + "$]" + " ");
        for(Track t : tracks) {
            ret.append("\n\tTrack: " + t.title() + ", Length: " + t.length());
        }
        return ret.toString();
    }

    @Override
    public void play() throws PlayerException {
    	if(this.getLength() > 0) {
	        for(Track t : tracks) {
	        	try {
	        		t.play();
	        	} catch(PlayerException e) {
	        		throw e;
	        	}
	        }
    	}
    	else {
    		throw new PlayerException("ERROR: CD length is non-positive!");
    	}
    }

	@Override
	public CD clone() {
		int oldNumberMedias = Media.numberMedias;

        CD cd = new CD(this.getTitle(), this.getCategory(), this.getDirector(), this.artist(), 
                         this.tracks, this.getCost());

		cd.id = this.id;
		cd.dateAdded = this.dateAdded;
		cd.free = this.free;

		Media.numberMedias = oldNumberMedias;

		return cd;
	}
}
