package com.fabribraguev.springboot.hexagonal_arquitecture_demo.internal.core.services;

import com.fabribraguev.springboot.hexagonal_arquitecture_demo.internal.core.domain.MusicalInstrumentModel;
import com.fabribraguev.springboot.hexagonal_arquitecture_demo.internal.ports.in.MusicalInstrumentService;
import com.fabribraguev.springboot.hexagonal_arquitecture_demo.internal.ports.out.MusicalInstrumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MusicalInstrumentServiceImpl implements MusicalInstrumentService {
    @Autowired
    private MusicalInstrumentRepository repository;
    @Override
    public MusicalInstrumentModel save(MusicalInstrumentModel model) {
        if (model.getId()==null){
            model.setId(UUID.randomUUID().toString());
            model.setCreatedAt(System.currentTimeMillis());
        }
        model.setLastModifiedAt(System.currentTimeMillis());
        return repository.save(model);
    }
    @Override
    public Optional<MusicalInstrumentModel> getById(String id) {
        return repository.getById(id);
    }
    @Override
    public List<MusicalInstrumentModel> getAll() {
        return repository.getAll();
    }
    @Override
    public void delete(String id) {
        repository.delete(id);
    }
}
