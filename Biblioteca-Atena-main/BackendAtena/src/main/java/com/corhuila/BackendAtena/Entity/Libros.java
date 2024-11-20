package com.corhuila.BackendAtena.Entity;


import jakarta.persistence.*;

@Entity
@Table(name = "libros")
public class Libros{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "titulo", length = 200, nullable = false)
    private String titulo;

    @Column(name = "autor", length = 200, nullable = false)
    private String autor;

    @Column(name = "categoria", length = 200, nullable = false)
    private String categoria;


    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
