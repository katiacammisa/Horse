package TpRojinegro;

import java.io.Serializable;

public class Book implements Serializable, Comparable<Book> {

    private int key;
    private String title;
    private String author;
    private long code;

    public Book(int key, String title, String author, long code) {
        this.key = key;
        this.title = title;
        this.author = author;
        this.code = code;
    }

    public int getKey() {
        return key;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public long getCode() {
        return code;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setCode(long code) {
        this.code = code;
    }

    @Override
    public int compareTo(Book x) {
        if(x instanceof Book) {
            return Integer.compare(key, ((Book) x).key);
        } else{
            throw new RuntimeException("Not Comparable");
        }
    }

}
