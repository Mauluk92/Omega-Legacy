package it.aleph.omega.dao.impl;

import it.aleph.omega.dao.AuthorDao;
import it.aleph.omega.exception.NotFoundException;
import it.aleph.omega.model.Author;
import jakarta.inject.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;
import java.util.Optional;

@Singleton
public class AuthorDaoImpl implements AuthorDao {

    @PersistenceContext(unitName = "OmegaLibrary")
    private EntityManager entityManager;
    @Override
    public Author findAuthorById(Long id) {
        Optional<Author> authorOptional = Optional.ofNullable(entityManager.find(Author.class, id));
        return authorOptional.orElseThrow(() -> buildNotFoundException(id));
    }

    @Override
    public Author createAuthor(Author author) {
        entityManager.persist(author);
        return author;
    }

    @Override
    public void deleteAuthor(Long id) {
        Author authorFound = findAuthorById(id);
        entityManager.remove(authorFound);
    }

    @Override
    public Author updateAuthor(Author author, Long id) {
        findAuthorById(id);
        author.setId(id);
        return entityManager.merge(author);
    }

    private NotFoundException buildNotFoundException(Long id){
        return NotFoundException.builder()
                .idListNotFound(List.of(id))
                .message("The requested resources with id: " + id + " was not found")
                .build();
    }
}
