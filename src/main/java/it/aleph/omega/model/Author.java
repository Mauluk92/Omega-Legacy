package it.aleph.omega.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="author")
@Getter
@Setter
public class Author {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private Long id;
    @Column(nullable=false, name="name")
    private String name;
    @Column(nullable=false, name="biography")
    private String biography;

    @ManyToMany(mappedBy = "authorList")
    private List<Book> bookList;
}
