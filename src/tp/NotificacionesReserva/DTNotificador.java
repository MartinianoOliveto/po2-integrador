package tp.NotificacionesReserva;
import tp.CicloDeVidaDeLaReserva.*;

public class DTNotificador extends DependencyTransformer{
    public DTNotificador(Subsistema target) {
        super(target);
    }
    @Override 
    public void confirmada(Reserva r){
        target.actualizar(r);
    }
    @Override 
    public void enCurso(Reserva r){
        target.actualizar(r);
    }
    @Override 
    public void finalizada(Reserva r){
        target.actualizar(r);
    }
}
