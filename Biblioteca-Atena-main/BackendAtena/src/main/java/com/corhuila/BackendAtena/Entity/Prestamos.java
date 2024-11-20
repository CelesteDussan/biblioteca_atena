package com.corhuila.BackendAtena.Entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "prestamos")
public class Prestamos{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @Column(name = "fecha_prestamo", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPrestamo;

    @Column(name = "fecha_devolucion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaDevolucion;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "clientes_id")
    private Clientes clientesId;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "libros_id")
    private Libros librosId;

    @Column(name = "estado", length = 100, nullable = false)
    private String estado;

    // Getters and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public Clientes getClientesId() {
        return clientesId;
    }

    public void setClientesId(Clientes hola) {
        this.clientesId = hola;
    }

    public Libros getLibrosId() {
        return librosId;
    }

    public void setLibrosId(Libros librosId) {
        this.librosId = librosId;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
