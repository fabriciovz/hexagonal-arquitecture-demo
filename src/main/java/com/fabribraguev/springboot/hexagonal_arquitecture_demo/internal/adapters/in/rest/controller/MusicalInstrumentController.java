package com.fabribraguev.springboot.hexagonal_arquitecture_demo.internal.adapters.in.rest.controller;

import com.fabribraguev.springboot.hexagonal_arquitecture_demo.internal.adapters.in.rest.dto.MusicalInstrumentDTO;
import com.fabribraguev.springboot.hexagonal_arquitecture_demo.internal.adapters.in.rest.mapper.MusicalInstrumentDtoMapper;
import com.fabribraguev.springboot.hexagonal_arquitecture_demo.internal.core.domain.MusicalInstrumentModel;
import com.fabribraguev.springboot.hexagonal_arquitecture_demo.internal.ports.in.MusicalInstrumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/instruments")
public class MusicalInstrumentController {
    @Autowired
    private MusicalInstrumentService musicalInstrumentService;
    @Autowired
    private MusicalInstrumentDtoMapper musicalInstrumentDtoMapper;
    @GetMapping("/{id}")
    public ResponseEntity<MusicalInstrumentDTO> retrieveSurveyById(@PathVariable String id){
        Optional<MusicalInstrumentModel> musicalInstrument = musicalInstrumentService.getById(id);
        return new ResponseEntity<>(musicalInstrumentDtoMapper.toDto(musicalInstrument.get()), HttpStatus.OK);
    }
    @GetMapping("/all")
    public ResponseEntity<List<MusicalInstrumentDTO>> getAll(){
        return new ResponseEntity<>(musicalInstrumentService.
                getAll().
                stream().
                map(musicalInstrumentDtoMapper::toDto).
                collect(Collectors.toList()),HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<MusicalInstrumentDTO>> getAll(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "name") String sortBy,
            @RequestParam(defaultValue = "ASC") String sortDirection){
        return new ResponseEntity<>(musicalInstrumentService.
                getAll(pageNo, pageSize, sortBy,sortDirection).
                stream().
                map(musicalInstrumentDtoMapper::toDto).
                collect(Collectors.toList()),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<MusicalInstrumentDTO> save(@RequestBody MusicalInstrumentDTO musicalInstrumentDTO){
        System.out.println(musicalInstrumentDTO.toString());
        MusicalInstrumentModel dto = musicalInstrumentDtoMapper.toModel(musicalInstrumentDTO);
        MusicalInstrumentModel musicalInstrument = musicalInstrumentService.save(dto);
        return new ResponseEntity<>(musicalInstrumentDtoMapper.toDto(musicalInstrument),HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<MusicalInstrumentDTO> delete(@PathVariable String id){
        musicalInstrumentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
