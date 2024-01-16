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
    @Column(name="id")
    private Long id;
    @Column(nullable=false, name="title")
    private String title;
    @Column(nullable=false, name="isbn")
    private String isbn;
    @Column(nullable=false, name="dewey_decimal_code")
    private String deweyDecimalCode;
    @Column(nullable=false, name="content_description")
    private String contentDescription;
    @Column(nullable=false, name="pub_date")
    private LocalDate pubDate;
    @Column(nullable=false, name="pub_house")
    private String pubHouse;
    @Column(nullable=false, name="available")
    private Boolean available;
    @Column(name="price")
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
