package pruebas;

import static org.junit.jupiter.api.Assertions.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import mundo.Comprobante;
import mundo.GestorAlquileres;
import mundo.Vehiculo;

public class RuedaCampusTest {
    private GestorAlquileres gestor;
    private static final String RUTA_PRUEBA = "./data/comprobante_prueba.txt";

    @BeforeEach
    void preparar() {
        gestor = new GestorAlquileres();
    }

    // Cotizar B01 y P01 durante 3 horas mediante referencias Vehiculo.
    @Test
    void rf1CostosValidosPorTipo() {
        fail("TODO: implementar esta prueba.");
    }

    // Comprobar horas cero en ambos tipos y una duración negativa.
    @Test
    void rf1RechazaHorasNoPositivas() {
        fail("TODO: implementar esta prueba.");
    }

    // Iniciar B01 y comprobar que queda no disponible.
    @Test
    void rf2IniciaAlquilerDisponible() {
        fail("TODO: implementar esta prueba.");
    }

    // Iniciar B01, intentar iniciarlo otra vez y comprobar su estado.
    @Test
    void rf2RechazaInicioDuplicado() {
        fail("TODO: implementar esta prueba.");
    }

    // Iniciar P01; finalizar a las 3 horas; verificar el comprobante y disponibilidad.
    @Test
    void rf3FinalizaAlquilerValido() {
        fail("TODO: implementar esta prueba.");
    }

    // Iniciar B01; finalizar con cero horas debe fallar y conservarlo alquilado.
    @Test
    void rf3RechazaHorasSinLiberarVehiculo() {
        fail("TODO: implementar esta prueba.");
    }

    // Crear directamente un comprobante y verificar todo el texto almacenado.
    @Test
    void rf4GuardaComprobanteValido() throws IOException {
        fail("TODO: implementar esta prueba.");
    }

    // Comprobar que el argumento null produce IllegalArgumentException.
    @Test
    void rf4RechazaComprobanteNulo() {
        fail("TODO: implementar esta prueba.");
    }

    /** Ayuda suministrada: lee el texto y normaliza los saltos de línea a \n. */
    private String leerArchivo(String ruta) throws IOException {
        String contenido = "";
        try (FileReader archivo = new FileReader(ruta);
                BufferedReader lector = new BufferedReader(archivo)) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                contenido += linea + "\n";
            }
        }
        return contenido;
    }
}
