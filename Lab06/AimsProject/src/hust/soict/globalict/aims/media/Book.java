package hust.soict.globalict.aims.media;

import java.util.*;
import java.util.List;

public class Book extends Media {
    private List<String> authors = new ArrayList<String>();
    String content = "";

    public Book() {
        super();
    }

    public Book(String title, String category, String content, String[] authors, float cost) {
        super(title, category, cost);
        this.content = content;
        this.authors.addAll(Arrays.asList(authors));
    }

    String content() {
        return this.content;
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

    public void displayDetail() {
        super.displayDetail();
        Map<String, Integer> map = new HashMap<String,Integer> ();
        String[] words = content.split("\\W+");
        for(String w : words) {
            if(!map.containsKey(w)) {
                map.put(w, 1);
            }
            else {
                map.put(w, map.get(w) + 1);
            }
        }
        System.out.println();
        System.out.print("\tAuthor: ");
        for(String author : this.authors) {
            System.out.print(author + ", ");
        }
        System.out.println();
        for (Map.Entry<String, Integer> entry : map.entrySet())
            System.out.println("\tToken = " + entry.getKey() +
                             ", Frequency = " + entry.getValue());
    }
}
