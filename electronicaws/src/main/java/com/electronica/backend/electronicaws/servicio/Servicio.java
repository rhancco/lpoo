package com.electronica.backend.electronicaws.servicio;

import com.electronica.backend.electronicaws.dto.Producto;
import com.electronica.backend.electronicaws.dto.RespuestaProducto;

import java.util.List;

public interface Servicio {
    public List<Producto> obtenerProducto(Producto producto);
}
