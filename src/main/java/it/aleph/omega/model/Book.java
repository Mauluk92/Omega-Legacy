package it.aleph.omega.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="book")
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getDeweyDecimalCode() {
        return deweyDecimalCode;
    }

    public void setDeweyDecimalCode(String deweyDecimalCode) {
        this.deweyDecimalCode = deweyDecimalCode;
    }

    public String getContentDescription() {
        return contentDescription;
    }

    public void setContentDescription(String contentDescription) {
        this.contentDescription = contentDescription;
    }

    public LocalDate getPubDate() {
        return pubDate;
    }

    public void setPubDate(LocalDate pubDate) {
        this.pubDate = pubDate;
    }

    public String getPubHouse() {
        return pubHouse;
    }

    public void setPubHouse(String pubHouse) {
        this.pubHouse = pubHouse;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public List<Author> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(List<Author> authorList) {
        this.authorList = authorList;
    }

    public List<Tag> getTagList() {
        return tagList;
    }

    public void setTagList(List<Tag> tagList) {
        this.tagList = tagList;
    }
}
