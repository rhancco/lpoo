package com.electronica.backend.electronicaws.dao;

import com.electronica.backend.electronicaws.dto.Producto;
import com.electronica.backend.electronicaws.dto.RespuestaProducto;

import java.util.List;

public interface Dao {
    public List<Producto> obtenerProducto(Producto producto);
}
