package it.aleph.omega.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="tag")
@Getter
@Setter
public class Tag {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private Long id;
    @Column(nullable=false, name="tag")
    private String tag;
    @Column(nullable=false, name="description")
    private String description;
    @ManyToMany(mappedBy = "tagList")
    private List<Book> taggedBookList;
}
