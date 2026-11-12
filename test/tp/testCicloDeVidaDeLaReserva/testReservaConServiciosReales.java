package tp.testCicloDeVidaDeLaReserva;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp.CatalogoDeServiciosYPaquetes.Servicio;
import tp.CicloDeVidaDeLaReserva.Periodo;
import tp.CicloDeVidaDeLaReserva.Reserva;
import tp.CicloDeVidaDeLaReserva.SolicitudPendiente;

/**
 * Tests de integracion: Reserva + Servicio del 2.1 + CalendarioDeCupos reales, sin mocks.
 * testCicloDeVidaDeLaReserva verifica CON QUE le habla la reserva a los servicios;
 * estos verifican que el cupo realmente cambia cuando los objetos colaboran.
 */
public class testReservaConServiciosReales {

    private final LocalDate dia10 = LocalDate.of(2026, 12, 10);
    private final LocalDate dia11 = LocalDate.of(2026, 12, 11);
    private final Periodo estadia = new Periodo(dia10, LocalDate.of(2026, 12, 13));
    private final Periodo diaExcursion = Periodo.unDia(dia11);

    private Servicio hotel;       // cada servicio arranca con 20 lugares por dia
    private Servicio excursion;
    private Reserva reserva;

    @BeforeEach
    public void setUp() {
        hotel = new Servicio("Hotel Central", 1, "Noche en el hotel", "Operador", "ALOJAMIENTO", 15000, 0);
        excursion = new Servicio("Museo", 2, "Excursion guiada", "Operador", "EXCURSION", 4000, 0);

        reserva = new Reserva(1000);
        reserva.agregarServicio(hotel, estadia);
        reserva.agregarServicio(excursion, diaExcursion);
    }

    @Test
    public void confirmarOcupaElCupoDeLosServicios() {
        reserva.confirmar();

        assertEquals(19, hotel.cuposDisponibles(dia10));
        assertEquals(19, excursion.cuposDisponibles(dia11));
    }

    @Test
    public void cancelarUnaReservaConfirmadaDevuelveElCupo() {
        reserva.confirmar();
        reserva.cancelar();

        assertEquals(20, hotel.cuposDisponibles(dia10));
        assertEquals(20, excursion.cuposDisponibles(dia11));
    }

    @Test
    public void siLaExcursionEstaLlenaNoQuedaNadaBloqueado() {
        for (int i = 0; i < 20; i++) {
            excursion.bloquearCupo(diaExcursion);   // otras reservas llenan la excursion
        }

        assertThrows(RuntimeException.class, () -> reserva.confirmar());

        assertEquals(20, hotel.cuposDisponibles(dia10));   // el hotel se libero
        assertInstanceOf(SolicitudPendiente.class, reserva.getEstado());
    }
}
