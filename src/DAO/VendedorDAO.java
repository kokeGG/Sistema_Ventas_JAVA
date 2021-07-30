package DAO;

import clases.Vendedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author koke
 */
public class VendedorDAO implements CRUD{
    
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    Conexion cn = new Conexion();
    
    public Vendedor listarVendedorID(String dni){
        Vendedor v = new Vendedor();
        String sql = "SELECT * FROM vendedor";
        
        try {
            
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            while (rs.next()) {
                v.setId(rs.getInt(1));
                v.setDni(rs.getString(2));
                v.setNom(rs.getString(3));
                v.setTel(rs.getString(4));
                v.setEstado(rs.getString(5));
                v.setUser(rs.getString(6));
            }
        } catch (Exception e) {
            System.out.println("Error al listar ID de los vendedores");
        }
        return v;
    }
    
    public Vendedor validarVendedor(String dni, String user){
        Vendedor v = new Vendedor();
        String sql = "SELECT * FROM vendedor WHERE Dni = ? AND User = ?";
        
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, dni);
            ps.setString(2, user);
            rs = ps.executeQuery();
            
            while (rs.next()) {                
                v.setId(rs.getInt(1));
                v.setDni(rs.getString(2));
                v.setNom(rs.getString(3));
                v.setEstado(rs.getString(4));
                v.setTel(rs.getString(5));
                v.setUser(rs.getString(6));
               
            }
        } catch (Exception e) {
            System.out.println("Error to validate user");
        }
        return v;
    }

    @Override
    public List listar() {
        List<Vendedor> lista = new ArrayList<>();
        String sql = "SELECT * FROM vendedor";
        
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {                
                Vendedor ven = new Vendedor();
                ven.setId(rs.getInt(1));
                ven.setDni(rs.getString(2));
                ven.setNom(rs.getString(3));
                ven.setTel(rs.getString(4));
                ven.setEstado(rs.getString(5));
                ven.setUser(rs.getString(6));
                
                lista.add(ven);
                System.out.println("Vendedores mostrados");
            }
        } catch (Exception e) {
            System.out.println("Error al mostrar vendedores " + e);
        }
        
        return lista;
    }

    @Override
    public int add(Object[] o) {
        int r = 0;
        String sql = "INSERT INTO vendedor (Dni, Nombres, Telefono, Estado, User) VALUES (?, ?, ?, ?, ?)";
        
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            ps.setObject(4, o[3]);
            ps.setObject(5, o[4]);
            r = ps.executeUpdate();
            System.out.println("Vendedores insertados");
        } catch (Exception e) {
            System.out.println("Error al insertar vendedores" + e);
        }
        return r;
    }

    @Override
    public int actualizar(Object[] o) {
        int r = 0;
        String sql = "UPDATE vendedor SET Dni = ?, Nombres = ?, Telefono = ?, Estado = ?, User = ? WHERE IdVendedor = ?";
        
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            ps.setObject(4, o[3]);
            ps.setObject(5, o[4]);
            ps.setObject(6, o[5]);
            r = ps.executeUpdate();
            System.out.println("Vendedores Modificados");
        } catch (Exception e) {
            System.out.println("Error al modificar vendeddores" + e);
        }
        
        return r;
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM vendedor WHERE IdVendedor = ?";
        
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setObject(1, id);
            ps.executeUpdate();
            System.out.println("Vendedor eliminado");
            
        } catch (Exception e) {
            System.out.println("Error al eliminar vendedor" + e);
        }
    }
    
}
