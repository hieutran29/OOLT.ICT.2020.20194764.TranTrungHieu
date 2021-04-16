package hust.soict.globalict.aims.model.book;

import java.util.*;
import java.util.List;

import hust.soict.globalict.aims.model.media.Media;

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

    public Book(String title, String category, String content, List<String> authors, float cost) {
        super(title, category, cost);
        this.content = content;
        this.authors.addAll(authors);
    }

    String content() {
        return this.content;
    }
    
    public List<String> authors() {
        return this.authors;
    }

    public Book clone() {
		int oldNumberMedias = Media.numberMedias;
        Book book = new Book(this.title(), this.category(), this.content, this.authors(), this.cost());
        
        book.id = this.ID();
        book.dateAdded = this.dateAdded;
        book.free = this.free;
        
        Media.numberMedias = oldNumberMedias;
        return book;
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

    public String getDetail() {
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

        StringBuffer ret = new StringBuffer();
        ret.append("[ID = " + this.ID()  + "]" + " " +
                    "[Title = " + this.title()    + "]" + " " + 
                    "[Category = " + this.category() + "]" + " ");

        ret.append("[Author = ");
        for(String author : this.authors) {
            ret.append(author + ", ");
        }
        ret.append("] ");  
        
        ret.append("[");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            ret.append(entry.getKey() + ": " + entry.getValue() + ", ");
        }
        ret.append("] ");

        ret.append("[Cost = " + this.cost() + "]");

        return ret.toString();
    }
}
