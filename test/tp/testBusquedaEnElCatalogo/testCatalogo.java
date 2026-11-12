package tp.testBusquedaEnElCatalogo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp.BusquedaEnElCatalogo.Catalogo;
import tp.BusquedaEnElCatalogo.Criterio;
import tp.CatalogoDeServiciosYPaquetes.IItemCatalogo;

/** La busqueda solo filtra: la decision de que item cumple la toma el criterio. */
public class testCatalogo {

    private IItemCatalogo hotel;
    private IItemCatalogo museo;
    private IItemCatalogo pack;
    private Catalogo catalogo;

    @BeforeEach
    public void setUp() {
        hotel = mock(IItemCatalogo.class);
        museo = mock(IItemCatalogo.class);
        pack = mock(IItemCatalogo.class);

        catalogo = new Catalogo();
        catalogo.agregar(hotel);
        catalogo.agregar(museo);
        catalogo.agregar(pack);
    }

    @Test
    public void buscarDevuelveSoloLosQueCumplenRespetandoElOrden() {
        Criterio criterio = mock(Criterio.class);
        when(criterio.cumple(hotel)).thenReturn(true);
        when(criterio.cumple(pack)).thenReturn(true);
        // museo no se configura: el mock devuelve false por defecto

        List<IItemCatalogo> esperados = new ArrayList<>();
        esperados.add(hotel);
        esperados.add(pack);
        assertEquals(esperados, catalogo.buscar(criterio));
    }

    @Test
    public void siNingunoCumpleLaBusquedaDevuelveUnaListaVacia() {
        assertTrue(catalogo.buscar(mock(Criterio.class)).isEmpty());
    }

    @Test
    public void unCatalogoVacioNoEncuentraNada() {
        Criterio cualquiera = mock(Criterio.class);

        assertTrue(new Catalogo().buscar(cualquiera).isEmpty());
    }
}
