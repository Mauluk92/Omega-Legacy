package it.aleph.omega.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="book")
@Getter
@Setter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String isbn;
    private String deweyDecimalCode;
    private String contentDescription;
    private LocalDate pubDate;
    private String pubHouse;
    private Boolean available;
    private BigDecimal price;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "book_author",
            joinColumns =@JoinColumn(name="book_id",
                    referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name="author_id",
                    referencedColumnName = "id") )
    private List<Author> authorList;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "book_tag",
            joinColumns =@JoinColumn(name="book_id",
                    referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name="tag_id",
                    referencedColumnName = "id") )
    private List<Tag> tagList;
}
