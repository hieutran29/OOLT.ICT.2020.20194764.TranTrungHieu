package hust.soict.globalict.aims.media;

public class Track {
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
}
