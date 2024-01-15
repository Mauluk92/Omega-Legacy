package it.aleph.omega.service;

import it.aleph.omega.dto.AuthorDto;

public interface AuthorService {

    AuthorDto findAuthorById(Long id);

    AuthorDto createAuthor(AuthorDto author);
    void deleteAuthor(Long id);
    AuthorDto updateAuthor(AuthorDto author, Long id);
}
