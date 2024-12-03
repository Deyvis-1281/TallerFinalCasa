import Actualizar.ActualizarProducto;
import Agregar.AgregarProducto;
//import Buscar.BuscarProducto;
import Buscar.BuscarProducto;
import Cantidad.CantidadProductos;
import Eliminar.EliminarProducto;
import Precio.PrecioMayor;
import Reporte.GenerarReporte;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static <Int> void main(String[] args) {
        String ruta = "D:\\ExamenFinalPracticoEnCasa\\";
        String nombreArchivo = "Inventario.txt";
        ArrayList<String> idProducto = new ArrayList<>();
        ArrayList<String> nombreProducto = new ArrayList<>();
        ArrayList<String> categoria = new ArrayList<>();
        ArrayList<String> precio = new ArrayList<>();
        ArrayList<String> cantidadDisponible = new ArrayList<>();
        Scanner scannerOption = new Scanner(System.in);
        int eleccion;

        try(FileReader fr = new FileReader(ruta+nombreArchivo)){

            BufferedReader br = new BufferedReader(fr);
            String linea;
            System.out.println("--- Inventraio Actualizado ---");
            while((linea=br.readLine()) !=null){
                String[] archivo = linea.split(";");
                System.out.println(linea);
                idProducto.add(archivo[0]);
                nombreProducto.add(archivo[1]);
                categoria.add(archivo[2]);
                precio.add(archivo[3]);
                cantidadDisponible.add(archivo[4]);

            }
            System.out.println("--- --- --- --- --- --- ---");
            System.out.println("--- Menu de Mi Tienda ---");

        }
        catch(Exception e){
            throw new RuntimeException(e);
        }
        do{
            MiMenu.menu();
            eleccion = scannerOption.nextInt();
            scannerOption.nextLine();

            switch (eleccion) {
                case 1:
                    AgregarProducto.main(null);
                    MiMenu.esperarEnter(scannerOption);
                    break;
                case 2:
                    ActualizarProducto.main(null);
                    MiMenu.esperarEnter(scannerOption);
                    break;
                case 3:
                    EliminarProducto.main(null);
                    MiMenu.esperarEnter(scannerOption);
                    break;
                case 4:
                    BuscarProducto.main(null);
                    MiMenu.esperarEnter(scannerOption);
                    break;
                case 5:
                    PrecioMayor.main(null);
                    MiMenu.esperarEnter(scannerOption);
                    break;
                case 6:
                    CantidadProductos.main(null);
                    MiMenu.esperarEnter(scannerOption);
                    break;
                case 7:
                    GenerarReporte.main(null);
                    MiMenu.esperarEnter(scannerOption);
                    break;

            }
        }while (eleccion !=0);
    }
}