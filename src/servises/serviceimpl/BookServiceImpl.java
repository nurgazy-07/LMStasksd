package servises.serviceimpl;

import models.*;
import models.enums.Genres;
import servises.BookService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookServiceImpl implements BookService {
    public final Databases databases;

    public BookServiceImpl(Databases databases) {
        this.databases = databases;
    }

    @Override
    public Book saveBook(Long libraryId, Book book){
        Scanner scanner = new Scanner(System.in);
        book.setId(BookId.Id());
        for (Library library : databases.libraries) {
            if(library.getId() == libraryId){
                System.out.println("Китептин аты: ");
                book.setName(scanner.nextLine());
                System.out.println("Китептин автору: ");
                book.setAthor(scanner.nextLine());
                System.out.println("Жанры: 'love', 'history', 'worlds'  ");
                switch (scanner.nextLine()){
                    case "l, love" -> book.setGenre(Genres.LOVE);
                    case "h, history" -> book.setGenre(Genres.HISTORY);
                    case "w, world" -> book.setGenre(Genres.WORLD);
                }
                ArrayList<Book> books = (ArrayList<Book>) library.getBooks();
                books.add(book);
                library.setBooks(books);
            }
        }
        return book;
    }



    @Override
    public List<Book> getAllBooks(Long libraryId) {
        for (Library library : databases.libraries) {
            if(library.getId()  == libraryId){
                return library.getBooks();

            }
        }
        return null;
    }

    @Override
    public Book getBookById(Long libraryId, Long bookId) {
        for (Library library : databases.libraries) {
            if(library.getId() == libraryId){
                for (Book book : library.getBooks()) {
                    if(book.getId() == bookId){
                        return book;
                    }else System.out.println("Мындай китеп жок: ");
                }
            }
        }
        return null;
    }

    @Override
    public String deleteBook(Long libraryId, Long bookId) {
        for (Library library : databases.libraries) {
            if(library.getId() == libraryId){
                for (Book book : library.getBooks()) {
                    if(book.getId() == bookId){
                        library.getBooks().remove(book);
                        return "Китеп очурулду";
                    }else return "Ката";
                }
            }
        }
        return null;
    }

    @Override
    public void clearBooksByLibraryId(Long libraryId) {
        for (Library library : databases.libraries) {
            if(library.getId() == libraryId){
                    library.getBooks().clear();
            }
        }
    }
}
