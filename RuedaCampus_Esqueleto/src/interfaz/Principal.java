package interfaz;

import java.util.Scanner;
import mundo.Comprobante;
import mundo.GestorAlquileres;
import mundo.Vehiculo;

public class Principal {

    // Integrante 1: nombre completo y código.
    // Integrante 2: nombre completo y código.

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        Scanner entrada = new Scanner(System.in);
        GestorAlquileres gestor = new GestorAlquileres();
        Comprobante ultimoComprobante = null;
        int opcion;

        do {
            System.out.println("\nRUEDACAMPUS");
            System.out.println("B01: Bicicleta | P01: Patineta");
            System.out.println("1. Cotizar alquiler");
            System.out.println("2. Iniciar alquiler");
            System.out.println("3. Finalizar alquiler");
            System.out.println("4. Guardar último comprobante");
            System.out.println("5. Salir");
            System.out.print("Opción: ");
            opcion = entrada.nextInt();
            entrada.nextLine();

            try {
                switch (opcion) {
                    case 1: {
                    	
                    	System.out.println("Codigo del vehiculo buscado");
                    	String codigo= entrada.nextLine();
                    	Vehiculo v= gestor.buscarVehiculo(codigo);
                    	System.out.println("Horas deseadas: ");
                    	int horas= entrada.nextInt();
                    	double c=v.calcularCosto(horas);
                    	System.out.println("Costo de alquilar el vehiculo= "+ c);
                        //Solicitar código y horas; cotizar usando una referencia Vehiculo; mostrar el costo.
                        break;
                    }
                    case 2: {
                    	System.out.println("Codigo del vehiculo buscado");
                    	String codigo= entrada.nextLine();
                    	gestor.iniciarAlquiler(codigo);
                    	System.out.println("Alquiler realizado exitosamente");
                        //Solicitar código; iniciar el alquiler; mostrar confirmación.
                        break;
                    }
                    case 3: {
                    	System.out.println("Codigo del vehiculo buscado");
                    	String codigo= entrada.nextLine();
                    	System.out.println("Horas de uso: ");
                    	int horas= entrada.nextInt();
                    	gestor.finalizarAlquiler(codigo, horas);
                    
                        // Solicitar código y horas; finalizar; conservar y mostrar el último comprobante.
                        break;
                    }
                    case 4: {
                    	
                        // TODO: Guardar ultimoComprobante en ./data/comprobante.txt; mostrar confirmación.
                        break;
                    }
                    case 5:
                        System.out.println("Programa finalizado.");
                        break;
                    default:
                        System.out.println("Opción inexistente.");
                }
            } catch (Exception e) {
                // Captura suministrada: mantiene activa la interacción.
                System.out.println("No se pudo realizar la operación: " + e.getMessage());
            }
        } while (opcion != 5);

        entrada.close();
    }
}
