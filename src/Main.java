import models.Book;
import models.Databases;
import models.Library;
import models.Reader;
import servises.LibrariService;
import servises.serviceimpl.BookServiceImpl;
import servises.serviceimpl.LibraryServiceImpl;
import servises.serviceimpl.ReaderServiceImpl;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        ArrayList<Book> books1 = new ArrayList<>(Arrays.asList(
//                new Book( "nurgzay", "temiraliev", Genres.HISTORY)));
//        ArrayList<Reader> readers1 = new ArrayList<>(Arrays.asList(
//                new Reader("karabaev", "asdf", 7097777, Genders.MALE),
//                new Reader("erjigit", "asdff", 77776, Genders.MALE)
//        ));
        Databases databases = new Databases();
        LibrariService librariService = new LibraryServiceImpl(databases);
        BookServiceImpl bookService = new BookServiceImpl(databases);
        ArrayList<Library> library1 = new ArrayList<>();
        ReaderServiceImpl readerService = new ReaderServiceImpl(databases);
        while (true){
            System.out.println("""
                    1 -> Китепкана кошуу
                    2 -> Баардык китепканаларды алуу
                    3 -> Id си аркылуу алуу
                    4 -> Атын озгортуу
                    5 -> Очуруу
                    6 -> Китепканага китеп кошуу
                    7 -> Китепканадагы баардык китептерди алуу
                    8 -> Китепти id си аркылуу алуу
                    9 -> Китепти очуруу
                    10 -> Бир китепканадагы китептердин баарын очуруу
                    11 -> Китепканага окууучу кошуу
                    12 -> Баардык окуучуларды алуу
                    13 -> Окуучуну id си аркылуу алуу
                    14 -> Окуучунун атын озгортуу
                    бир команда танданыз: 
                    """);
            switch (scanner.nextLine()) {
                case "1" ->{
                    librariService.saveLibrary(databases.libraries);
                }
                case "2" ->{
                    System.out.println(librariService.getAllLibraries());
                }
                case "3" ->{
                    System.out.println("Алууну каалаган китепкананын id син жаз: ");
                    System.out.println(librariService.getLibraryById(new Scanner(System.in).nextLong()));
                }
                case "4" ->{
                    System.out.println("Озгортууну каалаган китепкананын id син жаз: ");
                    System.out.println(librariService.updateLibrary(new Scanner(System.in).nextLong(), new Library()));
                }
                case "5" ->{
                    System.out.println("Очурууну каалаган китепкананын id син жаз: ");
                    System.out.println(librariService.deleteLibrary(new Scanner(System.in).nextLong()));
                }
                case "6" ->{
                    System.out.println("Китеп кошууну каалаган китепкананын id син жаз: ");
                    System.out.println(bookService.saveBook(new Scanner(System.in).nextLong(), new Book()));
                }
                case "7" ->{
                    System.out.println("Китептердин баарын коруу учун китепкананын id син жаз: ");
                    System.out.println(bookService.getAllBooks(new Scanner(System.in).nextLong()));
                }
                case "8" ->{
                    Scanner scanner1 = new Scanner(System.in);
                    System.out.println("Китепкананы танда: ");
                    long soz = scanner1.nextLong();
                    System.out.println("Китептин id син жаз: ");
                    long soz2 = scanner1.nextLong();
                    System.out.println(bookService.getBookById(soz, soz2));
                }
                case "9" ->{
                    Scanner scanner1 = new Scanner(System.in);
                    System.out.println("Китепкананы танда: ");
                    long xo = scanner1.nextLong();
                    System.out.println("Китепти очуруу учун id син жаз: ");
                    long sdf = scanner1.nextLong();
                    System.out.println(bookService.deleteBook(xo, sdf));
                }
                case "10" ->{
                    System.out.println("Китепкананы танда: ");
                    bookService.clearBooksByLibraryId(new Scanner(System.in).nextLong());
                }
                case "11" ->{
                    System.out.println("Китепкананы танда: ");
                    readerService.saveReader(new Scanner(System.in).nextLong(),new Reader());
                }
                case "12" ->{
                    System.out.println("Китепкананы танда: ");
                    System.out.println(readerService.getAllReaders(new Scanner(System.in).nextLong()));
                }
                case "13" ->{
                    System.out.println("Китепкананы танда: ");
                    System.out.println(readerService.getReaderById(new Scanner(System.in).nextLong()));
                }
                case "14" ->{
                    System.out.println("Китепкананы танда: ");
                    System.out.println(readerService.updateReader(new Scanner(System.in).nextLong(), new Reader()));
                }
                case "15" ->{
                    Scanner scanner1 = new Scanner(System.in);
                    System.out.println("Китепкананы танда: ");
                    long s = scanner1.nextLong();
                    System.out.println("Окуучунун id син жаз: ");
                    long a = scanner1.nextLong();
                    readerService.assignReaderToLibrary(a, s);
                }

            }
        }
    }
}