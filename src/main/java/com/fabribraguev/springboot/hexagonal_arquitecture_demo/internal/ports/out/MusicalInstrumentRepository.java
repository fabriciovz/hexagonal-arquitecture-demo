package com.fabribraguev.springboot.hexagonal_arquitecture_demo.internal.ports.out;

import com.fabribraguev.springboot.hexagonal_arquitecture_demo.internal.core.domain.MusicalInstrumentModel;
import java.util.List;
import java.util.Optional;

public interface MusicalInstrumentRepository {
    MusicalInstrumentModel save(MusicalInstrumentModel musicalInstrument);
    Optional<MusicalInstrumentModel> getById(String id);
    List<MusicalInstrumentModel> getAll();
    void delete(String id);
}
