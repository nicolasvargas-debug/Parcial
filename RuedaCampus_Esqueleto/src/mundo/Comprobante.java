package mundo;

/** Datos inmutables de un alquiler finalizado. Clase suministrada. */
public final class Comprobante {
    private final String codigo;
    private final String tipo;
    private final int horas;
    private final double total;

    public Comprobante(String codigo, String tipo, int horas, double total) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.horas = horas;
        this.total = total;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public int getHoras() {
        return horas;
    }

    public double getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return "Comprobante [codigo=" + codigo + ", tipo=" + tipo
                + ", horas=" + horas + ", total=" + total + "]";
    }
}
