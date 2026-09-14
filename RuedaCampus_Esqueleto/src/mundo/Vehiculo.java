package mundo;

/** Clase base suministrada. Conserva la identidad y disponibilidad. */
public abstract class Vehiculo {
    private final String codigo;
    private boolean disponible;

    public Vehiculo(String codigo) {
        if (codigo == null || codigo.trim().isEmpty()) {
            throw new IllegalArgumentException("El código es obligatorio.");
        }
        this.codigo = codigo;
        this.disponible = true;
    }

    public String getCodigo() {
        return codigo;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public abstract String getTipo();

    /**
     * Contrato del RF1. Cada tipo de vehículo aplica su propia tarifa.
     * @param horas duración entera y positiva, en horas
     * @return costo del alquiler, en pesos
     * @throws IllegalArgumentException si las horas no son positivas
     */
    public abstract double calcularCosto(int horas);
}
