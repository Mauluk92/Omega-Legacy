package it.aleph.omega.service;

import it.aleph.omega.dto.TagDto;

public interface TagService {

    TagDto findTagById(Long id);
    TagDto createTag(TagDto tag);
    void deleteTag(Long id);
    TagDto updateTag(TagDto tag, Long id);
}
