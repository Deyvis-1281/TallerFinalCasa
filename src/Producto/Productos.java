package Producto;

public class Productos {
    private String idProductos;
    private String nombreProductos;
    private String categoria;
    private double precio;
    private int cantidad;


    public Productos(String idProductos, String nombreProductos, String categoria, double precio, int cantidad) {
        this.idProductos = idProductos;
        this.nombreProductos = nombreProductos;
        this.categoria = categoria;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getIdProductos() {
        return idProductos;
    }

    public void setIdProductos(String idProductos) {
        this.idProductos = idProductos;
    }

    public String getNombreProductos() {
        return nombreProductos;
    }

    public void setNombreProductos(String nombreProductos) {
        this.nombreProductos = nombreProductos;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }


    @Override
    public String toString() {
        // Devolver la cadena en el formato adecuado (con ';' como delimitador)
        return idProductos + "," + nombreProductos + "," + categoria + "," + precio + "," + cantidad;

    }
}