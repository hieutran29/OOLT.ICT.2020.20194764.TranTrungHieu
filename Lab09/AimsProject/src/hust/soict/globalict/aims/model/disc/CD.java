package hust.soict.globalict.aims.model.disc;

import java.util.ArrayList;

import hust.soict.globalict.aims.model.media.Media;
import hust.soict.globalict.aims.view.Message;

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

    public int addTrack(Track track) {
        if(track == null) {
            Message.printMessage("Track is NULL\n", Message.MESSAGE_ERROR);
            return -1;
        }

        if(!tracks.contains(track)) {
            this.tracks.add(track);
            return 0;
        }
        Message.printMessage("Track is already existed\n", Message.MESSAGE_ERROR);
        return -1;
    }

    public int removeTrack(Track track) {
        if(track == null) {
            Message.printMessage("ERROR: Track is NULL\n", Message.MESSAGE_ERROR);
            return -1;
        }

        if(this.tracks.size() <= 0) {
            Message.printMessage("CD is empty\n", Message.MESSAGE_ERROR);
            return -1;
        }

        if(tracks.contains(track)) {
            this.tracks.remove(track);
            return 0;
        }
        Message.printMessage("Track is not existed\n", Message.MESSAGE_ERROR);
        return -1;
    }

    @Override
    public String toString() {
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
        Message.displayMessage("Playing CD: " + this.title(), Message.MESSAGE_PLAIN);
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
