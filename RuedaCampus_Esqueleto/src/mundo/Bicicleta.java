package mundo;

public class Bicicleta extends Vehiculo {
    public Bicicleta(String codigo) {
        super(codigo);
    }

    @Override
    public String getTipo() {
        return "Bicicleta";
    }

    /**
     * TODO: explicar el propósito y las reglas del método.
     * @param horas TODO: significado, tipo y unidad
     * @return TODO: tipo y significado del resultado
     * @throws IllegalArgumentException TODO: condición que la produce
     */
    
    @Override
    public double calcularCosto(int horas) {
       
    	double valor=0;
    	double total_parcial = 0;
    	double total = 0;
    	if (horas <= 0 ) {
    		throw new IllegalArgumentException("El número de horas debe ser mayor a 0");
    	}
    	
    	if (horas <=2) {
    		valor= 4000; 
    		total = valor* horas;
    		
    	}
    	
    	if (horas >2 ) {
    		valor = 3000;
   
    		total_parcial = valor * (horas-2);
    		total = total_parcial + 8000;
    		
    		
    	}
    	  
    	return total;
    	
    	
    }

    }
