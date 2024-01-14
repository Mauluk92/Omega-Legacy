package it.aleph.omega.dao.impl;

import it.aleph.omega.dao.BookDao;
import it.aleph.omega.model.Book;
import jakarta.inject.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


@Singleton
public class BookDaoImpl implements BookDao {
    @PersistenceContext(unitName = "OmegaLibrary")
    private EntityManager entityManager;
    @Override
    public Book findBookById(Long id){
        return entityManager.find(Book.class, id);
    }
    @Override
    public Book createBook(Book book){
        entityManager.persist(book);
        return book;
    }
    @Override
    public void deleteBook(Long id){
        Book bookFound = entityManager.find(Book.class, id);
        entityManager.remove(bookFound);
    }
    @Override
    public Book updateBook(Book book, Long id){
        book.setId(id);
        return entityManager.merge(book);
    }

}
