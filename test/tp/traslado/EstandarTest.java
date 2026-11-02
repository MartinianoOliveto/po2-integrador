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
        estandar = new Estandar(1, direccion, plataformaMock);
    }

    @Test
    public void testEstandarCalculaCostoDelegandoEnPlataforma() {
        estandar.calcularCosto(); 
        verify(plataformaMock,times(1)).estimarTraslado(1,direccion);
    }

    @Test
    public void testEstandarDevuelveElCostoQueEstimaLaPlataforma() {
	when(plataformaMock.estimarTraslado(1, direccion)).thenReturn(1f);
    float costo = estandar.calcularCosto();
	assertEquals(1, costo);
}
}
    