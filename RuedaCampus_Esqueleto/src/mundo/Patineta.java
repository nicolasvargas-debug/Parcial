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
        throw new UnsupportedOperationException("TODO: implementar el requerimiento.");
    }
}
