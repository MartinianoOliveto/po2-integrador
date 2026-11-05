package tp.testCicloDeVidaDeLaReserva;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp.CatalogoDeServiciosYPaquetes.Servicio;
import tp.CicloDeVidaDeLaReserva.Reserva;
import tp.CatalogoDeServiciosYPaquetes.Servicio;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Se configura un escenario de prueba para Reserva que consiste en:
 * Dos reservas de un hotel a $15.000 cada uno
 * Una reserva de una excursion a $4.000
 * Tasas administrativas de $1.000 = $34.000 de servicios + $1.000 de tasas = $35.000
 */
public class TestReserva {

    private Servicio hotel;
    private Servicio excursion;
    private Reserva reserva;

    @BeforeEach
    void setUp() {
        hotel = mock(Servicio.class);
        excursion = mock(Servicio.class);
        when(hotel.getPrecio()).thenReturn(15000.0);
        when(excursion.getPrecio()).thenReturn(4000.0);

        reserva = new Reserva(1000.0);
        reserva.agregarServicio(hotel, 2);
        reserva.agregarServicio(excursion, 1);
    }

    private void llevarAEnCurso() {
        reserva.confirmar();
        reserva.checkin();
        reserva.inciar();
    }

    // Podria preguntar por cada estado si es el esperado. Pero no quiero usar instanceof, por lo que
    // tendre que usar enums para identificarlos, pero no estan implementados. Los dejo para despues
    // TO DO: Probar casos borde exitosos: Que comience en pendiente y termine en finalizada
    @Test
    public void testBloqueaElCupoDeCadaServicio() {
        reserva.confirmar();

        verify(hotel).bloquearCupo(2);
        verify(excursion).bloquearCupo(1);
    }

    @Test
    public void testSiUnServicioNoTieneCupoSeLiberaLoYaBloqueado() {
        doThrow(new ReservaException("No hay cupo")).when(hotel).bloquearCupo(2);
    }

}
