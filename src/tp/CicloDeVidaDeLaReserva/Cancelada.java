package tp.CicloDeVidaDeLaReserva;

import tp.NotificacionesReserva.*;

public class Cancelada extends EstadoReserva{

    public Cancelada(String nombre) {
        super(nombre);
    }

    //comportamiento relacionado con el observer
    @Override
    public void notificar(DependencyTransformer dt,Reserva r){
        dt.cancelada(r); 
    }    
}
