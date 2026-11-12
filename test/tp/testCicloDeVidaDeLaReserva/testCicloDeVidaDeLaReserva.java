package tp.testCicloDeVidaDeLaReserva;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp.CatalogoDeServiciosYPaquetes.Servicio;
import tp.CicloDeVidaDeLaReserva.Cancelada;
import tp.CicloDeVidaDeLaReserva.Confirmada;
import tp.CicloDeVidaDeLaReserva.EnCheckin;
import tp.CicloDeVidaDeLaReserva.EnCurso;
import tp.CicloDeVidaDeLaReserva.Finalizada;
import tp.CicloDeVidaDeLaReserva.Periodo;
import tp.CicloDeVidaDeLaReserva.Reserva;
import tp.CicloDeVidaDeLaReserva.ReservaException;
import tp.CicloDeVidaDeLaReserva.SolicitudPendiente;

/**
 * Ciclo de vida de la reserva (patron State).
 *
 * Los servicios son mocks: asi se prueba solo la reserva (no el catalogo del 2.1)
 * y se puede verificar con que le habla la reserva a cada servicio.
 */
public class testCicloDeVidaDeLaReserva {

    private static final double TOLERANCIA = 0.001;

    private final Periodo estadia = new Periodo(LocalDate.of(2026, 12, 10), LocalDate.of(2026, 12, 13));
    private final Periodo diaExcursion = Periodo.unDia(LocalDate.of(2026, 12, 11));

    private Servicio hotel;       // $15.000 por la estadia
    private Servicio excursion;   // $4.000 el dia de la excursion
    private Reserva reserva;      // servicios $19.000 + tasas $1.000 = $20.000

    @BeforeEach
    public void setUp() {
        hotel = mock(Servicio.class);
        excursion = mock(Servicio.class);
        when(hotel.getPrecioFinal()).thenReturn(15000.0);
        when(excursion.getPrecioFinal()).thenReturn(4000.0);

        reserva = new Reserva(1000);
        reserva.agregarServicio(hotel, estadia);
        reserva.agregarServicio(excursion, diaExcursion);
    }

    private void llevarAEnCurso() {
        reserva.confirmar();
        reserva.checkin();
        reserva.iniciar();
    }

    // ---------------- Flujo normal ----------------

    @Test
    public void unaReservaNuevaEstaPendiente() {
        assertInstanceOf(SolicitudPendiente.class, new Reserva(0).getEstado());
    }

    @Test
    public void recorreElCicloCompletoHastaFinalizada() {
        reserva.confirmar();
        assertInstanceOf(Confirmada.class, reserva.getEstado());
        reserva.checkin();
        assertInstanceOf(EnCheckin.class, reserva.getEstado());
        reserva.iniciar();
        assertInstanceOf(EnCurso.class, reserva.getEstado());
        reserva.finalizar();
        assertInstanceOf(Finalizada.class, reserva.getEstado());
    }

    @Test
    public void elCostoTotalSumaServiciosYTasas() {
        assertEquals(20000, reserva.costoTotal(), TOLERANCIA);
    }

    @Test
    public void quitarUnServicioLoSacaDelCosto() {
        reserva.quitarServicio(excursion, diaExcursion);

        assertEquals(15000, reserva.costoServicios(), TOLERANCIA);
    }

    @Test
    public void noSePuedeAgregarDosVecesElMismoServicioEnElMismoPeriodo() {
        assertThrows(ReservaException.class, () -> reserva.agregarServicio(hotel, estadia));
    }

    // ---------------- Cupos ----------------

    @Test
    public void confirmarBloqueaElCupoDeCadaServicioEnSuPeriodo() {
        reserva.confirmar();

        verify(hotel).bloquearCupo(estadia);
        verify(excursion).bloquearCupo(diaExcursion);
    }

    @Test
    public void siUnServicioNoTieneCupoSeLiberaLoYaBloqueadoYSiguePendiente() {
        doThrow(new RuntimeException("No hay cupo disponible")).when(excursion).bloquearCupo(diaExcursion);

        assertThrows(RuntimeException.class, () -> reserva.confirmar());

        verify(hotel).liberarCupo(estadia);   // el hotel se habia bloqueado antes de fallar
        assertInstanceOf(SolicitudPendiente.class, reserva.getEstado());
    }

    @Test
    public void noSePuedeConfirmarUnaReservaVacia() {
        Reserva vacia = new Reserva(0);

        assertThrows(ReservaException.class, () -> vacia.confirmar());
    }

    // ---------------- Operaciones invalidas ----------------

    @Test
    public void soloSePuedenAgregarServiciosEnPendiente() {
        reserva.confirmar();

        assertThrows(ReservaException.class, () -> reserva.agregarServicio(hotel, diaExcursion));
    }

    @Test
    public void noSePuedeSaltearUnEstado() {
        assertThrows(ReservaException.class, () -> reserva.checkin());
        assertInstanceOf(SolicitudPendiente.class, reserva.getEstado());
    }

    @Test
    public void soloSePuedeRegistrarDisfrutadoDuranteElViaje() {
        reserva.confirmar();

        assertThrows(ReservaException.class, () -> reserva.registrarDisfrutado(hotel, estadia));
    }

    @Test
    public void unaReservaFinalizadaNoSePuedeCancelar() {
        llevarAEnCurso();
        reserva.finalizar();

        assertThrows(ReservaException.class, () -> reserva.cancelar());
    }

    @Test
    public void unaReservaCanceladaNoSePuedeConfirmar() {
        reserva.cancelar();

        assertThrows(ReservaException.class, () -> reserva.confirmar());
    }

    // ---------------- Cancelar: distinto comportamiento segun el estado ----------------

    @Test
    public void cancelarDesdePendienteNoLiberaCupoNiReembolsa() {
        reserva.cancelar();

        assertInstanceOf(Cancelada.class, reserva.getEstado());
        verify(hotel, never()).liberarCupo(estadia);
        assertTrue(reserva.getVouchers().isEmpty());
    }

    @Test
    public void cancelarDesdeConfirmadaLiberaCupoYReembolsaTodo() {
        reserva.confirmar();
        reserva.cancelar();

        verify(hotel).liberarCupo(estadia);
        verify(excursion).liberarCupo(diaExcursion);
        assertEquals(20000, reserva.getVouchers().get(0).getMonto(), TOLERANCIA);
    }

    @Test
    public void cancelarEnCheckinLiberaCupoYReembolsaServiciosYTasas() {
        reserva.confirmar();
        reserva.checkin();
        reserva.cancelar();

        verify(hotel).liberarCupo(estadia);
        assertEquals(20000, reserva.getVouchers().get(0).getMonto(), TOLERANCIA);
    }

    @Test
    public void cancelarEnCursoReembolsaSoloLoNoDisfrutadoYSinTasas() {
        llevarAEnCurso();
        reserva.registrarDisfrutado(hotel, estadia);
        reserva.cancelar();

        assertEquals(4000, reserva.getVouchers().get(0).getMonto(), TOLERANCIA);   // solo la excursion
        verify(hotel, never()).liberarCupo(estadia);
    }
}
