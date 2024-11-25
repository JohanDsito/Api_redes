package com.miempresa.redesprofesionales.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;
import java.util.List;

@Document(collection = "publicaciones")
public class Publicacion {
    @Id
    private String id; 
    private int idPublicacion;
    private String contenidoTexto;
    private Date fechaPublicacion;
    private List<String> comentarios;
    private int likes;

    public Publicacion() {}

    public Publicacion(int idPublicacion, String contenidoTexto, Date fechaPublicacion, List<String> comentarios, int likes) {
        this.idPublicacion = idPublicacion;
        this.contenidoTexto = contenidoTexto;
        this.fechaPublicacion = fechaPublicacion;
        this.comentarios = comentarios;
        this.likes = likes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getIdPublicacion() {
        return idPublicacion;
    }

    public void setIdPublicacion(int idPublicacion) {
        this.idPublicacion = idPublicacion;
    }

    public String getContenidoTexto() {
        return contenidoTexto;
    }

    public void setContenidoTexto(String contenidoTexto) {
        this.contenidoTexto = contenidoTexto;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public List<String> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<String> comentarios) {
        this.comentarios = comentarios;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    @Override
    public String toString() {
        return "Publicacion{" +
                "id='" + id + '\'' +
                ", idPublicacion=" + idPublicacion +
                ", contenidoTexto='" + contenidoTexto + '\'' +
                ", fechaPublicacion=" + fechaPublicacion +
                ", comentarios=" + comentarios +
                ", likes=" + likes +
                '}';
    }
}
