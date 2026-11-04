package tp.testCatalogoDeServiciosYPaquetes;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp.CatalogoDeServiciosYPaquetes.Booleano;

public class TipoBooleanoTest {
private Booleano tipoBooleano;

    @BeforeEach
    public void setUp() {
        tipoBooleano = new Booleano();
    }

    @Test
    public void aceptaUnValorBooleano() {
        assertDoesNotThrow(() -> tipoBooleano.validarTipo(true));
    }

    @Test
    public void lanzaExcepcionSiElValorEsNulo() {
        RuntimeException error = assertThrows(RuntimeException.class, () -> {
            tipoBooleano.validarTipo(null);
        });

        assertEquals("El valor booleano no puede ser nulo.", error.getMessage());
    }
}

