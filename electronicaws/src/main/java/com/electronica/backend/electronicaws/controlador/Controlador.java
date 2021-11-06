package com.electronica.backend.electronicaws.controlador;

import com.electronica.backend.electronicaws.dto.Producto;
import com.electronica.backend.electronicaws.dto.RespuestaProducto;
import com.electronica.backend.electronicaws.servicio.Servicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = {"*"})
public class Controlador {
    @Autowired
    private Servicio servicio;
    @RequestMapping(
        value = "obtener-productos",method = RequestMethod.POST,
        consumes = "application/json;charset=utf-8",
        produces = "application/json;charset=utf-8"
    )
    public @ResponseBody RespuestaProducto obtenerProducto(@RequestBody Producto producto){
        RespuestaProducto respuestaProducto = new RespuestaProducto();
        respuestaProducto.setLista(servicio.obtenerProducto(producto));
        return respuestaProducto;
    }
}
