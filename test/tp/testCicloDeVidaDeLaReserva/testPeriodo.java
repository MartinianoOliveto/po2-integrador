package tp.testCicloDeVidaDeLaReserva;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;

import tp.CicloDeVidaDeLaReserva.Periodo;

public class testPeriodo {

    private final LocalDate dia10 = LocalDate.of(2026, 12, 10);
    private final LocalDate dia13 = LocalDate.of(2026, 12, 13);
    private final Periodo estadia = new Periodo(dia10, dia13);

    @Test
    public void susDiasIncluyenElInicioYExcluyenElFin() {
        assertEquals(List.of(dia10, LocalDate.of(2026, 12, 11), LocalDate.of(2026, 12, 12)), estadia.dias());
    }

    @Test
    public void incluyeSoloLosDiasDentroDelPeriodo() {
        assertTrue(estadia.incluye(dia10));                        // el inicio si
        assertFalse(estadia.incluye(dia13));                       // el fin no
        assertFalse(estadia.incluye(LocalDate.of(2026, 12, 9)));
    }

    @Test
    public void dosPeriodosConLasMismasFechasSonElMismo() {
        Periodo otro = new Periodo(dia10, dia13);

        assertTrue(estadia.esElMismoQue(otro));
        assertEquals(estadia, otro);                         // equals delega en esElMismoQue
        assertEquals(estadia.hashCode(), otro.hashCode());   // contrato equals / hashCode
    }

    @Test
    public void periodosConFechasDistintasNoSonElMismo() {
        assertFalse(estadia.esElMismoQue(Periodo.unDia(dia10)));
    }
}
