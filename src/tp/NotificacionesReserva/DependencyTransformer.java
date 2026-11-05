package tp.NotificacionesReserva;

public abstract class DependencyTransformer implements Observador{
    protected Subsistema target;

    @Override
    public void actualizar(Sujeto s) {
        s.delegarNotificacion(this);
    }
    /* Los distintos Dts van a implementar las que le interesan, puse 1 por estado
    desventaja: si se agrega un estado, se debe agregar aca
    Preguntar mañana si esta bien*/
    public void solicitudPendiente(){

    }
    public void confirmada(){

    }
    public void enCheckin(){

    }
    public void enCurso(){

    }
    public void finalizada(){

    }
    public void cancelada(){

    }

    public DependencyTransformer(Subsistema target){
        this.target = target; 
    }
}
