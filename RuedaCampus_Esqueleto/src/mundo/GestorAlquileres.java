package mundo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class GestorAlquileres {
    private final ArrayList<Vehiculo> vehiculos;

    /** Catálogo inicial suministrado: ambos vehículos están disponibles. */
    public GestorAlquileres() {
        vehiculos = new ArrayList<Vehiculo>();
        vehiculos.add(new Bicicleta("B01"));
        vehiculos.add(new Patineta("P01"));
    }

    /**
     * Búsqueda suministrada. Recorre el ArrayList y devuelve la referencia
     * al vehículo existente. No crea vehículos nuevos ni cambia su estado.
     * @param codigo código exacto del catálogo
     * @return vehículo identificado
     * @throws IllegalArgumentException si no existe el código, incluido null
     */
    public Vehiculo buscarVehiculo(String codigo) {
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getCodigo().equals(codigo)) {
                return vehiculo;
            }
        }
        throw new IllegalArgumentException("Código de vehículo inexistente.");
    }

    /**
     * TODO: explicar el propósito y las reglas del método.
     * @param codigo TODO: significado y tipo
     * TODO: explicar el efecto del método void, sin usar @return.
     * @throws IllegalArgumentException TODO: condición que la produce
     * @throws IllegalStateException TODO: condición que la produce
     */
    public void iniciarAlquiler(String codigo) {
    	Vehiculo vehiculo = buscarVehiculo(codigo);
    	if(vehiculo.isDisponible()==true) {
    		vehiculo.setDisponible(false);
        }
        else {
        	throw new IllegalStateException("El vehiculo ya se encuentra alquilado");
        }
    }

    /**
     * TODO: explicar el propósito y las reglas del método.
     * @param codigo TODO: significado y tipo
     * @param horas TODO: significado, tipo y unidad
     * @return TODO: tipo y significado del resultado
     * @throws IllegalArgumentException TODO: condición que la produce
     * @throws IllegalStateException TODO: condición que la produce
     */
    public Comprobante finalizarAlquiler(String codigo, int horas) {
    	Vehiculo vehiculo = buscarVehiculo(codigo);
    	if(vehiculo.isDisponible()==true) {
    		throw new IllegalStateException("El vehiculo ya se encuentra disponible");
        }
    	if (horas< 0) {
    		throw new IllegalArgumentException("El numero de horas no puede ser negativo");
    	}

     
        else {
        	double total= vehiculo.calcularCosto(horas);
        	Comprobante comprobante=new Comprobante(codigo, vehiculo.getTipo(), horas, total);
        	vehiculo.setDisponible(true);
        	return comprobante ;
        }
    }

    /**
     * TODO: explicar el propósito y las reglas del método.
     * @param comprobante TODO: significado y tipo
     * @param ruta TODO: significado y tipo
     * TODO: explicar el efecto del método void, sin usar @return.
     * @throws IllegalArgumentException TODO: condición que la produce
     * @throws IOException TODO: condición que la produce
     */
    public void generarComprobante(Comprobante comprobante, String ruta) throws IOException {
    	ruta= "/RuedaCampus_Esqueleto/data/comprobante.txt";
        if (comprobante.equals(null)) { 
    	throw new IllegalArgumentException("El comprobante no puede ser nulo");
    }
    try(FileWriter archivo= new FileWriter(ruta);
    		BufferedWriter bw = new BufferedWriter(archivo)){
    	bw.write(comprobante.getCodigo());
    	bw.write(comprobante.getTipo());
    	bw.write(comprobante.getHoras());
    	bw.write((int) comprobante.getTotal());
    }
}
}
