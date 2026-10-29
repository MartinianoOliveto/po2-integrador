package tp.CicloDeVidaDeLaReserva;

import java.util.ArrayList;
import java.util.List;

import tp.CatalogoDeServiciosYPaquetes.Servicio;

public class Reserva {
    private EstadoReserva estado;
    private List<ServicioReserva> reservas = new ArrayList<ServicioReserva>();
    private List<Cupo> cupos = new ArrayList<Cupo>();

    public Reserva() {
        this.estado = new SolicitudPendiente();
    }

    // Pensar que el punto de entrada al contexto es el cliente. Toda
    // operacion de un estado es valido dentro de el, pero no toda operacion desde el contexto
    // es valida. Es por eso que el contexto delega en el estado, y se entiende por que deberian
    // haber validaciones.

    // Operaciones de dominio:
    public void confirmar(){

    }

    public void cancelar(){

    }

    public void checkin(){

    }

    // Operaciones del contexto:
    public void cambiarEstado(EstadoReserva estado){
        this.estado = estado;
    }
    
    public void agregarServicio(Servicio servicio, int cantidad){
        
    }
}
