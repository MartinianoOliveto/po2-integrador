package tp.testBusquedaEnElCatalogo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp.BusquedaEnElCatalogo.Catalogo;
import tp.BusquedaEnElCatalogo.Criterio;
import tp.BusquedaEnElCatalogo.CriterioAnd;
import tp.BusquedaEnElCatalogo.CriterioNot;
import tp.BusquedaEnElCatalogo.CriterioOr;
import tp.BusquedaEnElCatalogo.CriterioPorCategoria;
import tp.BusquedaEnElCatalogo.CriterioPorDisponibilidad;
import tp.BusquedaEnElCatalogo.CriterioPorNombre;
import tp.BusquedaEnElCatalogo.CriterioPorPrecioMaximo;
import tp.CatalogoDeServiciosYPaquetes.Categoria;
import tp.CatalogoDeServiciosYPaquetes.IItemCatalogo;
import tp.CatalogoDeServiciosYPaquetes.Paquete;
import tp.CatalogoDeServiciosYPaquetes.Servicio;

public class testBusquedaEnElCatalogo {

    private Servicio hotel;     // Noche de Hotel Central: $15.000
    private Servicio museo;     // Excursión Guiada Museo: $4.000
    private Paquete pack;       // Pack Escapada Urbana: hotel + museo = $19.000, 10% de descuento
    private Catalogo catalogo;

    private final Criterio alojamiento = new CriterioPorCategoria(Categoria.ALOJAMIENTO);
    private final Criterio excursion = new CriterioPorCategoria(Categoria.EXCURSION);
    private final Criterio disponible = new CriterioPorDisponibilidad();

    @BeforeEach
    public void setUp() { // Voy a usar los ejemplos de la tabla del TP 
        hotel = new Servicio("Noche de Hotel Central", 1, "Noche en el hotel", "Hotel Central", Categoria.ALOJAMIENTO, 15000, 0);
        museo = new Servicio("Excursión Guiada Museo", 2, "Visita guiada al museo", "Museo", Categoria.EXCURSION, 4000, 0);

        pack = new Paquete("Pack Escapada Urbana", "Noche de hotel y excursión al museo", 10);
        pack.agregarComponente(hotel);
        pack.agregarComponente(museo);

        catalogo = new Catalogo();
        catalogo.agregar(hotel);
        catalogo.agregar(museo);
        catalogo.agregar(pack);
    }

    // Subtareas para que queden mas legibles las consultas con CriterioOr y CriterioAnd
    private List<Criterio> criterios(Criterio primero, Criterio segundo) {
        List<Criterio> criterios = new ArrayList<>();
        criterios.add(primero);
        criterios.add(segundo);
        return criterios;
    }

    private List<Criterio> criterios(Criterio primero, Criterio segundo, Criterio tercero) {
        List<Criterio> criterios = criterios(primero, segundo);
        criterios.add(tercero);
        return criterios;
    }


    @Test
    public void unServicioPerteneceSoloASuCategoria() {
        assertTrue(hotel.perteneceACategoria(Categoria.ALOJAMIENTO));
        assertFalse(hotel.perteneceACategoria(Categoria.EXCURSION));
    }

    @Test
    public void unPaquetePerteneceALasCategoriasDeSusComponentes() {
        assertTrue(pack.perteneceACategoria(Categoria.ALOJAMIENTO));
        assertTrue(pack.perteneceACategoria(Categoria.EXCURSION));
        assertFalse(pack.perteneceACategoria(Categoria.VUELO));
    }

    @Test
    public void unPaqueteEstaDisponibleSoloSiTodosSusComponentesLoEstan() {
        IItemCatalogo sinCupo = mock(IItemCatalogo.class);
        when(sinCupo.tieneDisponibilidad()).thenReturn(false);

        assertTrue(pack.tieneDisponibilidad());
        pack.agregarComponente(sinCupo);
        assertFalse(pack.tieneDisponibilidad());
    }

    @Test
    public void unPaqueteVacioNoEstaDisponible() {
        Paquete vacio = new Paquete("Pack Escapada Urbana", "Todavia sin componentes", 10);

        assertFalse(vacio.tieneDisponibilidad());
    }

    // CONSULTAS DE EJEMPLO DE LA TABLA
    @Test
    public void alojamientoBaratoYDisponible() {
        // Alojamiento AND precio <= $20.000 AND disponible
        Criterio consulta = new CriterioAnd(criterios(alojamiento, new CriterioPorPrecioMaximo(20000), disponible));

        List<IItemCatalogo> serviciosEsperados = new ArrayList<>();
        serviciosEsperados.add(hotel);
        serviciosEsperados.add(pack);
        assertEquals(serviciosEsperados, catalogo.buscar(consulta));
    }

    @Test
    public void nombreConHotelOResort() {
        // Nombre contiene "hotel" OR nombre contiene "resort"
        Criterio consulta = new CriterioOr(criterios(new CriterioPorNombre("hotel"), new CriterioPorNombre("resort")));

        List<IItemCatalogo> serviciosEsperados = new ArrayList<>();
        serviciosEsperados.add(hotel);
        assertEquals(serviciosEsperados, catalogo.buscar(consulta));
    }

    @Test
    public void todoMenosExcursiones() {
        // NOT categoria = Excursion: el pack tampoco pasa porque incluye el museo
        Criterio consulta = new CriterioNot(excursion);

        List<IItemCatalogo> serviciosEsperados = new ArrayList<>();
        serviciosEsperados.add(hotel);
        assertEquals(serviciosEsperados, catalogo.buscar(consulta));
    }

    // Aca los nombres con criterios anidados
    @Test
    public void alojamientoDisponibleOConOfertaEnElNombre() {
        // (Alojamiento AND disponible) OR nombre contiene "oferta"
        Criterio alojamientoDisponible = new CriterioAnd(criterios(alojamiento, disponible));
        Criterio consulta = new CriterioOr(criterios(alojamientoDisponible, new CriterioPorNombre("oferta")));

        List<IItemCatalogo> serviciosEsperados = new ArrayList<>();
        serviciosEsperados.add(hotel);
        serviciosEsperados.add(pack);
        assertEquals(serviciosEsperados, catalogo.buscar(consulta));
    }

    @Test
    public void niAlojamientosCarosNiExcursiones() {
        // NOT (precio > $15.000 AND Alojamiento OR Excursion)
        Criterio caro = new CriterioNot(new CriterioPorPrecioMaximo(15000));
        Criterio alojamientoCaro = new CriterioAnd(criterios(caro, alojamiento));
        Criterio consulta = new CriterioNot(new CriterioOr(criterios(alojamientoCaro, excursion)));

        List<IItemCatalogo> serviciosEsperados = new ArrayList<>();
        serviciosEsperados.add(hotel);
        assertEquals(serviciosEsperados, catalogo.buscar(consulta));
    }

    @Test
    public void unPackQueIncluyeUnaExcursionNoPasaElFiltroDeNoExcursion() {
        // Nombre contiene "pack" AND NOT categoria = Excursion AND precio <= $25.000
        Criterio consulta = new CriterioAnd(criterios(
                new CriterioPorNombre("pack"),
                new CriterioNot(excursion),
                new CriterioPorPrecioMaximo(25000)));

        assertTrue(catalogo.buscar(consulta).isEmpty());
    }
}
