package com.fabribraguev.springboot.hexagonal_arquitecture_demo.internal.adapters.out.persistence.repository;

import com.fabribraguev.springboot.hexagonal_arquitecture_demo.internal.adapters.out.persistence.entity.MusicalInstrumentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MusicalInstrumentCrudRepository extends JpaRepository<MusicalInstrumentEntity,String> {
}