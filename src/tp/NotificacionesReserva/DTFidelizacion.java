package tp.NotificacionesReserva;
import tp.CicloDeVidaDeLaReserva.*;

public class DTFidelizacion extends DependencyTransformer {

    public DTFidelizacion(Subsistema target){
        super(target); 
    }
    @Override 
    public void cancelada(Reserva r){
        target.actualizar(r); 
    }

}
