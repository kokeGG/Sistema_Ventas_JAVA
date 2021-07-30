package clases;

/**
 *
 * @author koke
 */
public class Producto {
    int id, stock;
    String nombre, estado;
    double precio;

    public Producto() {
    }

    public Producto(int id, double precio, int stock, String nombre, String estado) {
        this.id = id;
        this.precio = precio;
        this.stock = stock;
        this.nombre = nombre;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
