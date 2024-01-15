package it.aleph.omega.service.impl;

import it.aleph.omega.dao.TagDao;
import it.aleph.omega.dto.TagDto;
import it.aleph.omega.mapper.TagDtoMapper;
import it.aleph.omega.service.TagService;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class TagServiceImpl implements TagService {

    private final TagDao tagDao;
    private final TagDtoMapper tagDtoMapper;


    @Inject
    public TagServiceImpl(TagDao tagDao, TagDtoMapper tagDtoMapper){
        this.tagDtoMapper = tagDtoMapper;
        this.tagDao = tagDao;
    }

    @Override
    public TagDto findTagById(Long id) {
        return tagDtoMapper.toDto(tagDao.findTagById(id));
    }

    @Override
    public TagDto createTag(TagDto tag) {
        return tagDtoMapper.toDto(tagDao.createTag(tagDtoMapper.toEntity(tag)));
    }

    @Override
    public void deleteTag(Long id) {
        tagDao.deleteTag(id);
    }

    @Override
    public TagDto updateTag(TagDto tag, Long id) {
        return tagDtoMapper.toDto(tagDao.updateTag(tagDtoMapper.toEntity(tag),id ));
    }
}
