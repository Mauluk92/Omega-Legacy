package it.aleph.omega.dao;

import it.aleph.omega.model.Book;

public interface BookDao {

    Book findBookById(Long id);
    Book createBook(Book book);
    void deleteBook(Long id);
    Book updateBook(Book book, Long id);
}
