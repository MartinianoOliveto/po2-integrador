package tp.CicloDeVidaDeLaReserva;

public abstract class EstadoReserva {
    protected String nombre;

    public EstadoReserva(String nombre) {
        this.nombre = nombre;
    }

    public void confirmar(Reserva reserva) {
        throw new EstadoReservaException("Error: No se puede confirmar la reserva en el estado " + this.getNombre());
    }
    public void cancelar(Reserva reserva) {
        throw new EstadoReservaException("Error: No se puede cancelar la reserva en el estado " + this.getNombre());
    }
    public void checkin(Reserva reserva) {
        throw new EstadoReservaException("Error: No se puede hacer checkin de la reserva en el estado " + this.getNombre());
    }
    
    public String getNombre() {
        return nombre;
    }
}
