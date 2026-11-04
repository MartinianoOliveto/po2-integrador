package tp.testCatalogoDeServiciosYPaquetes;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;

import tp.CatalogoDeServiciosYPaquetes.Fecha;

public class FechaTest {

    private Fecha tipoFecha;

    @BeforeEach
    public void setUp() {
        tipoFecha = new Fecha();
    }

    @Test
    public void aceptaUnaFechaCualquiera() {
        // Mock de LocalDate: aísla la prueba de un día u hora en particular
        LocalDate fecha = mock(LocalDate.class);

        assertDoesNotThrow(() -> tipoFecha.validarTipo(fecha));
    }

    @Test
    public void lanzaExcepcionSiLaFechaEsNula() {
        RuntimeException error = assertThrows(RuntimeException.class, () -> {
            tipoFecha.validarTipo(null);
        });

        assertEquals("La fecha no puede ser nula.", error.getMessage());
    }
}