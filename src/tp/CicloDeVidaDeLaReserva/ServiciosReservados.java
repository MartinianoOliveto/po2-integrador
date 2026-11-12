package tp.CicloDeVidaDeLaReserva;

import java.util.ArrayList;
import java.util.List;

import tp.CatalogoDeServiciosYPaquetes.Servicio;

public class ServiciosReservados {
    private final List<ItemReserva> items = new ArrayList<>();

    public void agregar(Servicio servicio, Periodo periodo) {
        if (items.stream().anyMatch(item -> item.esDe(servicio, periodo))) {
            throw new ReservaException("El servicio " + servicio.getNombre() + " ya está en la reserva en ese período");
        }
        items.add(new ItemReserva(servicio, periodo));
    }

    public void quitar(Servicio servicio, Periodo periodo) {
        if (!items.removeIf(item -> item.esDe(servicio, periodo))) {
            throw noEsta(servicio);
        }
    }

    public void marcarDisfrutado(Servicio servicio, Periodo periodo) {
        this.buscar(servicio, periodo).marcarDisfrutado();
    }

    public boolean estaVacio() {
        return items.isEmpty();
    }

    public double costoTotal(){
        return sumar(items);
    }

    public double costoNoDisfrutados() {
        return sumar(items.stream().filter(item -> !item.esDisfrutado()).toList());
    }

    public void bloquearCupos() {
        List<ItemReserva> bloqueados = new ArrayList<>();
        try {
            for (ItemReserva item : items) {
                item.bloquearCupo();
                bloqueados.add(item);
            }
        } catch (RuntimeException e) { // Hago rollback si el cliente reservo y justo no habian mas cupos para ese servicio
            bloqueados.forEach(item -> item.liberarCupo());
            throw e;
        }
    }

    void liberarCupos() {
        items.forEach(item -> item.liberarCupo());
    }

    // SUBTAREAS
    private ItemReserva buscar(Servicio servicio, Periodo periodo) {
        return items.stream()
                .filter(item -> item.esDe(servicio, periodo))
                .findFirst()
                .orElseThrow(() -> noEsta(servicio));
    }

    private static double sumar(List<ItemReserva> lista) {
        return lista.stream().mapToDouble(ItemReserva::subtotal).sum();
    }

    private ReservaException noEsta(Servicio servicio) {
        return new ReservaException("El servicio " + servicio.getNombre() + " no está en la reserva en ese período");
    }
}
