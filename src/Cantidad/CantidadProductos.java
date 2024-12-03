package Cantidad;
import Producto.Productos;

import java.io.*;
import java.util.*;

public class CantidadProductos {

    public static void main(String[] args) {

        String ruta = "D:\\ExamenFinalPracticoEnCasa\\";
        String nombreArchivo = "Inventario.txt";

        List<Productos> productos = new ArrayList<>();
        cargarProductos(ruta + nombreArchivo, productos);

        contarProductosPorCategoria(productos);
    }
    public static void cargarProductos(String rutaArchivo, List<Productos> productos) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                if (datos.length == 5) {
                    String idProducto = datos[0].trim();
                    String nombreProducto = datos[1].trim();
                    String categoria = datos[2].trim();
                    double precio = Double.parseDouble(datos[3].replace(".", "").replace(",", "."));
                    int cantidad = Integer.parseInt(datos[4].trim());

                    Productos producto = new Productos(idProducto, nombreProducto, categoria, precio, cantidad);
                    productos.add(producto);
                } else {
                    System.out.println("Línea inválida: " + linea);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void contarProductosPorCategoria(List<Productos> productos) {
        // Usamos un mapa para contar los productos por categoría
        Map<String, Integer> contadorCategorias = new HashMap<>();

        for (Productos p : productos) {
            String categoria = p.getCategoria();
            contadorCategorias.put(categoria, contadorCategorias.getOrDefault(categoria, 0) + 1);
        }

        System.out.println("Cantidad de productos por categoría:");
        for (Map.Entry<String, Integer> entry : contadorCategorias.entrySet()) {
            System.out.println("Categoría:  " + entry.getKey() + " - Cantidad de productos:  " + entry.getValue());
        }
    }
}
