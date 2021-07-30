package DAO;

import clases.DetalleVentas;
import clases.Ventas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author koke
 */
public class VentasDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    int r = 0;
    
    public String noSerieVentas(){
        String serie = "";
        String sql = "SELECT MAX(NumeroSerie) FROM ventas";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                serie = rs.getString(1);
                
            }
        } catch (Exception e) {
            System.out.println("Error en el numero de serie" + e);
        }
        return serie;
    }
    
    public String idVentas(){
        String idV = "";
        String sql = "SELECT MAX(IdVentas) FROM ventas";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                idV = rs.getString(1);
                
            }
        } catch (Exception e) {
            System.out.println("Error en el numero de serie" + e);
        }
        return idV;
    }
    
    public int guardarVentas(Ventas v){
        String sql = "INSERT INTO ventas(IdCliente, IdVendedor, NumeroSerie, FechaVenta, Monto, Estado) VALUES(?, ?, ?, ?, ?, ?)";
        
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, v.getIdCliente());
            ps.setInt(2, v.getIdVendedor());
            ps.setString(3, v.getSerie());
            ps.setString(4, v.getFecha());
            ps.setDouble(5, v.getMonto());
            ps.setString(6, v.getEstado());
            r = ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error al guardar venta" + e);
        }
        return r;
    }
    
    public int guardarDetalleVenta(DetalleVentas dv){
        String sql = "INSERT INTO detalle_ventas(IdVentas, IdProducto, Cantidad, PrecioVenta) VALUES (?, ?, ?, ?)";
        
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, dv.getIdVentas());
            ps.setInt(2, dv.getIdProducto());
            ps.setInt(3, dv.getCantidad());
            ps.setDouble(4, dv.getPreVenta());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al generar detalle ventas" + e);
        }
        return r;
    }
}
