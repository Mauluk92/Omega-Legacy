package it.aleph.omega.dao;

import it.aleph.omega.model.Author;

public interface AuthorDao {

    Author findAuthorById(Long id);

    Author createAuthor(Author author);
    void deleteAuthor(Long id);
    Author updateAuthor(Author author, Long id);

}
