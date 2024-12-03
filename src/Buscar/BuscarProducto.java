package Buscar;
import Producto.Productos;

import java.io.*;
import java.util.*;


public class BuscarProducto {

    public static void main(String[] args) {

        String ruta = "D:\\ExamenFinalPracticoEnCasa\\";
        String nombreArchivo = "Inventario.txt";

        List<Productos> productos = new ArrayList<>();
        cargarProductos(ruta + nombreArchivo, productos);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la categoría que desea ver: ");
        String categoriaBusqueda = scanner.nextLine().trim();

        filtrarProductosPorCategoria(categoriaBusqueda, productos);

        scanner.close();
    }
    public static void cargarProductos(String rutaArchivo, List<Productos> productos) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {

                String[] datos = linea.split(";");

                if (datos.length == 5) {
                    String idProducto = datos[0];
                    String nombreProducto = datos[1];
                    String categoria = datos[2];
                    double precio = Double.parseDouble(datos[3].replace(".", "").replace(",", "."));
                    int cantidad = Integer.parseInt(datos[4].trim());

                    Productos producto = new Productos(idProducto, nombreProducto, categoria, precio, cantidad);
                    productos.add(producto);
                } else {

                    System.out.println("Formato No Valido: " + linea);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void filtrarProductosPorCategoria(String categoria, List<Productos> productos) {
        boolean encontrado = false;
        System.out.println("Filtrando productos de la categoría: " + categoria);
        for (Productos p : productos) {
            if (p.getCategoria().equalsIgnoreCase(categoria)) {
                mostrarProducto(p);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontraron productos en la categoría: " + categoria);
        }
    }


    public static void mostrarProducto(Productos p) {
        System.out.println("ID: " + p.getNombreProductos() + ", Nombre: " + p.getNombreProductos() +
                ", Categoría: " + p.getCategoria() + ", Precio: " + p.getPrecio() +
                ", Cantidad: " + p.getCantidad());
    }
}
