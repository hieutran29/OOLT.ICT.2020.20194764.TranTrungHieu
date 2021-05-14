package hust.soict.globalict.aims.model.book;

import java.util.*;

import hust.soict.globalict.aims.model.media.Media;
import hust.soict.globalict.aims.view.Message;

public class Book extends Media {
    private List<String> authors = new ArrayList<String>();
    private String content = "";
    private List<String> contentTokens = new ArrayList<String> ();
    private Map<String, Integer> wordFrequency = new HashMap<String, Integer> ();

    public Book() {
        super();
    }
    
    public Book(String title, String category, String content, String author, float cost) {
        super(title, category, cost);
        this.content = content;
        this.authors.add(author);
        processContent();
    }

    public Book(String title, String category, String content, String[] authors, float cost) {
        super(title, category, cost);
        this.content = content;
        this.authors.addAll(Arrays.asList(authors));
        processContent();
    }

    public Book(String title, String category, String content, List<String> authors, float cost) {
        super(title, category, cost);
        this.content = content;
        this.authors.addAll(authors);
        processContent();
    }

    String content() {
        return this.content;
    }
    
    public List<String> authors() {
        return this.authors;
    }

    public Book clone() {
		int oldNumberMedias = Media.numberMedias;
        Book book = new Book(this.getTitle(), this.getCategory(), this.content, this.authors(), this.getCost());
        
        book.id = this.ID();
        book.dateAdded = this.dateAdded;
        book.free = this.free;
        
        Media.numberMedias = oldNumberMedias;
        return book;
    }

    public int addAuthor(String authorName) {
        if(authors.contains(authorName)) {
            Message.printMessage("Author already existed!!\n", Message.MESSAGE_ERROR);
            return -1;
        }
        this.authors.add(authorName);
        return 0;
    }

    public int removeAuthor(String authorName) {
        if(!authors.contains(authorName)) {
            Message.printMessage("Author does not exist in list\n", Message.MESSAGE_ERROR);
            return -1;
        }
        authors.remove(authorName);
        return 0;
    }

    private void processContent() {
        if(content.isEmpty()) {
            return;
        }

        // clear old data
        contentTokens.clear();
        wordFrequency.clear();

        // process new data
        contentTokens = Arrays.asList(content.split("\\W+"));
        contentTokens.sort( (String s1, String s2) -> {
            return s1.compareToIgnoreCase(s2);
        });

        for(String w : contentTokens) {
            if(!wordFrequency.containsKey(w)) {
                wordFrequency.put(w, 1);
            }
            else {
                wordFrequency.put(w, wordFrequency.get(w) + 1);
            }
        }
    }

    @Override
    public String toString() {
        StringBuffer ret = new StringBuffer();
        ret.append("[ID = " + this.ID()  + "]" + " " +
                    "[Title = " + this.getTitle()    + "]" + " " + 
                    "[Category = " + this.getCategory() + "]" + " ");

        ret.append("[Author = ");
        for(String author : this.authors) {
            ret.append(author + ", ");
        }
        ret.append("] ");

        ret.append("[Cost = " + this.getCost() + "] ");

        ret.append("[\n");
        for(Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            ret.append("\t" + entry.getKey() + ": " + entry.getValue() + "\n");
        }
        ret.append("Total tokens: " + contentTokens.size() + "]");

        return ret.toString();
    }
}
