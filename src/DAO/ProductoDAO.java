/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import clases.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author koke
 */
public class ProductoDAO implements CRUD{
    int r;
    Conexion cn = new Conexion();
    Producto pr = new Producto();
    
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    
    public int actualizarStock(int cant, int idp){
        String sql = "UPDATE producto SET Stock = ? WHERE IdProducto = ?";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, cant);
            ps.setInt(2, idp);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al actualizar stock" + e);
        }
        return r;
    }
    
    public Producto listarProductoID(int id){
        Producto p = new Producto();
        String sql = "SELECT * FROM producto WHERE IdProducto = ?";
        
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                p.setId(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setPrecio(rs.getDouble(3));
                p.setStock(rs.getInt(4));
                p.setEstado(rs.getString(5));
                
            }
        } catch (Exception e) {
            System.out.println("Error al listar ID de los productos");
        }
        return p;
    }
    
    @Override
    public List listar() {
        List<Producto> lista = new ArrayList<>();
        String sql = "SELECT * FROM producto";
        
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {         
                Producto pro = new Producto();
                pro.setId(rs.getInt(1));
                pro.setNombre(rs.getNString(2));
                pro.setPrecio(rs.getDouble(3));
                pro.setStock(rs.getInt(4));
                pro.setEstado(rs.getString(5));
                lista.add(pro);
                System.out.println("Productos mostrados"); 
            }
        } catch (Exception e) {
            System.out.println("Error al mostrar productos" + e);
        }
        return lista;
    }

    @Override
    public int add(Object[] o) {
        int r = 0;
        String sql = "INSERT INTO producto (Nombres, Precio, Stock, Estado) VALUES (?, ?, ?, ?)";
        
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            ps.setObject(4, o[3]);
            r = ps.executeUpdate();
            System.out.println("Productos agregados");
        } catch (Exception e) {
            System.out.println("Error al agregar productos" + e);
        }
        return r;
    }

    @Override
    public int actualizar(Object[] o) {
        int r = 0;
        String sql = "UPDATE producto SET Nombres = ?, Precio = ?, Stock = ?, Estado = ? WHERE IdProducto = ?";
        
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            ps.setObject(4, o[3]);
            ps.setObject(5, o[4]);
            r = ps.executeUpdate();
            System.out.println("Productos modificados");
            
        } catch (Exception e) {
            System.out.println("Error al modificador productos" + e);
        }
        return r;
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM producto WHERE IdProducto = ?";
        
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setObject(1, id);
            ps.executeUpdate();
            System.out.println("Producto eliminado");
            
        } catch (Exception e) {
            System.out.println("Error al eliminar producto" + e);
        }
    }
    
}
