package tp.testCatalogoDeServiciosYPaquetes;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import tp.CatalogoDeServiciosYPaquetes.AtributoDinamico;
import tp.CatalogoDeServiciosYPaquetes.ITipoDeValor;

public class AtributoDinamicoTest {
 private interface CualquierTipo {}
 private ITipoDeValor<CualquierTipo> cualquierTipo;
 private CualquierTipo valorTipoNuevo;
 private AtributoDinamico<CualquierTipo> atributoConTipoNuevo;
 
@BeforeEach

public void setUp(){
        cualquierTipo = mock(ITipoDeValor.class);
        valorTipoNuevo = mock(CualquierTipo.class);
        atributoConTipoNuevo = new AtributoDinamico<>("AtributoPrueba", true, cualquierTipo);
}

@Test
    public void seteaElValor() {
        atributoConTipoNuevo.setValor(valorTipoNuevo);
        assertEquals(valorTipoNuevo, atributoConTipoNuevo.getValor());
    }

    @Test
    public void lanzaExcepcionSiEsObligatorioYNoTieneValor() {
      RuntimeException errorEsperado = assertThrows(RuntimeException.class, () -> {
            atributoConTipoNuevo.validar();
        });

        assertEquals("Falta el valor del atributo obligatorio: AtributoPrueba", errorEsperado.getMessage());
    }

    @Test 
  
    public void llegaElMensajeAValidarTipo() {
    atributoConTipoNuevo.setValor(valorTipoNuevo);

    assertDoesNotThrow(() -> atributoConTipoNuevo.validar());

    verify(cualquierTipo).validarTipo(valorTipoNuevo);
}
}
 