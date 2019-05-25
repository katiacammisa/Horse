package TpRedBlackTree;

import java.io.Serializable;

public class Book implements Serializable, Comparable<Book> {

    private Integer key;
    private String title;
    private String author;
    private long code;

    Book(Integer key, String title, String author, long code) {
        this.key = key;
        this.title = title;
        this.author = author;
        this.code = code;
    }

    Integer getKey() {
        return key;
    }

    String getTitle() {
        return title;
    }

    String getAuthor() {
        return author;
    }

    long getCode() {
        return code;
    }

    void setTitle(String title) {
        this.title = title;
    }

    void setAuthor(String author) {
        this.author = author;
    }

    void setCode(long code) {
        this.code = code;
    }

    @Override
    public int compareTo(Book x) {
        if(x != null) {
            return Integer.compare(key, x.key);
        } else{
            throw new RuntimeException("Not Comparable");
        }
    }

    @Override
    public String toString(){
        return key + ": Title: " + title + ", Author: " + author + ", Code: " + code;
    }

}
