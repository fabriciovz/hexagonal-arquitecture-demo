package com.fabribraguev.springboot.hexagonal_arquitecture_demo.internal.adapters.out.persistence.repository;

import com.fabribraguev.springboot.hexagonal_arquitecture_demo.internal.adapters.out.persistence.entity.MusicalInstrumentEntity;
import com.fabribraguev.springboot.hexagonal_arquitecture_demo.internal.adapters.out.persistence.mapper.MusicalInstrumentEntityMapper;
import com.fabribraguev.springboot.hexagonal_arquitecture_demo.internal.domain.domain.MusicalInstrumentModel;
import com.fabribraguev.springboot.hexagonal_arquitecture_demo.internal.ports.out.MusicalInstrumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class MusicalInstrumentRepositoryImpl implements MusicalInstrumentRepository {
    @Autowired
    private MusicalInstrumentCrudRepository musicalInstrumentCrudRepository;
    @Autowired
    private MusicalInstrumentEntityMapper musicalInstrumentEntityMapper;
    @Override
    public MusicalInstrumentModel save(MusicalInstrumentModel musicalInstrument) {
        MusicalInstrumentEntity musicalInstrumentEntity = musicalInstrumentEntityMapper.toEntity(musicalInstrument);
        return musicalInstrumentEntityMapper.toModel(musicalInstrumentCrudRepository.save(musicalInstrumentEntity));
    }
    @Override
    public Optional<MusicalInstrumentModel> getById(String id) {
        Optional<MusicalInstrumentEntity> musicalInstrumentEntity = musicalInstrumentCrudRepository.findById(id);
        return Optional.of(musicalInstrumentEntityMapper.toModel(musicalInstrumentEntity.get()));
    }
    @Override
    public List<MusicalInstrumentModel> getAll() {
        return musicalInstrumentCrudRepository.findAll().stream().map(musicalInstrumentEntityMapper::toModel).collect(Collectors.toList());
    }

    @Override
    public List<MusicalInstrumentModel> getAll(Integer pageNo, Integer pageSize, String sortBy,String sortDirection) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(Sort.Direction.fromString(sortDirection),sortBy));
        return musicalInstrumentCrudRepository.findAll(paging).stream().map(musicalInstrumentEntityMapper::toModel).collect(Collectors.toList());
    }

    @Override
    public void delete(String id) {
        Optional<MusicalInstrumentEntity> musicalInstrumentEntity = musicalInstrumentCrudRepository.findById(id);
        musicalInstrumentCrudRepository.deleteById(musicalInstrumentEntity.get().getId());
    }
}
