package models;

import models.enums.Genders;
import models.enums.Genres;

public class Book {
    private long id;
    private String bookName;
    private String athor;
    private Genres genre;

    public Book() {
    }


    public Book(long id, String name, String athor, Genres genre) {
        this.id = id;
        this.bookName = name;
        this.athor = athor;
        this.genre = genre;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return bookName;
    }

    public void setName(String name) {
        this.bookName = name;
    }

    public String getAthor() {
        return athor;
    }

    public void setAthor(String athor) {
        this.athor = athor;
    }

    public Genres getGenre() {
        return genre;
    }

    public void setGenre(Genres genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Book{" +
                ", id='" + id + '\'' +
                ", name='" + bookName + '\'' +
                ", athor='" + athor + '\'' +
                ", genre=" + genre +
                '}';
    }
}
