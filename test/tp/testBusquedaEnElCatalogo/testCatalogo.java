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
import tp.BusquedaEnElCatalogo.ExposicionOperador;
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

    @Test
    public void serviciosMasReservadosOrdenaDeMasAMenosCuposReservados() {
        when(hotel.cuposReservados()).thenReturn(3);
        when(museo.cuposReservados()).thenReturn(5);
        when(pack.cuposReservados()).thenReturn(0);

        List<IItemCatalogo> esperados = new ArrayList<>();
        esperados.add(museo);
        esperados.add(hotel);
        esperados.add(pack);
        assertEquals(esperados, catalogo.serviciosMasReservados());
    }

    @Test
    public void conIgualCantidadDeCuposSeRespetaElOrdenDelCatalogo() {
        List<IItemCatalogo> esperados = new ArrayList<>();
        esperados.add(hotel);
        esperados.add(museo);
        esperados.add(pack);
        assertEquals(esperados, catalogo.serviciosMasReservados());   // los mocks devuelven 0 cupos
    }

    @Test
    public void serviciosPorCupoDevuelveTodosLosItemsSinExponerLaListaInterna() {
        List<IItemCatalogo> devueltos = catalogo.serviciosPorCupo();
        devueltos.clear();

        assertEquals(3, catalogo.serviciosPorCupo().size());
    }

    @Test
    public void exposicionPorProveedorCalculaElPorcentajeDeCadaOperador() {
        List<String> deHotel = new ArrayList<>();
        deHotel.add("Trivago");
        List<String> deMuseo = new ArrayList<>();
        deMuseo.add("Turismo BA");
        List<String> delPack = new ArrayList<>();
        delPack.add("Trivago");
        delPack.add("Trivago");
        when(hotel.operadores()).thenReturn(deHotel);
        when(museo.operadores()).thenReturn(deMuseo);
        when(pack.operadores()).thenReturn(delPack);

        List<ExposicionOperador> exposicion = catalogo.exposicionPorProveedor();

        assertEquals(2, exposicion.size());   // Trivago aparece una sola vez
        assertEquals("Trivago", exposicion.get(0).getOperador());
        assertEquals(75f, exposicion.get(0).getPorcentaje(), 0.001f);
        assertEquals("Turismo BA", exposicion.get(1).getOperador());
        assertEquals(25f, exposicion.get(1).getPorcentaje(), 0.001f);
    }

    @Test
    public void unCatalogoVacioNoTieneExposicion() {
        assertTrue(new Catalogo().exposicionPorProveedor().isEmpty());
    }
}
