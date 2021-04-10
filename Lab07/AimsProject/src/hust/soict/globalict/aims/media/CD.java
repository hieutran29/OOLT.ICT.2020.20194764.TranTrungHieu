package hust.soict.globalict.aims.media;

import java.util.ArrayList;

public class CD extends Disc implements Playable {
    private String artist = "";
    private ArrayList<Track> tracks = new ArrayList<Track>();

    public CD() {
        super();
    }

    public CD(String artist) {
        this.artist = artist;
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
    public void play() {
        System.out.println("Playing CD: " + this.title());
        for(Track t : tracks) {
            t.play();
        }
    }
}
