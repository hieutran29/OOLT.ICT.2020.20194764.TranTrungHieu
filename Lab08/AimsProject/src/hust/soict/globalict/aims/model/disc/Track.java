package hust.soict.globalict.aims.model.disc;

public class Track implements Playable {
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
            if(track.title == this.title &&
                track.length == this.length) {
                    return true;
                }
        }
        return false;
    }

    @Override
    public void play() {
        if(this.length() <= 0) {
			System.out.printf("Track %s cannot be played!! Length <= 0", this.title());
		}
		else {
			System.out.printf("[Play Track: %s, Length: %d]\n", this.title(), this.length());
		}
    }
}
