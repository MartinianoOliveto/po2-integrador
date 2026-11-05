package tp.CicloDeVidaDeLaReserva;

import tp.NotificacionesReserva.DependencyTransformer;

public class Finalizada extends EstadoReserva{
    //comportamiento relacionado con el observer 
    public void notificar(DependencyTransformer dt){
        dt.finalizada();
    }
}
