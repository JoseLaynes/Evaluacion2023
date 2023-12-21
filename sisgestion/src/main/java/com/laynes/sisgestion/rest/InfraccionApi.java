package com.laynes.sisgestion.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.laynes.sisgestion.entity.Infraccion;
import com.laynes.sisgestion.service.InfraccionService;

@RestController
@RequestMapping("/api/infracciones")
public class InfraccionApi {

    @Autowired
    private InfraccionService service;

    @GetMapping()
    public ResponseEntity<List<Infraccion>> getAll() {
        List<Infraccion> infracciones = service.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(infracciones);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Infraccion> getById(@PathVariable("id") int id) {
        Infraccion infraccion = service.findById(id);
        if (infraccion != null) {
            return ResponseEntity.status(HttpStatus.OK).body(infraccion);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody Infraccion infraccion) {
        try {
            Infraccion infraccionDb = service.create(infraccion);
            return ResponseEntity.status(HttpStatus.CREATED).body(infraccionDb);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping
    public ResponseEntity<Object> update(@RequestBody Infraccion infraccion) {
        try {
            Infraccion infraccionDb = service.update(infraccion);
            return ResponseEntity.status(HttpStatus.OK).body(infraccionDb);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") int id) {
        int result = service.delete(id);
        if (result == 1) {
            return ResponseEntity.status(HttpStatus.OK).build();
        } else if (result == 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
