package org.ultindia.theosophy;

/**
 * Created by srikanta on 15/7/16.
 */


public class Quote {

    public enum AUTHORS {HPB, WQJ, RC};

    int id;
    String author;
    String quote;
    //String misc;

    public Quote() {
    }

    public Quote(String author, String quote) {
        this.author = author;
        this.quote = quote;
        //this.misc = misc;
    }

    public Quote(int id, String author, String quote) {
        this.id = id;
        this.author = author;
        this.quote = quote;
        //this.misc = misc;
    }

    public int getId() { return this.id; }
    public String getAuthor() { return this.author; }
    public String getQuote() { return this.quote; }

    public void setId(int id) { this.id = id; }
    public void setAuthor(String author) { this.author = author; }
    public void setQuote(String quote) { this.quote = quote; }
}
