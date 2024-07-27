package com.fabribraguev.springboot.hexagonal_arquitecture_demo.internal.domain.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MusicalInstrumentModel {
    private String id;
    private String name;
    private String description;
    private Long createdAt;
    private Long lastModifiedAt;
}
