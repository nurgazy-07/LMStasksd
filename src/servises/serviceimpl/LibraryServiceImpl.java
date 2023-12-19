package servises.serviceimpl;

import models.*;
import servises.LibrariService;

import java.util.List;
import java.util.Scanner;

public class LibraryServiceImpl implements LibrariService {
    private final Databases databases;

    public LibraryServiceImpl(Databases databases) {
        this.databases = databases;
    }

    @Override
    public List<Library> saveLibrary(List<Library> libraries){
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();
        library.setId(GenereteId.setId());
        System.out.println("write library name: ");
        library.setName(scanner.nextLine());
        System.out.println("write address: ");
        library.setAddress(scanner.nextLine());
        databases.libraries.add(library);
        return libraries;
    }

    @Override
    public List<Library> getAllLibraries() {
       return databases.libraries;

    }


    @Override
    public Library getLibraryById(Long id) {
    Scanner scanner = new Scanner(System.in);
        for (Library library : databases.libraries) {
            if(id == library.getId()){
                return library;
            }
        }
        return null;
    }

    @Override
    public Library updateLibrary(Long id, Library library) {
        for (Library library1 : databases.libraries) {
            try {
                if(library1.getId() == id){
                    System.out.println(library1);
                    System.out.println(" Китепкананын жаны атын жазыныз: ");
                    String num = new Scanner(System.in).nextLine();
                    library1.setName(num);
                    System.out.println("Ийгиликтуу озгорду!");
                    return library1;
                }else throw new RuntimeException("Ката");
            }catch (RuntimeException e){
                System.out.println(e.getMessage());
            }

        }
        return null;
    }

    @Override
    public String deleteLibrary(Long id) {
        for (Library library : databases.libraries) {
            if(library.getId() == id){
                System.out.println(library);
                databases.libraries.remove(library);
                return "очурулду";
            }else return "ката";
        }
        return null;
    }
}
