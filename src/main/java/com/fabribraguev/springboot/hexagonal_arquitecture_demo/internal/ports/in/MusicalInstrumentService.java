package com.fabribraguev.springboot.hexagonal_arquitecture_demo.internal.ports.in;

import com.fabribraguev.springboot.hexagonal_arquitecture_demo.internal.core.domain.MusicalInstrumentModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

public interface MusicalInstrumentService {
    MusicalInstrumentModel save(MusicalInstrumentModel model);
    Optional<MusicalInstrumentModel> getById(String id);
    List<MusicalInstrumentModel> getAll();
    void delete(String id);
}
