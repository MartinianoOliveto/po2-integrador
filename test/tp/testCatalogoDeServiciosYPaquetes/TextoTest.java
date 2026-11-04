package tp.testCatalogoDeServiciosYPaquetes;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp.CatalogoDeServiciosYPaquetes.Texto;

public class TextoTest {
private Texto tipoTexto;

    @BeforeEach
    public void setUp() {
        tipoTexto = new Texto();
    }

    @Test
    public void aceptaUnTextoCualquiera() {
        String textoCualquiera = "unTextoCualquiera";
        assertDoesNotThrow(() -> tipoTexto.validarTipo(textoCualquiera));
    }

    @Test
    public void lanzaExcepcionSiElTextoEsNulo() {
        RuntimeException error = assertThrows(RuntimeException.class, () -> {
            tipoTexto.validarTipo(null);
        });

        assertEquals("El texto no puede estar vacío.", error.getMessage());
    }
}

