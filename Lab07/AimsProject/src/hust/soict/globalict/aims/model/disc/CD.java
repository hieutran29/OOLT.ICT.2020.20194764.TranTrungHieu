package hust.soict.globalict.aims.model.disc;

import java.util.ArrayList;

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

    public int length() {
        int totalLength = 0;
        for(Track t : tracks) {
            totalLength += t.length();
        }
        return totalLength;
    }

    public boolean exists(Track track) {
        for(Track t : this.tracks) {
            if(t.equals(track)) {
                return true;
            }
        }
        return false;
    }

    public int addTrack(Track track) {
        if(track == null) {
            System.out.println("ERROR: Track is NULL");
            return -1;
        }

        if(!exists(track)) {
            this.tracks.add(track);
            return 0;
        }
        System.out.println("Track is already existed");
        return -1;
    }

    public int removeTrack(Track track) {
        if(track == null) {
            System.out.println("ERROR: Track is NULL");
            return -1;
        }

        if(this.tracks.size() <= 0) {
            System.out.println("CD is empty");
            return -1;
        }

        if(exists(track)) {
            this.tracks.remove(track);
            return 0;
        }
        System.out.println("Track is not existed");
        return -1;
    }

    @Override
    public String getDetail() {
        StringBuffer ret = new StringBuffer("[ID = " + this.ID()  + "]" + " " +
                                            "[Title = " + this.title()    + "]" + " " + 
                                            "[Category = " + this.category() + "]" + " " +
                                            "[Director = " + this.director() + "]" + " " +
                                            "[Artist = " + this.artist()   + "]" + " " +
                                            "[Length = " + this.length()   + "]" + " " +
                                            "[Cost = " + this.cost()     + "$]" + " ");
        for(Track t : tracks) {
            ret.append("\n\tTrack: " + t.title() + ", Length: " + t.length());
        }
        return ret.toString();
    }

    @Override
    public void play() {
        System.out.println("Playing CD: " + this.title());
        for(Track t : tracks) {
            t.play();
        }
    }

	@Override
	public CD clone() {
		int oldNumberMedias = Media.numberMedias;

        CD cd = new CD(this.title(), this.category(), this.director(), this.artist(), 
                         this.tracks, this.cost());

		cd.id = this.id;
		cd.dateAdded = this.dateAdded;
		cd.free = this.free;

		Media.numberMedias = oldNumberMedias;

		return cd;
	}
}
