package tp.NotificacionesReserva;
import tp.CicloDeVidaDeLaReserva.*;

public abstract class DependencyTransformer implements Observador{
    protected Subsistema target;

    @Override
    public void actualizar(Sujeto s) {
        s.delegarNotificacion(this);
    }
    
    public void confirmada(Reserva r){

    }
    public void enCheckin(Reserva r){

    }
    public void enCurso(Reserva r){

    }
    public void finalizada(Reserva r){

    }
    public void cancelada(Reserva r){

    }

    public DependencyTransformer(Subsistema target){
        this.target = target; 
    }
}
