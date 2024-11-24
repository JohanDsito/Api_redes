package com.miempresa.redesprofesionales.Repository;

import com.miempresa.redesprofesionales.model.Publicacion;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicacionRepository extends MongoRepository<Publicacion, String> {
}