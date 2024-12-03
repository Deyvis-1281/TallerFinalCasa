package Reporte;
import Producto.Productos;

import java.io.*;
import java.util.*;

public class GenerarReporte {

    public static void main(String[] args) {

        String ruta = "D:\\ExamenFinalPracticoEnCasa\\";
        String nombreArchivo = "Inventario.txt";

        ArrayList<Productos> productos = new ArrayList<>();
        cargarProductos(ruta + nombreArchivo, productos);

        double valorTotal = calcularValorTotalInventario(productos);

        generarReporteConValorTotal(ruta + "reporte_inventario.txt", productos, valorTotal);
    }
    public static void cargarProductos(String rutaArchivo, List<Productos> productos) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                if (datos.length == 5) {  // Asegurarse de que la línea tenga 5 elementos
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

    public static double calcularValorTotalInventario(List<Productos> productos) {
        double valorTotal = 0.0;
        for (Productos p : productos) {
            valorTotal += p.getPrecio() * p.getCantidad();  // Multiplicar precio por cantidad
        }
        return valorTotal;
    }

    public static void generarReporteConValorTotal(String rutaReporte, List<Productos> productos, double valorTotal) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaReporte))) {

            bw.write("Reporte de Inventario\n");
            for (Productos p : productos) {
                double valorProducto = p.getPrecio() * p.getCantidad(); // Calcular el valor de cada producto
                bw.write("ID: " + p.getIdProductos() + ", Nombre: " + p.getNombreProductos() +
                        ", Categoría: " + p.getCategoria() + ", Precio: " + p.getPrecio() +
                        ", Cantidad: " + p.getCantidad() + ", Valor: " + valorProducto + "\n");
            }
            bw.write("----------------------\n");
            bw.write("Valor Total del Inventario: " + valorTotal + "\n");
            System.out.println("Reporte generado: " + rutaReporte);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
