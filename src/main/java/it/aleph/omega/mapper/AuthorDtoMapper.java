package it.aleph.omega.mapper;

import it.aleph.omega.dto.AuthorDto;
import it.aleph.omega.model.Author;
import org.mapstruct.Mapper;

@Mapper(componentModel = "jakarta" )
public interface AuthorDtoMapper {

    Author toEntity(AuthorDto dto);
    AuthorDto toDto(Author entity);
}
