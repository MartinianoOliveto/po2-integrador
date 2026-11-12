package tp.CicloDeVidaDeLaReserva;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Periodo {
    private final LocalDate desde;
    private final LocalDate hasta;

    public Periodo(LocalDate desde, LocalDate hasta){
        this.desde = desde;
        this.hasta = hasta;
    }

    public LocalDate getDesde(){
        return desde;
    }
    public LocalDate getHasta(){
        return hasta;
    }

    // Para servicios de un solo dia
    public static Periodo unDia(LocalDate fecha) {
        return new Periodo(fecha, fecha.plusDays(1));
    }

    // Personalizo con mensaje de dominio para que quede mejor
    public boolean esElMismoQue(Periodo otro) {
        return desde.isEqual(otro.desde) && hasta.isEqual(otro.hasta);
    }

    public List<LocalDate> dias() {
        return desde.datesUntil(hasta).toList();
    }

    /** ¿Ese día está dentro del período? (incluye el inicio, excluye el fin) */
    public boolean incluye(LocalDate dia) {
        return !dia.isBefore(desde) && dia.isBefore(hasta);
    }

    // Redefino el equals y el hash para que java en listas pueda comparar
    @Override
    public boolean equals(Object o){
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Periodo otro = (Periodo) o; // getClass verifico pero igual sigue siendo Object, tengo que castearlo
        return esElMismoQue(otro);
    }

    @Override 
    public int hashCode(){
        return Objects.hash(desde, hasta);
    }

}
