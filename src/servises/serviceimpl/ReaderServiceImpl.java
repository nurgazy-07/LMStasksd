package servises.serviceimpl;

import models.Databases;
import models.Library;
import models.Reader;
import models.ReadersId;
import models.enums.Genders;
import servises.ReaderService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ReaderServiceImpl implements ReaderService {
    public final Databases databases;

    public ReaderServiceImpl(Databases databases) {
        this.databases = databases;
    }

    @Override
    public void saveReader(Long LibraryId, Reader reader) {
        Scanner scanner = new Scanner(System.in);
        reader.setId(ReadersId.ReaderId());
        for (Library library : databases.libraries) {
            if (library.getId() == LibraryId) {
                System.out.println("Атынызды жазыныз: ");
                reader.setFullName(scanner.nextLine());
                System.out.println("Логин жазыныз: ");
                reader.setEmail(scanner.nextLine());
                System.out.println("Телефон номеринизди жазыныз: ");
                reader.setPhoneNumber(new Scanner(System.in).nextLong());
                System.out.println("Жынысыныз: ");
                String n = scanner.nextLine();
                if (n.equals("m")) {
                    reader.setGender(Genders.MALE);
                } else if (n.equals("f")) {
                    reader.setGender(Genders.FEMALE);
                }
                System.out.println("Ийгиликтуу кошулду! ");
                ArrayList<Reader> readers = (ArrayList<Reader>) library.getReaders();
                readers.add(reader);
                library.setReaders(readers);
            }
        }
    }


    @Override
    public List<Reader> getAllReaders(Long libraryId) {
        List<Reader> readers = null;
        for (Library library : databases.libraries) {
            if(library.getId() == libraryId){
                return library.getReaders();
            }

        }
        return readers;
    }

    @Override
    public Reader getReaderById(Long id) {
        Scanner scanner = new Scanner(System.in);
        for (Library library : databases.libraries) {
            for (Reader reader : library.getReaders()) {
                System.out.println("Окуучунун id син жаз: ");
                id = scanner.nextLong();
                if(reader.getId() == id){
                    return reader;
                }
            }
        }

        return null;
    }

    @Override
    public Reader updateReader(Long id, Reader reader) {
        for (Library library : databases.libraries) {
            for (Reader libraryReader : library.getReaders()) {
                System.out.println("Озгортууну каалаган окуучунун id син жаз: ");
                id = new Scanner(System.in).nextLong();
                if(libraryReader.getId() == id){
                    System.out.println(libraryReader);
                    System.out.println("Окуучунун жаны атын жаз: ");
                    String soz = new Scanner(System.in).nextLine();
                    libraryReader.setFullName(soz);
                    System.out.println("Ийгиликтуу озгорду!");
                }
            }
        }
        return null;
    }

    @Override
    public void assignReaderToLibrary(Long readerId, Long libraryId) {
        for (Library library : databases.libraries) {
            if(library.getId() == libraryId){
                libraryId = new Scanner(System.in).nextLong();
                for (Reader reader : library.getReaders()) {
                    if(reader.getId() == readerId){
                        library.setId(reader.getId());
                        System.out.println("Ийгиликтуу ыйгарылды!");
                    }
                }
            }
        }
    }
}
