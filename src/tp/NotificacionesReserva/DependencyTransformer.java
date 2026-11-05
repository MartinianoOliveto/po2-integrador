package tp.NotificacionesReserva;

public abstract class DependencyTransformer implements Observador{
    protected Subsistema target;

    @Override
    public void actualizar(Sujeto s) {
        s.delegarNotificacion(this);
    }

    public DependencyTransformer(Subsistema target){
        this.target = target; 
    }
}
