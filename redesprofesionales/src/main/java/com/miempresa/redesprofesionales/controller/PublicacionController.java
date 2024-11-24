package com.miempresa.redesprofesionales.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miempresa.redesprofesionales.model.Publicacion;
import com.miempresa.redesprofesionales.repository.PublicacionRepository;

@RestController
@RequestMapping("/publicaciones")
public class PublicacionController {

    @Autowired
    private PublicacionRepository publicacionRepository;


    @PostMapping
    public Publicacion crearPublicacion(@RequestBody Publicacion publicacion) {
        return publicacionRepository.save(publicacion);
    }

  
    @GetMapping
    public List<Publicacion> obtenerPublicaciones() {
        return publicacionRepository.findAll();
    }

  
    @GetMapping("/{id}")
    public ResponseEntity<Publicacion> obtenerPublicacionPorId(@PathVariable String id) {
        Optional<Publicacion> publicacion = publicacionRepository.findById(id);
        return publicacion.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

   
    @PutMapping("/{id}")
    public ResponseEntity<Publicacion> actualizarPublicacion(@PathVariable String id, @RequestBody Publicacion publicacionActualizada) {
        Optional<Publicacion> publicacionExistente = publicacionRepository.findById(id);
        if (publicacionExistente.isPresent()) {
            Publicacion publicacion = publicacionExistente.get();
            publicacion.setIdPublicacion(publicacionActualizada.getIdPublicacion());
            publicacion.setContenidoTexto(publicacionActualizada.getContenidoTexto());
            publicacion.setFechaPublicacion(publicacionActualizada.getFechaPublicacion());
            publicacion.setComentarios(publicacionActualizada.getComentarios());
            publicacion.setLikes(publicacionActualizada.getLikes());
            publicacionRepository.save(publicacion);
            return ResponseEntity.ok(publicacion);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPublicacion(@PathVariable String id) {
        Optional<Publicacion> publicacion = publicacionRepository.findById(id);
        if (publicacion.isPresent()) {
            publicacionRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}