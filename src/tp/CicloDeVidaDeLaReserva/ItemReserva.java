package tp.CicloDeVidaDeLaReserva;

import java.math.BigDecimal;

public class ItemReserva {
    private final Servicio servicio;
    private int cantidad;
    private boolean disfrutado;

    ItemReserva(Servicio servicio, int cantidad) {
        this.servicio = servicio;
        this.cantidad = cantidad;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public boolean esDisfrutado() {
        return disfrutado;
    }

    public double subtotal() {
        return servicio.getPrecio() * this.getCantidad();
    }

    void sumarCantidad(int adicional) {
        this.cantidad += adicional;
    }

    void marcarDisfrutado() {
        this.disfrutado = true;
    }
}
