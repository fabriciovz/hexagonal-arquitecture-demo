package com.fabribraguev.springboot.hexagonal_arquitecture_demo.internal.ports.in;

import com.fabribraguev.springboot.hexagonal_arquitecture_demo.internal.domain.domain.MusicalInstrumentModel;
import java.util.List;
import java.util.Optional;

public interface MusicalInstrumentService {
    MusicalInstrumentModel save(MusicalInstrumentModel model);
    Optional<MusicalInstrumentModel> getById(String id);
    List<MusicalInstrumentModel> getAll();
    List<MusicalInstrumentModel> getAll(Integer pageNo, Integer pageSize, String sortBy,String sortDirection);

    void delete(String id);
}
