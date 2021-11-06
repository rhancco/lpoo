package com.electronica.backend.electronicaws.dto;

import lombok.Data;

import java.util.List;

@Data
public class RespuestaProducto {
    private List<Producto> lista;
}
