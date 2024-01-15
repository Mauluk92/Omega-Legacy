package it.aleph.omega.dao.impl;

import it.aleph.omega.dao.BookDao;
import it.aleph.omega.model.Author;
import it.aleph.omega.model.Book;
import it.aleph.omega.model.Tag;
import jakarta.inject.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


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

    @Override
    public Book updateBookStatus(Boolean status, Long id) {
        Book bookFound = entityManager.find(Book.class, id);
        bookFound.setAvailable(status);
        return bookFound;
    }

    @Override
    public Book associateAuthorListToBook(List<Long> idAuthorList, Long idBook) {
        List<Author> authorList = idAuthorList.stream().map(id -> entityManager.find(Author.class, id)).collect(Collectors.toList());
        Book bookFound = entityManager.find(Book.class, idBook);
        bookFound.setAuthorList(authorList);
        return bookFound;
    }

    @Override
    public Book associateTagListToBook(List<Long> idTagList, Long idBook) {
        List<Tag> tagList = idTagList.stream().map(id -> entityManager.find(Tag.class, id)).collect(Collectors.toList());
        Book bookFound = entityManager.find(Book.class, idBook);
        bookFound.setTagList(tagList);
        return bookFound;
    }

    @Override
    public List<Book> findBooksFiltered(Integer pageNumber, Integer pageSize, Long authorId, List<Long> tagListId, String title) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Book> criteriaQuery = criteriaBuilder.createQuery(Book.class);
        Root<Book> bookRoot = criteriaQuery.from(Book.class);
        Root<Author> authorRoot = criteriaQuery.from(Author.class);
        Root<Tag> tagRoot = criteriaQuery.from(Tag.class);
        List<Predicate> joinAuthorPredicateList = new ArrayList<>();
        List<Predicate> joinTagPredicateList = new ArrayList<>();
        List<Predicate> filterBookPredicateList = new ArrayList<>();
        CriteriaBuilder.In<Long> tagListInExpression = criteriaBuilder.in(tagRoot.get("id"));
        CriteriaBuilder.In<Long> authorListInExpression = criteriaBuilder.in(authorRoot.get("id"));
        tagListId.forEach(tagListInExpression::value);
        authorListInExpression.value(authorId);
        joinTagPredicateList.add(criteriaBuilder.in(tagListInExpression));
        joinAuthorPredicateList.add(criteriaBuilder.in(tagListInExpression));
        filterBookPredicateList.add(criteriaBuilder.equal(bookRoot.get("title"), title));
        bookRoot.join(Author.class, JoinType.INNER).on(joinAuthorPredicateList.toArray(new Predicate[]{}));
        bookRoot.join(Tag.class, JoinType.INNER).on(joinTagPredicateList.toArray(new Predicate[]{}));
        return entityManager
                .createQuery(criteriaQuery
                .select(bookRoot)
                .where(filterBookPredicateList.toArray(new Predicate[]{})))
                .setFirstResult(pageNumber * pageSize)
                .setMaxResults(pageSize)
                .getResultList();
    }
}
