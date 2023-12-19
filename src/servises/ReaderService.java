package servises;

import models.Reader;

import java.util.List;

public interface ReaderService {
    void saveReader(Long LibraryId, Reader reader);

    List<Reader> getAllReaders(Long libraryId);

    Reader getReaderById(Long id);

    Reader updateReader(Long id, Reader reader);

    void assignReaderToLibrary(Long readerId,Long libraryId);
}
