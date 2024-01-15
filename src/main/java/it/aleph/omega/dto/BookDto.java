package it.aleph.omega.dto;

import it.aleph.omega.model.Author;
import it.aleph.omega.model.Tag;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
@Getter
@Setter
public class BookDto {

    private String title;
    private String isbn;
    private String deweyDecimalCode;
    private String contentDescription;
    private LocalDate pubDate;
    private String pubHouse;
    private Boolean available;
    private BigDecimal price;
    private List<AuthorDto> authorList;
    private List<TagDto> tagList;
}
