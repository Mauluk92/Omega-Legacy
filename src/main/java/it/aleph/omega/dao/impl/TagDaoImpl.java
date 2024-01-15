package it.aleph.omega.dao.impl;

import it.aleph.omega.dao.TagDao;
import it.aleph.omega.exception.NotFoundException;
import it.aleph.omega.model.Tag;
import jakarta.inject.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;
import java.util.Optional;

@Singleton
public class TagDaoImpl implements TagDao {

    @PersistenceContext(unitName = "OmegaLibrary")
    private EntityManager entityManager;

    @Override
    public Tag findTagById(Long id) {
        Optional<Tag> optionalTag = Optional.ofNullable(entityManager.find(Tag.class, id));
        return optionalTag.orElseThrow(() -> buildNotFoundException(id));
    }

    @Override
    public Tag createTag(Tag tag) {
        entityManager.persist(tag);
        return tag;
    }

    @Override
    public void deleteTag(Long id) {
        Tag tagFound = findTagById(id);
        entityManager.remove(tagFound);
    }

    @Override
    public Tag updateTag(Tag tag, Long id) {
        findTagById(id);
        tag.setId(id);
        return entityManager.merge(tag);
    }

    private NotFoundException buildNotFoundException(Long id){
        return NotFoundException.builder()
                .idListNotFound(List.of(id))
                .message("The requested resources with id: " + id + " was not found")
                .build();
    }
}
