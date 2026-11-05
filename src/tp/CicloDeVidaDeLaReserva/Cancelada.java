package tp.CicloDeVidaDeLaReserva;

import tp.NotificacionesReserva.*;

public class Cancelada extends EstadoReserva{

    public Cancelada(String nombre) {
        super(nombre);
    }

    //comportamiento relacionado con el observer
    public void notificar(DependencyTransformer dt){
        dt.cancelada(); 
    }    
}
