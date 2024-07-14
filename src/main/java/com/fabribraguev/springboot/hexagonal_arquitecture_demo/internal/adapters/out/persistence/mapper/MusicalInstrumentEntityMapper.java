package com.fabribraguev.springboot.hexagonal_arquitecture_demo.internal.adapters.out.persistence.mapper;

import com.fabribraguev.springboot.hexagonal_arquitecture_demo.internal.adapters.out.persistence.entity.MusicalInstrumentEntity;
import com.fabribraguev.springboot.hexagonal_arquitecture_demo.internal.core.domain.MusicalInstrumentModel;
import org.springframework.stereotype.Component;

@Component
public class MusicalInstrumentEntityMapper {
    public MusicalInstrumentEntity toEntity(MusicalInstrumentModel model) {
        return MusicalInstrumentEntity.builder().
                id(model.getId()).
                name(model.getName()).
                description(model.getDescription()).
                createdAt(model.getCreatedAt()).
                lastModifiedAt(model.getLastModifiedAt()).
                build();
    }
    public MusicalInstrumentModel toModel(MusicalInstrumentEntity entity) {
        return MusicalInstrumentModel.builder().
                id(entity.getId()).
                name(entity.getName()).
                description(entity.getDescription()).
                createdAt(entity.getCreatedAt()).
                lastModifiedAt(entity.getLastModifiedAt()).
                build();
    }
}

/*@Mapper
public interface MusicalInstrumentEntityMapper {
    MusicalInstrumentEntity toEntity(MusicalInstrumentModel musicalInstrumentModel);
    MusicalInstrumentModel toModel(MusicalInstrumentEntity musicalInstrumentEntity);
    List<MusicalInstrumentModel> toModelList(Iterable<MusicalInstrumentEntity> musicalInstrumentEntityList);
}*/



