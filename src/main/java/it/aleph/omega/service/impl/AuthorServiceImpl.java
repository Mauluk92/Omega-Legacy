package it.aleph.omega.service.impl;

import it.aleph.omega.dao.AuthorDao;
import it.aleph.omega.dto.AuthorDto;
import it.aleph.omega.mapper.AuthorDtoMapper;
import it.aleph.omega.service.AuthorService;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class AuthorServiceImpl implements AuthorService{

    private final AuthorDao authorDao;
    private final AuthorDtoMapper authorDtoMapper;

    @Inject
    public AuthorServiceImpl(AuthorDao authorDao, AuthorDtoMapper authorDtoMapper){
        this.authorDao = authorDao;
        this.authorDtoMapper = authorDtoMapper;
    }

    @Override
    public AuthorDto findAuthorById(Long id) {
        return authorDtoMapper.toDto(authorDao.findAuthorById(id));
    }

    @Override
    public AuthorDto createAuthor(AuthorDto author) {
        return authorDtoMapper.toDto(authorDao.createAuthor(authorDtoMapper.toEntity(author)));
    }

    @Override
    public void deleteAuthor(Long id) {
        authorDao.deleteAuthor(id);
    }

    @Override
    public AuthorDto updateAuthor(AuthorDto author, Long id) {
        return authorDtoMapper.toDto(authorDao.updateAuthor(authorDtoMapper.toEntity(author), id));
    }
}
