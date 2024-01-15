package it.aleph.omega.service;

import it.aleph.omega.dto.BookDto;
import it.aleph.omega.dto.CreateBookDto;

import java.util.List;

public interface BookService {

    CreateBookDto createBook(CreateBookDto createBookDto);
    BookDto findBook(Long id);
    void removeBook(Long id);
    BookDto updateBook(BookDto book, Long id);
    BookDto updateBookStatus(Boolean status, Long id);
    BookDto associateAuthorListToBook(List<Long> idList, Long idBook);
    BookDto associateTagListToBook(List<Long> idList, Long idBook);
    List<BookDto> findBooksFiltered(Integer pageNumber, Integer pageSize, Long authorId, List<Long> tagIdList, String title);

}
