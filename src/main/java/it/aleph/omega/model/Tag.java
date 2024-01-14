package it.aleph.omega.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="tag")
public class Tag {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String tag;
    private String description;

    @ManyToMany(mappedBy = "tagList")
    private List<Book> taggedBookList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Book> getTaggedBookList() {
        return taggedBookList;
    }

    public void setTaggedBookList(List<Book> taggedBookList) {
        this.taggedBookList = taggedBookList;
    }
}
