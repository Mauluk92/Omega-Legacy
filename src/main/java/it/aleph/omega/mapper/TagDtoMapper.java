package it.aleph.omega.mapper;

import it.aleph.omega.dto.TagDto;
import it.aleph.omega.model.Tag;
import org.mapstruct.Mapper;

@Mapper(componentModel = "jakarta" )
public interface TagDtoMapper {

    Tag toEntity(TagDto dto);
    TagDto toDto(Tag entity);
}
