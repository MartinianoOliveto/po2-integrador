package tp.testCicloDeVidaDeLaReserva;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import tp.CicloDeVidaDeLaReserva.Periodo;

public class testPeriodo {

    private final LocalDate dia10 = LocalDate.of(2026, 12, 10);
    private final LocalDate dia13 = LocalDate.of(2026, 12, 13);
    private final Periodo estadia = new Periodo(dia10, dia13);

    @Test
    public void susDiasIncluyenElInicioYExcluyenElFin() {
        List<LocalDate> esperados = new ArrayList<>();
        esperados.add(dia10);
        esperados.add(LocalDate.of(2026, 12, 11));
        esperados.add(LocalDate.of(2026, 12, 12));
        assertEquals(esperados, estadia.dias());
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
        assertFalse(estadia.esElMismoQue(Periodo.unDia(dia10)));   // mismo inicio, distinto fin
    }

    @Test
    public void periodosQueEmpiezanDistintoNoSonElMismo() {
        assertFalse(estadia.esElMismoQue(new Periodo(LocalDate.of(2026, 12, 11), dia13)));   // distinto inicio
    }

    @Test
    public void unPeriodoEsIgualASiMismo() {
        assertTrue(estadia.equals(estadia));
    }

    @Test
    public void unPeriodoNoEsIgualANullNiAOtroTipoDeObjeto() {
        assertFalse(estadia.equals(null));
        assertFalse(estadia.equals(new Object()));
    }

    @Test
    public void periodosConFechasDistintasNoSonIguales() {
        assertNotEquals(estadia, Periodo.unDia(dia10));
    }
}
