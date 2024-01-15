package it.aleph.omega.service.impl;

import it.aleph.omega.dao.BookDao;
import it.aleph.omega.dto.BookDto;
import it.aleph.omega.dto.CreateBookDto;
import it.aleph.omega.mapper.BookDtoMapper;
import it.aleph.omega.model.Book;
import it.aleph.omega.service.BookService;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.List;
@Singleton
public class BookServiceImpl implements BookService {

    private final BookDao bookDao;
    private final BookDtoMapper bookDtoMapper;

    @Inject
    public BookServiceImpl(BookDao bookDao, BookDtoMapper bookDtoMapper){
        this.bookDao = bookDao;
        this.bookDtoMapper = bookDtoMapper;
    }

    @Override
    public CreateBookDto createBook(CreateBookDto createBookDto) {
        Book book = bookDtoMapper.toEntity(createBookDto);
        bookDao.createBook(book);
        return createBookDto;
    }

    @Override
    public BookDto findBook(Long id) {
        return bookDtoMapper.toDto(bookDao.findBookById(id));
    }

    @Override
    public void removeBook(Long id) {
        bookDao.deleteBook(id);
    }

    @Override
    public BookDto updateBook(BookDto book, Long id) {
        Book entity = bookDtoMapper.toEntity(book);
        bookDao.updateBook(entity, id);
        return book;
    }

    @Override
    public BookDto updateBookStatus(Boolean status, Long id) {
        return bookDtoMapper.toDto(bookDao.updateBookStatus(status, id));
    }

    @Override
    public BookDto associateAuthorListToBook(List<Long> idList, Long idBook) {
        return bookDtoMapper.toDto(bookDao.associateAuthorListToBook(idList, idBook));
    }

    @Override
    public BookDto associateTagListToBook(List<Long> idList, Long idBook) {
        return bookDtoMapper.toDto(bookDao.associateTagListToBook(idList, idBook));
    }

    @Override
    public List<BookDto> findBooksFiltered(Integer pageNumber, Integer pageSize, Long authorId, List<Long> tagIdList, String title) {
        return bookDtoMapper.toDto(bookDao.findBooksFiltered(pageNumber, pageSize, authorId, tagIdList, title));
    }
}
