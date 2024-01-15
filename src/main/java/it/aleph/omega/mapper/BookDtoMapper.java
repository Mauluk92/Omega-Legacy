package it.aleph.omega.mapper;

import it.aleph.omega.dto.BookDto;
import it.aleph.omega.dto.CreateBookDto;
import it.aleph.omega.model.Book;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "cdi" )
public interface BookDtoMapper {

    Book toEntity(CreateBookDto createBookDto);
    Book toEntity(BookDto bookDto);
    BookDto toDto(Book entity);
    List<BookDto> toDto(List<Book> bookList);
}
