package servises;

import models.Book;
import models.Library;
import models.Reader;

import java.util.List;

public interface LibrariService  {
    List<Library>saveLibrary(List<Library>libraries);

    List<Library>getAllLibraries();

    Library getLibraryById(Long id);

    Library updateLibrary(Long id, Library library);

    String deleteLibrary(Long id);
}
