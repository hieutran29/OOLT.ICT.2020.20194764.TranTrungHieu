package hust.soict.globalict.aims.model.disc;

import hust.soict.globalict.aims.view.Message;

public class Track implements Playable, Comparable<Track> {
    private String title = "";
    private int length = 0;

    public Track() {
        super();
    }

    public Track(String title) {
        this.title = title;
    }

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String title() {
        return this.title;
    }

    public int length() {
        return this.length;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Track) {
            Track track = (Track) obj;
            if(track.title.equals(this.title) &&
                track.length == this.length) {
                    return true;
                }
        }
        return false;
    }

    @Override
    public void play() {
        if(this.length() <= 0) {
			Message.displayMessage("Track " + this.title() + " cannot be played!! Length <= 0\n", Message.MESSAGE_ERROR);
		}
		else {
			Message.displayMessage("\t[Play Track: " + this.title() + ", Length: " + this.length() +"]", Message.MESSAGE_PLAIN);
		}
    }

    @Override
    public int compareTo(Track o) {
        int compareByTitle = this.title.compareToIgnoreCase(o.title);
        if(compareByTitle == 0) {
            return o.length - this.length; 
        }
        return 0;
    }
}
