import java.util.Scanner;
public class MiMenu {
    public static void menu() {
        System.out.println("===========================");
        System.out.println("1- Agregar Producto");
        System.out.println("2- Actualizar Producto");
        System.out.println("3- Eliminar Producto");
        System.out.println("4- Buscar por Categoria");
        System.out.println("5. Calcular Precio de Producto");
        System.out.println("6. Calcular Cantidad de Productos");
        System.out.println("7. Reporte Inventario");
        System.out.println("8. Salir");
    }
    public static void esperarEnter(Scanner scanner) { //metodo para hacer la espera y mostra el menu
        System.out.println("Presione Enter para continuar...");
        scanner.nextLine(); // Espera a que el usuario presione Enter
    }

}
