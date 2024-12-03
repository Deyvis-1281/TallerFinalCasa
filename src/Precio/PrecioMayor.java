package Precio;
import Producto.Productos;

import java.io.*;
import java.util.*;

public class PrecioMayor {

    public static void main(String[] args) {
        String ruta1 = "D:\\ExamenFinalPracticoEnCasa\\";
        File archivo = new File(ruta1 + "Inventario.txt");

        List<Productos> productos = cargarProductosDesdeArchivo(archivo);

        Productos productoDeMayorValor = buscarProductoDeMayorValor(productos);

        if (productoDeMayorValor != null) {
            System.out.println("El producto de mayor valor es:");
            mostrarProducto(productoDeMayorValor);
        } else {
            System.out.println("No se encontraron productos.");
        }
    }

    public static List<Productos> cargarProductosDesdeArchivo(File archivo) {
        List<Productos> productos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                String idProducto = datos[0];
                String nombreProducto = datos[1];
                String categoria = datos[2];

                double precio = Double.parseDouble(datos[3].replace(".", "").replace(",", "")); // Convertir el precio a número
                int cantidad = Integer.parseInt(datos[4]);

                Productos producto = new Productos(idProducto, nombreProducto, categoria, precio, cantidad);
                productos.add(producto);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return productos;
    }

    public static Productos buscarProductoDeMayorValor(List<Productos> productos) {
        Productos productoDeMayorValor = null;
        double valorMaximo = 0;

        for (Productos p : productos) {
            double valorProducto = p.getPrecio(); // Calcular el valor del producto
            if (valorProducto > valorMaximo) {
                valorMaximo = valorProducto;
                productoDeMayorValor = p; // Actualizar el producto de mayor valor
            }
        }

        return productoDeMayorValor;
    }

    public static void mostrarProducto(Productos p) {
        System.out.println("ID: " + p.getIdProductos() +
                ", Nombre: " + p.getNombreProductos() +
                ", Categoría: " + p.getCategoria() +
                ", Precio: " + p.getPrecio() +
                ", Cantidad: " + p.getCantidad());
    }
}
