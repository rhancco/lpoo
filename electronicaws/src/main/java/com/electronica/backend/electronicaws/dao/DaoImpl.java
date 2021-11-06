package com.electronica.backend.electronicaws.dao;

import com.electronica.backend.electronicaws.dto.Marca;
import com.electronica.backend.electronicaws.dto.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Repository
public class DaoImpl implements Dao{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private Connection conexion;

    private void obtenerConexion(){
        try {
            this.conexion = jdbcTemplate.getDataSource().getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    private void cerrarConexion(ResultSet resultado, Statement sentencia){
        try {
            if(resultado != null) resultado.close();
            if(sentencia != null) sentencia.close();
            this.conexion.commit();
            this.conexion.close();
            this.conexion = null;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public List<Producto> obtenerProducto(Producto producto) {
        List<Producto> productos = new ArrayList<>();
        String SQL = "SELECT p.id_producto, p.id_marca,p.nombre,p.peso,\n" +
                "\tp.precio_regular,p.precio_oferta,p.oferta,p.calificacion,\n" +
                "\tp.url_imagen, m.nombre marca_nombre\n" +
                "FROM producto p JOIN marca m\n" +
                "ON(p.id_marca = m.id_marca)\n" +
                "WHERE upper(p.nombre) LIKE ? ";

        try {
            obtenerConexion();
            PreparedStatement sentencia = this.conexion.prepareStatement(SQL);
            sentencia.setString(1,"%"+producto.getNombre().toUpperCase()+"%");
            ResultSet resultado = sentencia.executeQuery();
            while(resultado.next()){
                Producto p = extraerProducto(resultado);
                productos.add(p);
            }
            cerrarConexion(resultado,sentencia);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return productos;
    }
    private Producto extraerProducto(ResultSet resultado) throws SQLException {
        Producto producto = new Producto(
                resultado.getInt("id_producto"),
                new Marca(
                        resultado.getInt("id_marca"),
                        resultado.getString("marca_nombre")
                )  ,
                resultado.getString("nombre"),
                resultado.getDouble("peso"),
                resultado.getDouble("precio_regular"),
                resultado.getDouble("precio_oferta"),
                "1".equals(resultado.getString("oferta")) ? true : false,
                resultado.getInt("calificacion"),
                resultado.getString("url_imagen")
        );
        return producto;
    }
}
