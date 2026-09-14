package mundo;

public class Patineta extends Vehiculo {
    public Patineta(String codigo) {
        super(codigo);
    }

    @Override
    public String getTipo() {
        return "Patineta";
    }

    /**
     * TODO: explicar el propósito y las reglas del método.
     * @param horas TODO: significado, tipo y unidad
     * @return TODO: tipo y significado del resultado
     * @throws IllegalArgumentException TODO: condición que la produce
     */
    @Override
    public double calcularCosto(int horas) {
    	
    	double valor = 6000;
        double total = 0;
    	if(horas <= 0) {
    		throw new IllegalArgumentException("El número de horas debe ser mayor a 0");
    	}
    	
    	total = horas * valor;
    	
    	if (horas >=3) {
    		total = total - (total*0.1);
    			
    	}
    	
    	return total;
    }
}
