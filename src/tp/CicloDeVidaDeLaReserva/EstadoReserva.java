package tp.CicloDeVidaDeLaReserva;
import tp.NotificacionesReserva.*;

public abstract class EstadoReserva {
    protected String nombre;

    public EstadoReserva(String nombre) {
        this.nombre = nombre;
    }

    public void agregarServicio(Reserva reserva, Servicio servicio, int cantidad){
        throw new ReservaException("Error: No se puede agregar servicios en " + this.getNombre());
    }

    public void quitarServicio(Reserva reserva, Servicio servicio, int cantidad){
        throw new ReservaException("Error: No se puede agregar servicios en " + this.getNombre());
    }

    public void confirmar(Reserva reserva) {
        throw new ReservaException("Error: No se puede confirmar la reserva en " + this.getNombre());
    }

    public void cancelar(Reserva reserva) {
        throw new ReservaException ("Error: No se puede cancelar la reserva en " + this.getNombre());
    }
    public void checkin(Reserva reserva) {
        throw new ReservaException("Error: No se puede hacer checkin en " + this.getNombre());
    }
    
    public void iniciar(Reserva reserva){
        throw new ReservaException("Error: No se puede iniciar el viaje en " + this.getNombre());
    }
    
    public void finalizar(Reserva reserva){
        throw new ReservaException("Error: No se puede finalizar el viaje en " + this.getNombre());
    }

    public void registrarDisfrutado(Reserva reserva){
        throw new ReservaException("Error: No se puede registrar como disfrutado en " + this.getNombre());
    }
    
    public String getNombre() {
        return nombre;
    }
    public void notificar(Observador dt){

    }
}
