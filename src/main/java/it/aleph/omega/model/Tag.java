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
    private Long id;
    private String tag;
    private String description;
    @ManyToMany(mappedBy = "tagList")
    private List<Book> taggedBookList;
}
