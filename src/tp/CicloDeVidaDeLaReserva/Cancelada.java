package tp.CicloDeVidaDeLaReserva;

import tp.NotificacionesReserva.*;

public class Cancelada extends EstadoReserva{

    //comportamiento relacionado con el observer
    public void notificar(DependencyTransformer dt){
        dt.cancelada(); 
    }    
}
