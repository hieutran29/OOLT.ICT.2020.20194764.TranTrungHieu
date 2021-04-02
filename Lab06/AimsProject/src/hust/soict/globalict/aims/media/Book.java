package hust.soict.globalict.aims.media;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Book extends Media {
    private List<String> authors = new ArrayList<String>();

    Book() {
        super();
    }

    Book(String title, String category, float cost, String ... authors) {
        super(title, category, cost);
        this.authors.addAll(Arrays.asList(authors));
    }
    
    public List<String> authors() {
        return this.authors;
    }

    public int addAuthor(String authorName) {
        if(authors.contains(authorName)) {
            System.out.println("Author already existed!!");
            return -1;
        }
        this.authors.add(authorName);
        return 0;
    }

    public int removeAuthor(String authorName) {
        if(!authors.contains(authorName)) {
            System.out.println("Author does not exist in list");
            return -1;
        }
        authors.remove(authorName);
        return 0;
    }
}
