package com.visiplus.graines.controller;

import com.visiplus.graines.model.TypeDeGraine;
import com.visiplus.graines.repository.TypeDeGraineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/types-de-graine")
public class TypeDeGraineController {

    @Autowired
    private TypeDeGraineRepository typeDeGraineRepository;

    @GetMapping
    public List<TypeDeGraine> getAllTypesDeGraine() {
        return typeDeGraineRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TypeDeGraine> getTypeDeGraineById(@PathVariable Long id) {
        Optional<TypeDeGraine> typeDeGraine = typeDeGraineRepository.findById(id);
        return typeDeGraine.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public TypeDeGraine createTypeDeGraine(@RequestBody TypeDeGraine typeDeGraine) {
        return typeDeGraineRepository.save(typeDeGraine);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TypeDeGraine> updateTypeDeGraine(@PathVariable Long id,
            @RequestBody TypeDeGraine typeDeGraine) {
        if (!typeDeGraineRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        typeDeGraine.setId(id);
        return ResponseEntity.ok(typeDeGraineRepository.save(typeDeGraine));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTypeDeGraine(@PathVariable Long id) {
        if (!typeDeGraineRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        typeDeGraineRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
