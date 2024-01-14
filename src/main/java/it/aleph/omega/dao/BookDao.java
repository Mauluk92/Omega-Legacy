package it.aleph.omega.dao;

import it.aleph.omega.model.Book;
import org.hibernate.query.Page;

import java.util.List;

public interface BookDao {

    Book findBookById(Long id);
    Book createBook(Book book);
    void deleteBook(Long id);
    Book updateBook(Book book, Long id);
    Book updateBookStatus(Boolean status, Long id);
    Book associateAuthorListToBook(List<Long> idAuthorList, Long idBook);
    Book associateTagListToBook(List<Long> idTagList, Long idBook);
    List<Book> findBooks(Integer pageNumber, Integer pageSize);
}
