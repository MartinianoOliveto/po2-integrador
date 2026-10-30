package tp.traslado;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CalculableTest {

    private Direccion direccion;
    private PlataformaTransporte plataformaMock;
    private TrasladoVIP trasladoVipMock;

    @BeforeEach
    public void setUp() {
        // Setup general para objetos que se reutilizan
        direccion = new Direccion("Roque Saez");
        plataformaMock = mock(PlataformaTransporte.class);
        trasladoVipMock = mock(TrasladoVIP.class);
    }

    @Test
    public void testEstandarCalculaCostoDelegandoEnPlataforma() {

    }
}
       