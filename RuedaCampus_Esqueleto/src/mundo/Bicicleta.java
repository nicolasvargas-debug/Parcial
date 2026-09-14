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
        throw new UnsupportedOperationException("TODO: implementar el requerimiento.");
    }
}
