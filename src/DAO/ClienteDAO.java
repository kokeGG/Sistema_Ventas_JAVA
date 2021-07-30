package DAO;

import clases.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author koke
 */
public class ClienteDAO implements CRUD{

    Conexion cn = new Conexion();
    Cliente cl = new Cliente();
    
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public Cliente listarClienteID(String dni){
        Cliente c = new Cliente();
        String sql = "SELECT * FROM cliente WHERE Dni = ?";
        
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, dni);
            rs = ps.executeQuery();
            
            while (rs.next()) {  
                c.setId(rs.getInt(1));
                c.setDni(rs.getString(2));
                c.setNom(rs.getString(3));
                c.setDir(rs.getString(4));
                c.setEstado(rs.getString(5));
            }
        } catch (Exception e) {
            System.out.println("Error al listar ID");
        }
        
        return c;
    }
    
    // metodos de manteminiento
    
    @Override
    public List listar() {
        List<Cliente> lista = new ArrayList<>();
        String sql ="SELECT * FROM cliente";
        
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                Cliente c = new Cliente();
                c.setId(rs.getInt(1));
                c.setDni(rs.getString(2));
                c.setNom(rs.getString(3));
                c.setDir(rs.getString(4));
                c.setEstado(rs.getString(5));
                lista.add(c);
                System.out.println("Clientes mostrados");
            }
        } catch (Exception e) {
            System.out.println("Error al mostrar los clientes" + e);
        }
        return lista;
    }

    @Override
    public int add(Object[] o) {
        int r=0;
        String sql="INSERT INTO cliente(Dni, Nombres, Direccion, Estado) VALUES (?, ?, ?, ?)";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            ps.setObject(4, o[3]);
            r = ps.executeUpdate();
            System.out.println("Clientes insertados");
        } catch (Exception e) {
            System.out.println("ERROR AL INSERTAR CLLIENTES" + e);
        }
        return r;
    }

    @Override
    public int actualizar(Object[] o) {
        int r = 0;
        String sql = "UPDATE cliente SET Dni = ?, Nombres = ?, Direccion = ?, Estado = ? WHERE IdCliente = ?";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            ps.setObject(4, o[3]);
            ps.setObject(5, o[4]);
            r = ps.executeUpdate();
            System.out.println("Clientes modificados");
        } catch (Exception e) {
            System.out.println("ERROR AL MODIFICAR CLIENTE" + e);
        }
        return r;
    }

    @Override
    public void eliminar(int id) {
        String sql ="DELETE FROM cliente WHERE IdCliente = ?";
        
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Cliente borrado");
        } catch (Exception e) {
            System.out.println("Error al eliminar cliente" + e);
        }
    }
    
}
