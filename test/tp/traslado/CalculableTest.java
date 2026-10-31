package tp.traslado;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CalculableTest {

    private Direccion direccion;
    private PlataformaTransporte plataformaMock;
    private TrasladoVIP trasladoVipMock;
    private Estandar e; 

    @BeforeEach
    public void setUp() {
        // Setup general para objetos que se reutilizan
        direccion = mock(Direccion.class);
        plataformaMock = mock(PlataformaTransporte.class);
        trasladoVipMock = mock(TrasladoVIP.class);
        e = new Estandar(1, direccion, plataformaMock);
    }

    @Test
    public void testEstandarCalculaCostoDelegandoEnPlataforma() {
        e.calcularCosto(); 
        verify(plataformaMock,times(1)).estimarTraslado(1,direccion);
    }
}
    