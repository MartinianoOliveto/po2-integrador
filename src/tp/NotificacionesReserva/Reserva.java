package tp.NotificacionesReserva;

import java.util.List;

public class Reserva extends Sujeto{
    /*Ahora dependeria del estado, supongo, si es CONFIRMADA: EN CURSO
    o finalizada, debe mandar el mail */ 
    public Reserva(List<Observador>o){
        this.observadores = o; 
    }
}
