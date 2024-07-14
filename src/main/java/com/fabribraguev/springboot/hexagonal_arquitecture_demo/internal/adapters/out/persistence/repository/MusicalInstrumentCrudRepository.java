package com.fabribraguev.springboot.hexagonal_arquitecture_demo.internal.adapters.out.persistence.repository;

import com.fabribraguev.springboot.hexagonal_arquitecture_demo.internal.adapters.out.persistence.entity.MusicalInstrumentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface MusicalInstrumentCrudRepository extends PagingAndSortingRepository<MusicalInstrumentEntity,String> {
    List<MusicalInstrumentEntity> findAll();
}