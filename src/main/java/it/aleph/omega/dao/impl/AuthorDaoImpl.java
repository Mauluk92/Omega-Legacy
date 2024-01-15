package it.aleph.omega.dao.impl;

import it.aleph.omega.dao.AuthorDao;
import it.aleph.omega.model.Author;
import jakarta.inject.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Singleton
public class AuthorDaoImpl implements AuthorDao {

    @PersistenceContext(unitName = "OmegaLibrary")
    private EntityManager entityManager;
    @Override
    public Author findAuthorById(Long id) {
        return entityManager.find(Author.class, id);
    }

    @Override
    public Author createAuthor(Author author) {
        entityManager.persist(author);
        return author;
    }

    @Override
    public void deleteAuthor(Long id) {
        Author authorFound = entityManager.find(Author.class, id);
        entityManager.remove(authorFound);
    }

    @Override
    public Author updateAuthor(Author author, Long id) {
        author.setId(id);
        return entityManager.merge(author);
    }
}
