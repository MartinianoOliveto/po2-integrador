package tp.testBusquedaEnElCatalogo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import tp.BusquedaEnElCatalogo.CriterioPorCategoria;
import tp.BusquedaEnElCatalogo.CriterioPorDisponibilidad;
import tp.BusquedaEnElCatalogo.CriterioPorNombre;
import tp.BusquedaEnElCatalogo.CriterioPorPrecioMaximo;
import tp.CatalogoDeServiciosYPaquetes.Categoria;
import tp.CatalogoDeServiciosYPaquetes.IItemCatalogo;

/**
 * Las hojas del Composite de criterios.
 * El item es un mock: al criterio no le importa si es un servicio o un paquete, solo le pregunta.
 */
public class testCriteriosSimples {

    private IItemCatalogo item;

    @BeforeEach
    public void setUp() {
        item = mock(IItemCatalogo.class);
    }

    // ---------------- Por nombre ----------------

    @Test
    public void porNombreNoDistingueMayusculas() {
        when(item.getNombre()).thenReturn("Noche de Hotel Central");

        assertTrue(new CriterioPorNombre("hotel").cumple(item));
        assertTrue(new CriterioPorNombre("HOTEL").cumple(item));
    }

    @Test
    public void porNombreNoCumpleSiNoContieneElTexto() {
        when(item.getNombre()).thenReturn("Excursión Guiada Museo");

        assertFalse(new CriterioPorNombre("hotel").cumple(item));
    }

    // ---------------- Por precio maximo ----------------

    @Test
    public void porPrecioMaximoIncluyeElLimite() {
        when(item.getPrecioBase()).thenReturn(15000.0);

        assertTrue(new CriterioPorPrecioMaximo(15000).cumple(item));
    }

    @Test
    public void porPrecioMaximoNoCumpleSiLoSupera() {
        when(item.getPrecioFinal()).thenReturn(15000.0);

        assertFalse(new CriterioPorPrecioMaximo(14999.99).cumple(item));
    }

    // ---------------- Por categoria y disponibilidad: le delegan la pregunta al item ----------------

    @Test
    public void porCategoriaLeDelegaLaPreguntaAlItem() {
        when(item.perteneceACategoria(Categoria.ALOJAMIENTO)).thenReturn(true);

        assertTrue(new CriterioPorCategoria(Categoria.ALOJAMIENTO).cumple(item));
        verify(item).perteneceACategoria(Categoria.ALOJAMIENTO);
    }

    @Test
    public void porCategoriaNoCumpleSiElItemEsDeOtra() {
        when(item.perteneceACategoria(Categoria.ALOJAMIENTO)).thenReturn(false);

        assertFalse(new CriterioPorCategoria(Categoria.ALOJAMIENTO).cumple(item));
    }

    @Test
    public void porDisponibilidadLeDelegaLaPreguntaAlItem() {
        when(item.tieneDisponibilidad()).thenReturn(true);

        assertTrue(new CriterioPorDisponibilidad().cumple(item));
        verify(item).tieneDisponibilidad();
    }

    @Test
    public void porDisponibilidadNoCumpleSiElItemNoTieneCupo() {
        when(item.tieneDisponibilidad()).thenReturn(false);

        assertFalse(new CriterioPorDisponibilidad().cumple(item));
    }
}
