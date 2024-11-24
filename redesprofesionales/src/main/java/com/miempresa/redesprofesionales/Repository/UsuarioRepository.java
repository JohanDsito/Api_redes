package com.miempresa.redesprofesionales.Repository;

import com.miempresa.redesprofesionales.model.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {
}