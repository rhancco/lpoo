package com.electronica.backend.electronicaws.servicio;

import com.electronica.backend.electronicaws.dao.Dao;
import com.electronica.backend.electronicaws.dto.Producto;
import com.electronica.backend.electronicaws.dto.RespuestaProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ServicioImpl implements Servicio{
    @Autowired
    private Dao dao;
    public List<Producto> obtenerProducto(Producto producto) {
        return dao.obtenerProducto(producto);
    }
}
