package tp.traslado;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class EstandarTest {

    private Direccion direccion;
    private PlataformaTransporte plataformaMock;
    private Estandar estandar; 

    @BeforeEach
    public void setUp() {
        direccion = mock(Direccion.class);
        plataformaMock = mock(PlataformaTransporte.class);
        estandar = new Estandar(plataformaMock);
    }

    @Test
    public void testEstandarCalculaCostoDelegandoEnPlataforma() {
        estandar.calcularCosto(10000,4,direccion); 
        verify(plataformaMock,times(1)).estimarTraslado(4,direccion);
    }

    @Test
    public void testEstandarDevuelveElCostoQueEstimaLaPlataforma() {
	when(plataformaMock.estimarTraslado(4, direccion)).thenReturn(1f);
    float costo = estandar.calcularCosto(10000,4,direccion);
	assertEquals(1, costo);
    }
}
    