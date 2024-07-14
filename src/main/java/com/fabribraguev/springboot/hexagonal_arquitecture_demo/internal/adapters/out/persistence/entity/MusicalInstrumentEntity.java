package com.fabribraguev.springboot.hexagonal_arquitecture_demo.internal.adapters.out.persistence.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "musical_instruments")
@Data //getter y setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MusicalInstrumentEntity {
    @Id
    private String id;
    private String name;
    private String description;
    @Column(name = "created_at")
    private Long createdAt;
    @Column(name = "updated_at")
    private Long lastModifiedAt;
}
