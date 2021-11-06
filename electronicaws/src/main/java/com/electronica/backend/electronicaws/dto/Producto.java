package com.electronica.backend.electronicaws.dto;

import lombok.Data;

@Data
public class Producto {
    private Integer id;
    private Marca marca;
    private String nombre;
    private Double peso;
    private Double precioRegular;
    private Double precioOferta;
    private Boolean oferta;
    private Integer calificacion;
    private String urlImagen;

    public Producto(Integer id, Marca marca, String nombre, Double peso, Double precioRegular, Double precioOferta, Boolean oferta, Integer calificacion, String urlImagen) {
        this.id = id;
        this.marca = marca;
        this.nombre = nombre;
        this.peso = peso;
        this.precioRegular = precioRegular;
        this.precioOferta = precioOferta;
        this.oferta = oferta;
        this.calificacion = calificacion;
        this.urlImagen = urlImagen;
    }
}
