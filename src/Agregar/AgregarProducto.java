package Agregar;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AgregarProducto {

    public static void main(String[] args) {

        String ruta = "D:\\ExamenFinalPracticoEnCasa\\";
        String nombreArchivo = "Inventario.txt";

        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el ID del producto: ");
        String idProducto = scanner.nextLine();

        System.out.print("Ingrese el nombre del producto: ");
        String nombreProducto = scanner.nextLine();

        System.out.print("Ingrese la categoría del producto: ");
        String categoria = scanner.nextLine();

        System.out.print("Ingrese el precio del producto: ");
        double precio = scanner.nextDouble();

        System.out.print("Ingrese la cantidad del producto: ");
        int cantidad = scanner.nextInt();

        // El nuevo producto que deseas agregar
        //String nuevoProducto = "5;Ceral de chocolate;Cereal;8000;23";

        String nuevoProducto = idProducto + ";" + nombreProducto + ";" + categoria + ";" + precio + ";" + cantidad;

        try (FileReader fr = new FileReader(ruta + nombreArchivo);
             BufferedReader br = new BufferedReader(fr)) {

            String linea;
            System.out.println("Contenido actual del archivo:");
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
            try (FileWriter fw = new FileWriter(ruta + nombreArchivo, true);  // Modo append
                 BufferedWriter bw = new BufferedWriter(fw)) {

                bw.newLine();
                bw.write(nuevoProducto);
                System.out.println("Producto agregado: " + nuevoProducto);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
