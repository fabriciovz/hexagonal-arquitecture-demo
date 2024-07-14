package com.fabribraguev.springboot.hexagonal_arquitecture_demo.internal.adapters.in.rest.mapper;

import com.fabribraguev.springboot.hexagonal_arquitecture_demo.internal.adapters.in.rest.dto.MusicalInstrumentDTO;
import com.fabribraguev.springboot.hexagonal_arquitecture_demo.internal.core.domain.MusicalInstrumentModel;
import org.springframework.stereotype.Component;
@Component
public class MusicalInstrumentDtoMapper {
    public MusicalInstrumentDTO toDto(MusicalInstrumentModel model) {
        return MusicalInstrumentDTO.builder().
                id(model.getId()).
                name(model.getName()).
                description(model.getDescription()).
                createdAt(model.getCreatedAt()).
                lastModifiedAt(model.getLastModifiedAt()).
                build();
    }
    public MusicalInstrumentModel toModel(MusicalInstrumentDTO dto) {
        return MusicalInstrumentModel.builder().
                id(dto.getId()).
                name(dto.getName()).
                description(dto.getDescription()).
                createdAt(dto.getCreatedAt()).
                lastModifiedAt(dto.getLastModifiedAt()).
                build();
    }
}
/*@Mapper(componentModel = "spring")
public interface MusicalInstrumentDtoMapper {
    //MusicalInstrumentDtoMapper INSTANCE = Mappers.getMapper( MusicalInstrumentDtoMapper.class );

    MusicalInstrumentDTO toDto(MusicalInstrumentModel model);
    MusicalInstrumentModel toModel(MusicalInstrumentDTO dto);
}*/
// old way to write a mapper :)