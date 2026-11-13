package tp.testBusquedaEnElCatalogo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp.BusquedaEnElCatalogo.Criterio;
import tp.BusquedaEnElCatalogo.CriterioAnd;
import tp.BusquedaEnElCatalogo.CriterioNot;
import tp.BusquedaEnElCatalogo.CriterioOr;
import tp.CatalogoDeServiciosYPaquetes.IItemCatalogo;


//  Los nodos compuestos del Composite de criterios (AND, OR) y el NOT.
//  Los hijos son criterios mockeados
//  asi se prueba solo la logica de combinacion, sin depender de los criterios simples.
public class testCriteriosCompuestos {

    private IItemCatalogo item;

    @BeforeEach
    public void setUp() {
        item = mock(IItemCatalogo.class);
    }

    private Criterio criterioQueDevuelve(boolean resultado) {
        Criterio criterio = mock(Criterio.class);
        when(criterio.cumple(item)).thenReturn(resultado);
        return criterio;
    }

    private List<Criterio> criterios(Criterio primero, Criterio segundo) {
        List<Criterio> criterios = new ArrayList<>();
        criterios.add(primero);
        criterios.add(segundo);
        return criterios;
    }

    @Test
    public void andCumpleSiTodosCumplen() {
        Criterio and = new CriterioAnd(criterios(criterioQueDevuelve(true), criterioQueDevuelve(true)));

        assertTrue(and.cumple(item));
    }

    @Test
    public void andNoCumpleSiAlgunoNoCumple() {
        Criterio and = new CriterioAnd(criterios(criterioQueDevuelve(true), criterioQueDevuelve(false)));

        assertFalse(and.cumple(item));
    }

    @Test
    public void andCortaEnElPrimeroQueNoCumple() {
        Criterio segundo = mock(Criterio.class);

        assertFalse(new CriterioAnd(criterios(criterioQueDevuelve(false), segundo)).cumple(item));
        verify(segundo, never()).cumple(item);
    }

    @Test
    public void orCumpleSiAlgunoCumple() {
        Criterio or = new CriterioOr(criterios(criterioQueDevuelve(false), criterioQueDevuelve(true)));

        assertTrue(or.cumple(item));
    }

    @Test
    public void orNoCumpleSiNingunoCumple() {
        Criterio or = new CriterioOr(criterios(criterioQueDevuelve(false), criterioQueDevuelve(false)));

        assertFalse(or.cumple(item));
    }

    @Test
    public void orCortaEnElPrimeroQueCumple() {
        Criterio segundo = mock(Criterio.class);

        assertTrue(new CriterioOr(criterios(criterioQueDevuelve(true), segundo)).cumple(item));
        verify(segundo, never()).cumple(item);
    }

    @Test
    public void notInvierteElResultado() {
        assertFalse(new CriterioNot(criterioQueDevuelve(true)).cumple(item));
        assertTrue(new CriterioNot(criterioQueDevuelve(false)).cumple(item));
    }

    @Test
    public void losCompuestosSePuedenAnidar() {
        // (A AND B) OR C, con A = true y B = false
        Criterio aYb = new CriterioAnd(criterios(criterioQueDevuelve(true), criterioQueDevuelve(false)));

        assertTrue(new CriterioOr(criterios(aYb, criterioQueDevuelve(true))).cumple(item));
        assertFalse(new CriterioOr(criterios(aYb, criterioQueDevuelve(false))).cumple(item));
    }
}
