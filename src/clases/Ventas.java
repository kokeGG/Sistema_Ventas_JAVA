package clases;

/**
 *
 * @author koke
 */
public class Ventas {
    
    int id, idCliente, idVendedor;
    String serie, fecha, estado;
    double monto;

    public Ventas() {
    }

    public Ventas(int id, int idCliente, int idVendedor, String serie, String fecha, String estado, double monto) {
        this.id = id;
        this.idCliente = idCliente;
        this.idVendedor = idVendedor;
        this.serie = serie;
        this.fecha = fecha;
        this.estado = estado;
        this.monto = monto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(int idVendedor) {
        this.idVendedor = idVendedor;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
    
    
    
}
