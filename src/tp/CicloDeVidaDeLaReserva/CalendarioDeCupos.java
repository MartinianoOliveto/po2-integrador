package tp.CicloDeVidaDeLaReserva;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CalendarioDeCupos {

    private final int capacidad;
    private final List<Periodo> bloqueados = new ArrayList<Periodo>();

    // Por default
    public CalendarioDeCupos(){
        this.capacidad = 20;
    }
    public CalendarioDeCupos(int capacidad) {
        this.capacidad = capacidad;
    }

    public int capacidad() {
        return capacidad;
    }

    public int ocupados(LocalDate dia) {
        return (int) bloqueados.stream().filter(periodo -> periodo.incluye(dia)).count();
    }

    public int disponibles(LocalDate dia) {
        return capacidad - ocupados(dia);
    }

    public boolean hayCupo(Periodo periodo) {
        return periodo.dias().stream().allMatch(dia -> disponibles(dia) > 0);
    }

    public boolean tieneCupoEnAlgunaFecha() {
        return capacidad > 0;
    }

    public void bloquear(Periodo periodo) {
        if (!hayCupo(periodo)) {
            throw new RuntimeException("No hay cupo disponible")
        }
        bloqueados.add(periodo);
    }

    /** Devuelve el lugar. remove compara con equals, que el record Periodo define por fechas. */
    public void liberar(Periodo periodo) {
        if (!bloqueados.remove(periodo)) {
            throw new RuntimeException("Ese período no tenía un cupo bloqueado");
        }
    }
}