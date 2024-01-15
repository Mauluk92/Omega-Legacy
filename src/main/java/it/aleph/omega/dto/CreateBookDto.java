package it.aleph.omega.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
@Getter
@Setter
public class CreateBookDto {

    private String title;
    private String isbn;
    private String deweyDecimalCode;
    private String contentDescription;
    private LocalDate pubDate;
    private String pubHouse;
    private Boolean available;
    private BigDecimal price;
}
