package it.aleph.omega.dao;

import it.aleph.omega.model.Tag;

public interface TagDao {

    Tag findTagById(Long id);
    Tag createTag(Tag tag);
    void deleteTag(Long id);
    Tag updateTag(Tag tag, Long id);
}
