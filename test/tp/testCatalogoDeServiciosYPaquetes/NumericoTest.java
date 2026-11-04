package tp.testCatalogoDeServiciosYPaquetes;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp.CatalogoDeServiciosYPaquetes.Numerico;

public class NumericoTest {

    private Numerico tipoNumerico;

    @BeforeEach
    public void setUp() {
        tipoNumerico = new Numerico();
    }

    @Test
    public void aceptaUnNumeroDouble() {
  
    Double numero = 2.0; 

    assertDoesNotThrow(() -> tipoNumerico.validarTipo(numero));
}

    @Test
    public void lanzaExcepcionSiElNumeroEsNulo() {
        RuntimeException error = assertThrows(RuntimeException.class, () -> {
            tipoNumerico.validarTipo(null);
        });

        assertEquals("El valor numérico no puede ser nulo.", error.getMessage());
    }
}