package tp.CicloDeVidaDeLaReserva;

import tp.NotificacionesReserva.DependencyTransformer;

public class Finalizada extends EstadoReserva{
    //comportamiento relacionado con el observer 
    @Override 
    public void notificar(DependencyTransformer dt,Reserva r){
        dt.finalizada(r);
    }
}
