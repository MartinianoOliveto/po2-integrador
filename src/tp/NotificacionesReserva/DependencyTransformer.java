package tp.NotificacionesReserva;
import tp.CicloDeVidaDeLaReserva.*;

public abstract class DependencyTransformer implements Observador{
    protected Subsistema target;

    @Override
    public void actualizar(Sujeto s) {
        s.delegarNotificacion(this);
    }
    /* Los distintos Dts van a implementar las que le interesan, puse 1 por estado
    desventaja: si se agrega un estado, se debe agregar aca
    Preguntar mañana si esta bien*/
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
