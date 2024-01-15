package it.aleph.omega.dao.impl;

import it.aleph.omega.dao.TagDao;
import it.aleph.omega.model.Tag;
import jakarta.inject.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Singleton
public class TagDaoImpl implements TagDao {

    @PersistenceContext(unitName = "OmegaLibrary")
    private EntityManager entityManager;

    @Override
    public Tag findTagById(Long id) {
        return entityManager.find(Tag.class, id);
    }

    @Override
    public Tag createTag(Tag tag) {
        entityManager.persist(tag);
        return tag;
    }

    @Override
    public void deleteTag(Long id) {
        Tag tagFound = entityManager.find(Tag.class, id);
        entityManager.remove(tagFound);
    }

    @Override
    public Tag updateTag(Tag tag, Long id) {
        tag.setId(id);
        return entityManager.merge(tag);
    }
}
