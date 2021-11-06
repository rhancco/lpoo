package com.electronica.backend.electronicaws.dto;

import lombok.Data;

@Data
public class Marca {
    private Integer id;
    private String nombre;

    public Marca(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
}
