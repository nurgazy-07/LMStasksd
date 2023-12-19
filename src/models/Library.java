package models;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private long id;
    private String labraryName;
    private String address;
    private List<Book> books = new ArrayList<>();
    private List<Reader> readers = new ArrayList<>();

    public Library() {
    }

    public Library(long id, String name, String address, List<Book> books, List<Reader> readers) {
        this.id = id;
        this.labraryName = name;
        this.address = address;
        this.books = books;
        this.readers = readers;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return labraryName;
    }

    public void setName(String name) {
        this.labraryName = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Book> getBooks() {
        return books ;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<Reader> getReaders() {
        return readers;
    }

    public void setReaders(List<Reader> readers) {
        this.readers = readers;
    }

    @Override
    public String toString() {
        return "Library " +"\n"+
                "  Id      = " + id +"\n"+
                "  Name    = " + labraryName +"\n"+
                "  Address = " + address +"\n"+
                "  Books   = " + books +"\n"+
                "  Readers = " + readers +".";
    }
}
