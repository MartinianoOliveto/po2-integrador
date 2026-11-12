package tp.testCicloDeVidaDeLaReserva;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp.CicloDeVidaDeLaReserva.CalendarioDeCupos;
import tp.CicloDeVidaDeLaReserva.Periodo;

public class testCalendarioDeCupos {

    private final LocalDate dia10 = LocalDate.of(2026, 12, 10);
    private final LocalDate dia11 = LocalDate.of(2026, 12, 11);
    private final LocalDate dia13 = LocalDate.of(2026, 12, 13);
    private final Periodo del10Al13 = new Periodo(dia10, dia13);

    private CalendarioDeCupos calendario;

    @BeforeEach
    public void setUp() {
        calendario = new CalendarioDeCupos(2);   // 2 lugares por dia
    }

    @Test
    public void porDefectoTiene20Lugares() {
        assertEquals(20, new CalendarioDeCupos().capacidad());
    }

    @Test
    public void bloquearOcupaUnLugarSoloEnLosDiasDelPeriodo() {
        calendario.bloquear(del10Al13);

        assertEquals(1, calendario.disponibles(dia10));
        assertEquals(2, calendario.disponibles(dia13));   // el dia de salida queda libre
    }

    @Test
    public void sinLugarEnUnDiaNoSePuedeBloquearElPeriodo() {
        calendario.bloquear(Periodo.unDia(dia11));
        calendario.bloquear(Periodo.unDia(dia11));   // el 11 queda lleno

        assertFalse(calendario.hayCupo(del10Al13));
        assertThrows(RuntimeException.class, () -> calendario.bloquear(del10Al13));
        assertEquals(2, calendario.disponibles(dia10));   // el 10 no se toco
    }

    @Test
    public void periodosQueNoSeSuperponenNoCompitenPorElCupo() {
        CalendarioDeCupos unLugar = new CalendarioDeCupos(1);

        unLugar.bloquear(del10Al13);
        unLugar.bloquear(Periodo.unDia(dia13));   // entra el mismo dia que sale el anterior

        assertEquals(0, unLugar.disponibles(dia13));
    }

    @Test
    public void liberarDevuelveElLugar() {
        calendario.bloquear(del10Al13);

        calendario.liberar(del10Al13);

        assertEquals(2, calendario.disponibles(dia11));
    }

    @Test
    public void noSePuedeLiberarUnPeriodoQueNoSeBloqueo() {
        assertThrows(RuntimeException.class, () -> calendario.liberar(del10Al13));
    }
}
